package com.searchschool.jpa;

import javax.persistence.EntityManager;

public class OrigenDAOImpl implements OrigenDAO {

	private static OrigenDAOImpl instance;

	private OrigenDAOImpl()
	{
		
	}
	
	public static OrigenDAOImpl getInstance(){
		synchronized (OrigenDAOImpl.class) {
            if (instance == null) 
                    instance = new OrigenDAOImpl();
            return instance;
		}
	}
	
	@SuppressWarnings("unused")
	private static EntityManager getEntityManager() {
	    return EMF.get().createEntityManager();
	  }

}
