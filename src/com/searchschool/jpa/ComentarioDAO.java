package com.searchschool.jpa;

import java.util.List;

import com.searchschool.bean.Colegio;
import com.searchschool.bean.Comentario;
import com.searchschool.bean.Usuario;
import com.searchschool.jsf.exception.SearchSchoolException;

public interface ComentarioDAO {

	public void insert(String texto, int rating, int cusuario, int ccolegio)
			throws SearchSchoolException ;

	public List<Comentario> findByColegio(Colegio colegio);

}
