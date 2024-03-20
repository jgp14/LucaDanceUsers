package com.lucatic.grupo2.app.users.exceptions;
/**
 * Clase personalizada para manejo excepciones de si existe usuario con un
 * nombre determinado
 *
 * @author BlueDevTeams
 * @version v1.0.0
 * @since 20-03-2024
 */
public class UserNameException extends UserException {

	/**
	 * Genera un serialVersionUID para la excepcion personalizada
	 */
	private static final long serialVersionUID = 1L;
	/**Constructor con parametro tipo String con un mensaje de error
	 * 
	 * @param message parametro con el mensaje
	 */
	public UserNameException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	/**
	 * Constructor con dos parametros
	 * @param message recibe este parametro en tipo texto
	 * @param cause recibe el parametro de tipo Throwable
	 */
	public UserNameException(String message, Throwable cause) {
		super(message, cause);
	}

}
