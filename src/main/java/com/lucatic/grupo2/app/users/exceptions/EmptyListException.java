package com.lucatic.grupo2.app.users.exceptions;

/**
 * Clase personalizada de manejo de excepciones de lista vacias
 *
 * @author BlueDevTeams
 * @version v1.0.0
 * @since 18-03-2024
 */
public class EmptyListException extends UserException {

	/**
	 * Genera un serialVersionUID para la excepcion personalizada
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor que recibe un mensaje del fallo.
	 * 
	 * @param message descriptivo con el error de lista usuarios vacia.
	 */

	public EmptyListException(String message) {
		super(message);
	}

	/**
	 * Constructor que recibe un mensaje y la causa lanzable del fallo.
	 * 
	 * @param message descriptivo con el error de lista usuarios vacia.
	 * @param cause   Detalles de motivos de la causa throwable.
	 */

	public EmptyListException(String message, Throwable cause) {
		super(message, cause);
	}
}
