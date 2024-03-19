package com.lucatic.grupo2.app.users.control;

import com.lucatic.grupo2.app.users.exceptions.UserException;
import com.lucatic.grupo2.app.users.models.User;
import com.lucatic.grupo2.app.users.models.adapter.UserAdapter;
import com.lucatic.grupo2.app.users.models.dto.UserExistResponseWithError;
import com.lucatic.grupo2.app.users.models.dto.UserRequest;
import com.lucatic.grupo2.app.users.models.dto.UserResponseWithError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.lucatic.grupo2.app.users.exceptions.EmptyListException;
import com.lucatic.grupo2.app.users.exceptions.UserExistException;
import com.lucatic.grupo2.app.users.exceptions.UserNameException;
import com.lucatic.grupo2.app.users.service.UserService;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Clase controladora, toma las decisiones de la aplicacion
 *
 * @author BlueDevTeam
 * @version 1.0.0
 * @since 18-03-2024
 */
@RestController
@RequestMapping("/user")
public class UserController {

	/**
	 * Logger que registra los errores de clase UserController
	 */
	private final static Logger LOGGER = LogManager.getLogger(UserController.class);

	/**
	 * Auto instanciamos el servicio de usuarios
	 */
	@Autowired
	private UserService userService;

	/**
	 * Adaptador con transformacion de entidad User a UserResponse y UserRequest a
	 * entidad User
	 */
	@Autowired
	private UserAdapter userAdapter;

	/**
	 * Guarda un request body de un nuevo usuario en la base de datos usersdb
	 * 
	 * @param eventRequest Con los datos del User a guardar
	 * @return ResponseEntity Con la respuesta de guardar el usuario
	 * @throws UserExistException cuando no se guardo correctamente
	 */
	@Operation(summary = "Dar de alta un usuario", description = "Incluye un nuevo usuario en la base de datos", tags = {
			"event" })
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Usuario creado correctamente", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = UserResponseWithError.class)) }),

			@ApiResponse(responseCode = "400", description = "El usuario ya existe", content = @Content),
			@ApiResponse(responseCode = "500", description = "Error genérico en alta usuario", content = @Content)

	})
	@PostMapping
	public ResponseEntity<?> save(@Valid @RequestBody UserRequest userRequest) throws UserException {

		try {
			User user = userService.save(userRequest);

			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId())
					.toUri();
			LOGGER.info("User " + user.getName() + " with id " + user.getId() + " has been created");
			return ResponseEntity.created(location).body(userAdapter.toUserResponseWithError(user));

		} catch (UserExistException e) {
			LOGGER.warn("Error pushing the event" + e.getMessage());
			throw e;
		} catch (UserException e) {
			LOGGER.warn("Error en dar de alta usuario " + e.getMessage());
			throw e;
		}
	}

	/**
	 * Lista todos los usuarios que estan guardados en la bbdd
	 * 
	 * @return ResponseEntity con el response de usuarios
	 * @throws EmptyListException cuando no devuelve elementos de la lista usuarios
	 */
	@Operation(summary = "Listar todos los usuarios", description = "Devuelve un listado de todos los usuarios existentes", tags = {
			"event" })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Users listados", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = UserResponseWithError.class)))),
			@ApiResponse(responseCode = "404", description = "No hay usuarios", content = @Content),
			@ApiResponse(responseCode = "500", description = "Error genérico listando usuarios", content = @Content)

	})
	@GetMapping("/all")
	public ResponseEntity<?> listAll() throws EmptyListException {
// return productAdapter.convertToDto(productService.getAll());
		try {
			List<User> users = userService.findAll();
			List<UserResponseWithError> usersResponseWithError = users.stream()
					.map(c -> userAdapter.toUserResponseWithError(c)).collect(Collectors.toList());
			LOGGER.info("Find all success");
			return ResponseEntity.ok(usersResponseWithError);

		} catch (EmptyListException e) {
			LOGGER.warn("Error, it couldn't list any user" + e.getMessage());
			throw e;
		}
	}

	@Operation(summary = "Comprueba la existencia de un usuario por id", description = "Devuelve la existencia de un usuario", tags = {
			"event" })
	@ApiResponses(value = {
			@ApiResponse(description = "Comprueba usuario", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = UserExistResponseWithError.class))),
			@ApiResponse(responseCode = "404", description = "No hay usuarios", content = @Content),
			@ApiResponse(responseCode = "500", description = "Error genérico listando usuarios", content = @Content)

	})
	@GetMapping("/exist/{id}")
	public ResponseEntity<?> userFindById(@PathVariable long id) {
		if (userService.userFindById(id)) {

			return ResponseEntity.ok(userAdapter.toExitUserResponseWithError(true));
		}
		return ResponseEntity.ok(userAdapter.toExitUserResponseWithError(false));
	}

	@GetMapping("/getname/{id}")
	public ResponseEntity<?> userFindByText(@PathVariable long id) throws UserNameException {

		return ResponseEntity.ok(userAdapter.toTextUserResponseWithError(userService.findById(id).getName()));

	}

}
