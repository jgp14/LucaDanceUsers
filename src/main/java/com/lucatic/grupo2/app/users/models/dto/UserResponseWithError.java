package com.lucatic.grupo2.app.users.models.dto;

import com.lucatic.grupo2.app.users.models.Error;
import com.lucatic.grupo2.app.users.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clase modelo DTO UserResponseWithError para las respuestas. Posee los
 * getters, setters y constructores generados por Lombok @Data
 * 
 * @author BlueDevTeams
 * @version v1.0.0
 * @since 18-03-2024
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseWithError {

	/**
	 * Atributo con objeto Error
	 */
	private Error error;
	/**
	 * Atributo con objeto UserResponse
	 */
	private UserResponse userResponse;
	/**
	 * Atributo con boolean para decidir si es o no un error
	 */
	private boolean isErrorBool;

}
