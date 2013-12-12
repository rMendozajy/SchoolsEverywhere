package com.searchschool.factory;
import com.searchschool.jpa.*;


public class BuenosColegiosFactory {
	
	private BuenosColegiosFactory() {
	}
	
	public static UsuarioDAO getUsuario(){
		return UsuarioDAOImpl.getInstance();
	}
	
	public static ConvenioDAO getConvenio(){
		return ConvenioDAOImpl.getInstance();
	}
	
	public static ConvenioColegioDAO getConvenioColegio(){
		return ConvenioColegioDAOImpl.getInstance();
	}
	
	public static ComentarioDAO getComentario(){
		return ComentarioDAOImpl.getInstance();
	}
	
	public static ColegioUsuarioDAO getColegioUsuario(){
		return ColegioUsuarioDAOImpl.getInstance();
	}
	
	public static CorreoDAO getCorreo(){
		return CorreoDAOImpl.getInstance();
	}
	
	public static ColegioDAO getColegio(){
		return ColegioDAOImpl.getInstance();
	}
	
	public static OrigenDAO getOrigen(){
		return OrigenDAOImpl.getInstance();
	}
	
	public static TipoUsuarioDAO getTipoUsuario(){
		return TipoUsuarioDAOImpl.getInstance();
	}
	
	public static TipoColegioDAO getTipoColegio(){
		return TipoColegioDAOImpl.getInstance();
	}
	
	public static RedColegioDAO getRedColegio(){
		return RedColegioDAOImpl.getInstance();
	}
	
	public static ValoracionDAO getValoracion(){
		return ValoracionDAOImpl.getInstance();
	}

	public static EstadisticaDAO getEstadistica() {
		// TODO Auto-generated method stub
		return EstadisticaDAOImpl.getInstance();
	}

}
