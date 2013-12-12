package com.searchschool.jpa;

import javax.persistence.EntityManager;

public class TipoColegioDAOImpl implements TipoColegioDAO {

	private static TipoColegioDAOImpl instance;

	private TipoColegioDAOImpl()
	{
		
	}
	
	public static TipoColegioDAOImpl getInstance(){
		synchronized (TipoColegioDAOImpl.class) {
            if (instance == null) 
                    instance = new TipoColegioDAOImpl();
            return instance;
		}
	}
	
	@SuppressWarnings("unused")
	private static EntityManager getEntityManager() {
	    return EMF.get().createEntityManager();
	  }
}
