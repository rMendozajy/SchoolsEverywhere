package com.searchschool.jpa;

import com.searchschool.bean.Usuario;
import com.searchschool.jsf.exception.UsuarioDoesNotExistException;
import com.searchschool.jsf.exception.SearchSchoolException;


public interface UsuarioDAO{
	
	public Usuario getUser(String userNickname, String password) throws UsuarioDoesNotExistException, SearchSchoolException;

	void insertarUsuario(Usuario usuario, int idtipo)
			throws SearchSchoolException;
}
