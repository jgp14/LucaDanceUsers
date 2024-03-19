package com.lucatic.grupo2.app.users.models.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clase modelo DTO UserRequest para peticiones. Tiene implementados getters,
 * setters toString y constructores generados por Lombok @Data
 * 
 * @author BlueDevTeams
 * @version v1.0.0
 * @since 18-03-2024
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
	/**
	 * Atributo con el nombre de usuario
	 */
	@NotEmpty
	private String name;
	/**
	 * Atributo con el apellido del usuario
	 */
	@NotEmpty
	private String lastName;
	/**
	 * Atributo con el email del usuario
	 */
	@NotEmpty
	private String email;
	/**
	 * Atributo con el password del usuario
	 */
	@NotEmpty
	private String password;

	// Formato fecha dd-MM-yyyy HH:mm
	@NotBlank
	private String registerDate;
}
