package com.searchschool.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.EntityTransaction;

import com.searchschool.bean.Colegio;

public class ColegioDAOImpl implements ColegioDAO{

	private static ColegioDAOImpl instance;

	private ColegioDAOImpl()
	{
		
	}
	
	public static ColegioDAOImpl getInstance(){
		synchronized (ColegioDAOImpl.class) {
            if (instance == null) 
                    instance = new ColegioDAOImpl();
            return instance;
		}
	}
	
	private static EntityManager getEntityManager() {
	    return EMF.get().createEntityManager();
	  }
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Colegio> findAll() {
		EntityManager em=getEntityManager();
		Query q = em.createNamedQuery("FindAllColegios");
	    return q.getResultList();
	}
	
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Colegio> sortByField(String sortfield, boolean asc) {
		EntityManager em=getEntityManager();
	    String q = "SELECT e FROM Colegio e ORDER BY e." + sortfield;
	    if(sortfield.equals("tipoColegio"))
	    	q+=".ntipoColegio";
	    q+=" ";
	    if(asc) {
	       q += "ASC";
	     } else {
	       q += "DESC";
	    }
	    Query query = em.createQuery(q);
	    return query.getResultList();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Colegio> findbytype(String tipo) {
		EntityManager em=getEntityManager();
	    String q = "SELECT e FROM Colegio e WHERE e.tipoColegio.ntipoColegio = :tipo";
	    Query query = em.createQuery(q);
	    query.setParameter("tipo", tipo);	
	    return query.getResultList();
	}
	@Override
	public void insert(Colegio school) {
		EntityManager em=getEntityManager();
		EntityTransaction t = em.getTransaction();
		try {
			t.begin();
			em.persist(school);
			t.commit();
		} finally {
			if ( t.isActive() ) {
				t.rollback();
			}
			em.close();
		}
	}
	@Override
	public void update(Colegio school) {
		EntityManager em=getEntityManager();
		em.getTransaction().begin();
		em.merge(school);
		em.flush();
		em.getTransaction().commit();		
	}
	
	@Override
	public void delete(Colegio school) {
		EntityManager em=getEntityManager();
		em.getTransaction().begin();
		em.remove(school);
		em.flush();
		em.getTransaction().commit();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Colegio> sortTypeByField(String tipo, String sortfield, boolean asc) {
		EntityManager em=getEntityManager();
	    String q = "SELECT e FROM Colegio e WHERE e.tipoColegio.ntipoColegio = :tipo ORDER BY e." + sortfield;
	    if(sortfield.equals("tipoColegio"))
	    	q+=".ntipoColegio";
	    q+=" ";
	    if(asc) {
	       q += "ASC";
	     } else {
	       q += "DESC";
	    }
	    Query query = em.createQuery(q);
	    query.setParameter("tipo", tipo);	
	    return query.getResultList();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Colegio> findbyName(String name) {
		EntityManager em=getEntityManager();
		Query q = em.createNamedQuery("FindColegioByNcolegioContaining");
		q.setParameter(1, "%" + name + "%");
	    return q.getResultList();
	}



}
