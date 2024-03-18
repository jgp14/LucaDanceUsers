package com.lucatic.grupo2.app.users.exceptions;

/**
 * Clase personalizada para manejo excepciones de si existe usuario, que hereda
 * de UserException
 *
 * @author BlueDevTeams
 * @version v1.0.0
 * @since 18-03-2024
 */
public class UserExistException extends UserException {

	/**
	 * Genera un serialVersionUID para la excepcion personalizada
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor que recibe un mensaje del fallo
	 * 
	 * @param message el mensaje de error del usuario ya exitente
	 */
	public UserExistException(String message) {
		super(message);
	}

	/**
	 * Constructor que recibe un mensaje y la causa lanzable
	 * 
	 * @param message el mensaje de error del usuario ya exitente
	 * @param cause   Detalles de motivos de la causa throwable
	 */

	public UserExistException(String message, Throwable cause) {
		super(message, cause);
	}

}
