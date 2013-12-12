package com.searchschool.jpa;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import com.searchschool.bean.TipoUsuario;
import com.searchschool.bean.Usuario;
import com.searchschool.jsf.exception.UsuarioDoesNotExistException;
import com.searchschool.jsf.exception.SearchSchoolException;


public class UsuarioDAOImpl implements UsuarioDAO {
	
	private static UsuarioDAOImpl instance;

	private UsuarioDAOImpl()
	{	
	}
	
	public static UsuarioDAOImpl getInstance(){
		synchronized (UsuarioDAOImpl.class) {
            if (instance == null) 
                    instance = new UsuarioDAOImpl();
            return instance;
		}
	}
	
	private static EntityManager getEntityManager() {
	    return EMF.get().createEntityManager();
	}

	@Override
	public Usuario getUser(String userNickname, String password)
			throws UsuarioDoesNotExistException, SearchSchoolException {
		EntityManager em = getEntityManager();
		Usuario usuario;
		try {
			Query query = em.createNamedQuery("FindUsuarioByNnickNameContaining");
			query.setParameter(1, userNickname);
			usuario = (Usuario) query.getSingleResult();
			if(!usuario.getTcontraseniaUsuario().equals(password))
			{
				throw new SearchSchoolException("El password ingresado es INVÁLIDO"); 
			}			
		}
		catch(NoResultException nre)
		{
			throw new UsuarioDoesNotExistException("El usuario: " + userNickname + " no está registrado");
			
		}
		finally
		{
			em.close();
		}		
		return usuario;
	}

	@Override
	public void insertarUsuario(Usuario usuario, int idtipo) throws SearchSchoolException {
		EntityManager em = getEntityManager();
		
		TipoUsuario tipoUsuario = em.find(TipoUsuario.class, idtipo);
		usuario.setTipoUsuario(tipoUsuario);
		EntityTransaction et = em.getTransaction();		
		try {
			et.begin();
			em.persist(usuario);
			et.commit();
			
		} finally {
			if ( et.isActive() ) { 
				et.rollback();
				em.close();
				throw new SearchSchoolException( "Error al grabar nuevo usuario ");
			}
			em.close();
		}
	}

}
