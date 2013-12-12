package com.searchschool.jsf.exception;

/**
 * Se lanza cuando se ingresa una numero de Colegio invalido
 */

public class UsuarioDoesNotExistException extends SearchSchoolException {

	private static final long serialVersionUID = 1L;

	public UsuarioDoesNotExistException(String s) {
		super(s);
	} 
}
