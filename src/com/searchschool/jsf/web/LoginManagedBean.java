package com.searchschool.jsf.web;

import java.io.Serializable;
import java.util.Calendar;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.searchschool.bean.Usuario;
import com.searchschool.bean.Visitaslogueo;
import com.searchschool.factory.BuenosColegiosFactory;
import com.searchschool.jpa.EstadisticaDAO;
import com.searchschool.jpa.UsuarioDAO;
import com.searchschool.jsf.exception.SearchSchoolException;
import com.searchschool.jsf.exception.UsuarioDoesNotExistException;

@ManagedBean (name="LOGIN") 
@SessionScoped
public class LoginManagedBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Usuario usuario;
	private String nnickName;
	private String tcontraseniaUsuario;
	private String logeado;
	private String nologeado;
	private FacesContext context;
	private String colegio;
	private String saludo;

	public String verificalogin() {
		System.out.println("Entra a verificaLogin " + nnickName + " con contraseña " + tcontraseniaUsuario);
		UsuarioDAO uif = BuenosColegiosFactory.getUsuario();
		EstadisticaDAO eif = BuenosColegiosFactory.getEstadistica();
		context = FacesContext.getCurrentInstance();
		try {			
			 usuario= uif.getUser(nnickName, tcontraseniaUsuario);
			 Calendar cal = Calendar.getInstance();
			 int anio = cal.get(Calendar.YEAR);
			 int mes = cal.get(Calendar.MONTH);
			 int dia = cal.get(Calendar.DAY_OF_MONTH);
			 if(usuario.getColegio()!=null)
				 {
			 if(eif.getBeanVisitaslogueo(usuario.getCusuario(),usuario.getColegio().getCcolegio(), anio+"-"+ mes +"-"+ dia)!= null){
				 Visitaslogueo nuevo = eif.getBeanVisitaslogueo(usuario.getCusuario(),usuario.getColegio().getCcolegio(), anio+"-"+ mes +"-"+ dia);
				 nuevo.setQingreso(nuevo.getQingreso()+1);
				 eif.update(nuevo);
			 }else{
				 Visitaslogueo newVisitasLogueo = new Visitaslogueo(usuario.getCusuario(),usuario.getColegio().getCcolegio(), anio+"-"+ mes +"-"+ dia, 1, 1);
				 eif.insert(newVisitasLogueo);	 
			 }
				 }
		} catch (UsuarioDoesNotExistException e) {
			System.out.println("UserDoesNotExistException");
			context.addMessage("validar", 
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"El usuario no existe","XX") );
			return "login";
		} catch (SearchSchoolException e) {
			System.out.println("SearchSchoolException");
			context.addMessage("validar", 
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"El password es incorrecto","YY") );
			return "login";
		}
		HttpSession session = (HttpSession)context.getExternalContext().getSession(true);  
		   session.setAttribute("usuario", usuario);  
		System.out.println("Sale de  verificaLogin");	
		return "default";
		
	}
	
	public String login()
	{
		return "login";
	}
	
	public String registrar()
	{
		return "register";
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public FacesContext getContext() {
		return context;
	}

	public void setContext(FacesContext context) {
		this.context = context;
	}

	public String getNnickName() {
		return nnickName;
	}

	public void setNnickName(String nnickName) {
		this.nnickName = nnickName;
	}

	public String getTcontraseniaUsuario() {
		return tcontraseniaUsuario;
	}

	public void setTcontraseniaUsuario(String tcontraseniaUsuario) {
		this.tcontraseniaUsuario = tcontraseniaUsuario;
	}

	public String getColegio() {
		colegio="";
		if(usuario==null)
		   colegio="";
		else if(usuario.getTipoUsuario().getCtipoUsuario()==1)
			colegio="Colegio";
		return colegio;
	}

	public void setColegio(String colegio) {
		this.colegio = colegio;
	}

	public String getLogeado() {
		if(usuario==null)
			logeado= "visible";
		else 
			logeado="hidden";
		return logeado;
	}

	public void setLogeado(String logeado) {
		this.logeado = logeado;
	}

	public String getNologeado() {
		if(usuario==null)
			nologeado= "hidden";
		else
			nologeado= "visible";
		return nologeado;
	}

	public void setNologeado(String nologeado) {
		this.nologeado = nologeado;
	}

	public String getSaludo() {
		if(usuario!=null)
			saludo= usuario.getNnombreUsuario() + " " + usuario.getNapellidoUsuario();
		else
			saludo="";
		return saludo;
	}

	public void setSaludo(String saludo) {
		this.saludo = saludo;
	}

}
