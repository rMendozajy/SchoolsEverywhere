package com.searchschool.jpa;

import javax.persistence.EntityManager;

public class RedColegioDAOImpl implements RedColegioDAO {

	private static RedColegioDAOImpl instance;

	private RedColegioDAOImpl()
	{
		
	}
	
	public static RedColegioDAOImpl getInstance(){
		synchronized (RedColegioDAOImpl.class) {
            if (instance == null) 
                    instance = new RedColegioDAOImpl();
            return instance;
		}
	}
	
	@SuppressWarnings("unused")
	private static EntityManager getEntityManager() {
	    return EMF.get().createEntityManager();
	  }
}
