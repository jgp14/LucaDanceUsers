package com.lucatic.grupo2.app.users.control;

import com.lucatic.grupo2.app.users.models.User;
import com.lucatic.grupo2.app.users.models.adapter.UserAdapter;
import com.lucatic.grupo2.app.users.models.dto.UserRequest;
import com.lucatic.grupo2.app.users.models.dto.UserResponseWithError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.lucatic.grupo2.app.users.adapter.UserAdapter;
import com.lucatic.grupo2.app.users.service.UserService;

import java.net.URI;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestBody;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
@RestController
@RequestMapping("/user")
public class UserController  {
	private final static Logger LOGGER = LogManager.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@Autowired
	private UserAdapter userAdapter;
	
	@Operation(summary = "Dar de alta un usuario", description = "Incluye un nuevo usuario en la base de datos", tags = {
	"event" })
	@ApiResponses(value = {
	@ApiResponse(responseCode = "200", description = "Usuario creado correctamente", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = UserResponseWithError.class)) }),

	@ApiResponse(responseCode = "400", description = "El usuario ya existe", content = @Content),
	@ApiResponse(responseCode = "500", description = "Error genérico en alta usuario", content = @Content)

})
@PostMapping
public ResponseEntity<?> save(@Valid @RequestBody UserRequest userRequest) throws UserExistException {

try {
	User user = userService.save(userRequest);
	URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId())
			.toUri();
	LOGGER.info("User " + user.getName() + " with id " + user.getId() + " has been created");
	return ResponseEntity.created(location).body(userAdapter.toEventResponseWithError(user));

} catch (UserExistException e) {
	LOGGER.warn("Error pushing the event" + e.getMessage());
	throw e;
}

}
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
	List<User> users= userService.findAll();
	List<UserResponseWithError> usersResponseWithError = events.stream()
			.map(c -> userAdapter.toUserResponseWithError(c)).collect(Collectors.toList());
	LOGGER.info("Find all success");
	return ResponseEntity.ok(usersResponseWithError);

} catch (EmptyListException e) {
	LOGGER.warn("Error, it couldn't list any user" + e.getMessage());
	throw e;
}
}

}
