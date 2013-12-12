package com.searchschool.jpa;

import javax.persistence.EntityManager;


public class ConvenioDAOImpl implements ConvenioDAO{

	private static ConvenioDAOImpl instance;

	private ConvenioDAOImpl()
	{
		
	}
	
	public static ConvenioDAOImpl getInstance(){
		synchronized (ConvenioDAOImpl.class) {
            if (instance == null) 
                    instance = new ConvenioDAOImpl();
            return instance;
		}
	}
	
	@SuppressWarnings("unused")
	private static EntityManager getEntityManager() {
	    return EMF.get().createEntityManager();
	  }
}
