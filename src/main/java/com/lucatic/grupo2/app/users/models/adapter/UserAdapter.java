package com.lucatic.grupo2.app.users.models.adapter;

import com.lucatic.grupo2.app.users.models.User;
import com.lucatic.grupo2.app.users.models.dto.StringResponseWithError;
import com.lucatic.grupo2.app.users.models.dto.UserExistResponseWithError;
import com.lucatic.grupo2.app.users.models.dto.UserRequest;
import com.lucatic.grupo2.app.users.models.dto.UserResponse;
import com.lucatic.grupo2.app.users.models.dto.UserResponseWithError;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Clase adaptadora UserAdapter. Encargada de transformacion de objetos de datos
 * entre clases DTOs
 * 
 * @author BlueDevTeams
 * @version v1.0.0
 * @since 18-03-2024
 */

@Component
public class UserAdapter {
	/**
	 * Transforma un objeto User a un objeto UserResponseWithError
	 * 
	 * @param user objeto de tipo usuario
	 * @return devuelve un objeto de tipo UserResponseWithError
	 */
	public UserResponseWithError toUserResponseWithError(User user) {
		UserResponse userResponse = new UserResponse();

		userResponse.setId(user.getId());
		userResponse.setEmail(user.getEmail());
		userResponse.setLastName(user.getLastName());
		userResponse.setName(user.getName());
		userResponse.setRegisterDate(user.getRegisterDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")));
		userResponse.setPassword(user.getPassword());

		return new UserResponseWithError(null, List.of(userResponse), false);
	}

	/**
	 * Encargado de transformar de UserRequest a objeto User
	 * 
	 * @param eventRequest recibe un UserRequest a transformar
	 * @return devuelve un objeto User transformado
	 */
	public User fromUserRequest(UserRequest eventRequest) {

		User user = new User();

		user.setEmail(eventRequest.getEmail());
		user.setLastName(eventRequest.getLastName());
		user.setName(eventRequest.getName());
		user.setPassword(eventRequest.getPassword());
		user.setRegisterDate(
				LocalDateTime.parse(eventRequest.getRegisterDate(), DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")));

		return user;
	}

	/**
	 * Método de conversión a través de un boolean
	 * 
	 * @param userExist recibe un boolean segun la existencia de un usuario
	 * @return devuelve el objeto de tipo UserExistResponseWithError
	 */
	public UserExistResponseWithError toExitUserResponseWithError(boolean userExist) {

		return new UserExistResponseWithError(null, userExist, false);
	}
	/**
	 * Gestiona respuesta segun el nombre de texto que recibe como parámetro
	 * @param userText recibe el nombre de un usuario
	 * @return devuelve un objeto de tipo StringResponseWithError
	 */
	public StringResponseWithError toTextUserResponseWithError(String userText) {

		return new StringResponseWithError(null, userText, false);
	}

	public UserResponse toUserResponse(User u) {
		return new UserResponse(u.getId(), u.getName(), u.getLastName(), u.getEmail(), u.getPassword(), u.getRegisterDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));
	}
}
