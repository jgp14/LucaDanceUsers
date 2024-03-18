package com.lucatic.grupo2.app.users.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clase modelo DTO UserResponse para lass respuestas en relacion con
 * usuarios.Tiene implementados getters, setters toString y constructores
 * generados por Lombok @Data
 * 
 * @author BlueDevTeams
 * @version v1.0.0
 * @since 18-03-2024
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
	/**
	 * Atributo id del usuario
	 */
	private Long id;
	/**
	 * Atributo con el nombre del usuario
	 */
	private String name;
	/**
	 * Atributo con el apellido del usuario
	 */
	private String lastName;
	/**
	 * Atributo con el email del usuario
	 */
	private String email;
	/**
	 * Atributo con el password del usuario
	 */
	private String password;
	/**
	 * Atributo con la fecha de registro
	 */
	// Formato fecha hora dd-MM-yyyy HH:mm
	private String registerDate;
}
