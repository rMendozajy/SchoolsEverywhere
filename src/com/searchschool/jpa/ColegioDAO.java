package com.searchschool.jpa;

import java.util.List;

import com.searchschool.bean.Colegio;

public interface ColegioDAO {
	
	public List<Colegio> findAll();

	public List<Colegio> sortByField(String sortfield, boolean asc);

	public List<Colegio> findbyName(String name);

	public List<Colegio> sortTypeByField(String tipo, String sortfield, boolean asc);

	void delete(Colegio school);

	void update(Colegio school);

	void insert(Colegio school);

	public List<Colegio> findbytype(String tipo);
	
	
}
