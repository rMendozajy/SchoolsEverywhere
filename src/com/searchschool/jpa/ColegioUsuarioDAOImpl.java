package com.searchschool.jpa;

import javax.persistence.EntityManager;


public class ColegioUsuarioDAOImpl implements ColegioUsuarioDAO{

	private static ColegioUsuarioDAOImpl instance;

	private ColegioUsuarioDAOImpl()
	{
		
	}
	
	public static ColegioUsuarioDAOImpl getInstance(){
		synchronized (ColegioUsuarioDAOImpl.class) {
            if (instance == null) 
                    instance = new ColegioUsuarioDAOImpl();
            return instance;
		}
	}
	
	@SuppressWarnings("unused")
	private static EntityManager getEntityManager() {
	    return EMF.get().createEntityManager();
	}

}
