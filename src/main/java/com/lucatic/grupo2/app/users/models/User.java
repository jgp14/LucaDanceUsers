package com.lucatic.grupo2.app.users.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Clase modelo Entity de User para la bbdd, requests y responses. Posee los
 * getters, setters y constuctores generados por Lombok
 * 
 * @author BlueDevTeams
 * @version v1.0.0
 * @since 18-03-2024
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

	/**
	 * Atributo Long id autoincremental de los usuarios.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * Atributo String name con el nombre del usuario
	 */
	private String name;

	/**
	 * Atributo String lastName con los apellidos del usuario
	 */
	@Column(name = "last_name")
	private String lastName;

	/**
	 * Atributo String email con la direccion de correo del usuario
	 */
	private String email;

	/**
	 * Atributo String password con la contrasenha del usuario
	 */
	private String password;

	/**
	 * Atributo LocalDateTime registerDate con la fecha y hora de reistro
	 */
	@Column(name = "register_date")
	private LocalDateTime registerDate;

}
