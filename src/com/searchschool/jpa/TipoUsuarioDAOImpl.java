package com.searchschool.jpa;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import com.searchschool.bean.TipoUsuario;


public class TipoUsuarioDAOImpl implements TipoUsuarioDAO {

	private static TipoUsuarioDAOImpl instance;

	private TipoUsuarioDAOImpl()
	{
		
	}
	
	public static TipoUsuarioDAOImpl getInstance(){
		synchronized (TipoUsuarioDAOImpl.class) {
            if (instance == null) 
                    instance = new TipoUsuarioDAOImpl();
            return instance;
		}
	}
	
	private static EntityManager getEntityManager() {
	    return EMF.get().createEntityManager();
	  }

	@Override
	public TipoUsuario getTipoUsuario(int i) {
		EntityManager em = getEntityManager();
		Query query = em.createNamedQuery("FindTipoUsuarioByPrimaryKey");
		query.setParameter(1, i);
		return (TipoUsuario) query.getSingleResult();
	}
}
