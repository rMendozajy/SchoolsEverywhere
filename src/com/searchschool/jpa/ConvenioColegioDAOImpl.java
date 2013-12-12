package com.searchschool.jpa;

import javax.persistence.EntityManager;

public class ConvenioColegioDAOImpl implements ConvenioColegioDAO{


	private static ConvenioColegioDAOImpl instance;

	private ConvenioColegioDAOImpl()
	{
		
	}
	
	public static ConvenioColegioDAO getInstance(){
		synchronized (ConvenioColegioDAOImpl.class) {
            if (instance == null) 
                    instance = new ConvenioColegioDAOImpl();
            return instance;
		}
	}
	
	@SuppressWarnings("unused")
	private static EntityManager getEntityManager() {
	    return EMF.get().createEntityManager();
	  }

}
