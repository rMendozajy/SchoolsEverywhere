package com.searchschool.jpa;

import javax.persistence.EntityManager;


public class CorreoDAOImpl implements CorreoDAO{

	private static CorreoDAOImpl instance;

	private CorreoDAOImpl()
	{
		
	}
	
	public static CorreoDAOImpl getInstance(){
		synchronized (CorreoDAOImpl.class) {
            if (instance == null) 
                    instance = new CorreoDAOImpl();
            return instance;
		}
	}
	
	@SuppressWarnings("unused")
	private static EntityManager getEntityManager() {
	    return EMF.get().createEntityManager();
	  }

}
