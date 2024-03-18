package com.lucatic.grupo2.app.users.exceptions;

/**
 * Clase personalizada de manejo de excepciones relacionados con los usuarios
 *
 * @author BlueDevTeams
 * @version v1.0.0
 * @since 18-03-2024
 */
public class UserException extends Exception {

	/**
	 * Genera un serialVersionUID para la excepcion personalizada
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor que recibe un mensaje del fallo
	 * 
	 * @param message descriptivo con el error en relacion al usuario.
	 */
	public UserException(String message) {
		super(message);
	}

	/**
	 * Constructor que recibe un mensaje y la causa lanzable del fallo
	 * 
	 * @param message descriptivo con el error del usuario.
	 * @param cause   Detalles de motivos de la causa throwable.
	 */
	public UserException(String message, Throwable cause) {
		super(message, cause);
	}
}
