package com.searchschool.jpa;

import javax.persistence.EntityManager;

public class ValoracionDAOImpl implements ValoracionDAO{

	private static ValoracionDAOImpl instance;

	private ValoracionDAOImpl()
	{
		
	}
	
	public static ValoracionDAOImpl getInstance(){
		synchronized (ValoracionDAOImpl.class) {
            if (instance == null) 
                    instance = new ValoracionDAOImpl();
            return instance;
		}
	}
	
	@SuppressWarnings("unused")
	private static EntityManager getEntityManager() {
	    return EMF.get().createEntityManager();
	  }
}
