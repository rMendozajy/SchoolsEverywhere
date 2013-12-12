package com.searchschool.jpa;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.searchschool.bean.Colegio;
import com.searchschool.bean.Comentario;
import com.searchschool.bean.Usuario;
import com.searchschool.jsf.exception.SearchSchoolException;

public class ComentarioDAOImpl implements ComentarioDAO {
	
	private static ComentarioDAOImpl instance;

	private ComentarioDAOImpl()
	{
		
	}
	
	public static ComentarioDAOImpl getInstance(){
		synchronized (ComentarioDAOImpl.class) {
            if (instance == null) 
                    instance = new ComentarioDAOImpl();
            return instance;
		}
	}
	
	@SuppressWarnings("unused")
	private static EntityManager getEntityManager() {
	    return EMF.get().createEntityManager();
	  }
	
	@Override
	public List<Comentario> findByColegio(Colegio colegio){
		EntityManager em=getEntityManager();
	    String q = "SELECT e FROM Comentario e WHERE e.colegio.ccolegio = :ccolegio";
	    Query query = em.createQuery(q);
	    query.setParameter("ccolegio", colegio.getCcolegio());	
	    return query.getResultList();
	}

	@Override
	public void insert(String texto, int rating, int cusuario, int ccolegio) throws SearchSchoolException {
		
		System.out.println("Entra a insertar comentario");
		
		EntityManager em = getEntityManager();
		EntityTransaction et = em.getTransaction();	
		Comentario coment = new Comentario();
		String dcomentario;
		String day;
		String month;
		String year;
		Calendar date = new GregorianCalendar();
		
		Usuario user = em.find(Usuario.class, cusuario);
		Colegio college = em.find(Colegio.class, ccolegio);
		
		coment.setUsuario(user);
		coment.setColegio(college);
		coment.setTcomentario(texto);
		coment.setIrating(rating);
		
		day = Integer.toString(date.get(date.DATE));
		month = Integer.toString(date.get(date.MONTH));
		year = Integer.toString(date.get(date.YEAR));
		dcomentario = day + "/" + month + "/" + year;								
		coment.setDcomentario(dcomentario);
		
		System.out.println(coment.toString());
		
		try {
			et.begin();
			em.persist(coment);
			et.commit();
			
		} finally {
			if ( et.isActive() ) { 
				et.rollback();
				em.close();
				throw new SearchSchoolException( "Error al grabar comentario ");
			}
			em.close();
		}	
		
		System.out.println("Sale de insertar comentario");
	}

}
