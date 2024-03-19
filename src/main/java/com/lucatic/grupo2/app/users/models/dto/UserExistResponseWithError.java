package com.lucatic.grupo2.app.users.models.dto;

import com.lucatic.grupo2.app.users.models.Error;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserExistResponseWithError {
	/**
	 * Atributo con objeto Error
	 */
	private Error error;
	/**
	 * Atributo con atributo boolean
	 */
	private boolean userExistBool;
	/**
	 * Atributo con boolean para decidir si es o no un error
	 */
	private boolean isErrorBool;
}
