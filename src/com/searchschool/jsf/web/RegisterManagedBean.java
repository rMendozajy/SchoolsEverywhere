package com.searchschool.jsf.web;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import com.searchschool.bean.Usuario;
import com.searchschool.factory.BuenosColegiosFactory;
import com.searchschool.jpa.UsuarioDAO;
import com.searchschool.jsf.exception.SearchSchoolException;

@ManagedBean(name="REGISTRAR")
@SessionScoped
public class RegisterManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;
	// El Usuario
	private String nnombreUsuario;
	private String napellidoUsuario;
	private String nnickName;
	private String tcontraseniaUsuario;
	private String ncorreoUsuario;
	private FacesContext context;
	public RegisterManagedBean(){
		
	}
	public String iniciar(){
		System.out.println("en iniciar");
		return "register";
	}
	

	public String registrar(){
		System.out.println("* * * Entra a registrar " );
		
		UsuarioDAO usuarioif = BuenosColegiosFactory.getUsuario();
		context = FacesContext.getCurrentInstance();
		
		try {
			 Usuario usuario = new Usuario();
			 usuario.setNnickName(nnickName);
			 usuario.setNapellidoUsuario(napellidoUsuario);
			 usuario.setNcorreoUsuario(ncorreoUsuario);
			 usuario.setNnombreUsuario(nnombreUsuario);
			 usuario.setTcontraseniaUsuario(tcontraseniaUsuario);
			 usuarioif.insertarUsuario(usuario,2);
			 
		} catch (SearchSchoolException e) {
			System.out.println("* * * MB: UsuarioException * * *");
			context.addMessage("registrar", 
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							 "Ocurrio un error al registrarse","YY") );
			return "register";
		}
		return "login";
	}

	/**
	 * @return the nnombreUsuario
	 */
	public String getNnombreUsuario() {
		return nnombreUsuario;
	}

	/**
	 * @param nnombreUsuario the nnombreUsuario to set
	 */
	public void setNnombreUsuario(String nnombreUsuario) {
		this.nnombreUsuario = nnombreUsuario;
	}

	/**
	 * @return the napellidoUsuario
	 */
	public String getNapellidoUsuario() {
		return napellidoUsuario;
	}

	/**
	 * @param napellidoUsuario the napellidoUsuario to set
	 */
	public void setNapellidoUsuario(String napellidoUsuario) {
		this.napellidoUsuario = napellidoUsuario;
	}

	/**
	 * @return the nnickName
	 */
	public String getNnickName() {
		return nnickName;
	}

	/**
	 * @param nnickName the nnickName to set
	 */
	public void setNnickName(String nnickName) {
		this.nnickName = nnickName;
	}

	/**
	 * @return the tcontraseniaUsuario
	 */
	public String getTcontraseniaUsuario() {
		return tcontraseniaUsuario;
	}

	/**
	 * @param tcontraseniaUsuario the tcontraseniaUsuario to set
	 */
	public void setTcontraseniaUsuario(String tcontraseniaUsuario) {
		this.tcontraseniaUsuario = tcontraseniaUsuario;
	}

	/**
	 * @return the ncorreoUsuario
	 */
	public String getNcorreoUsuario() {
		return ncorreoUsuario;
	}

	/**
	 * @param ncorreoUsuario the ncorreoUsuario to set
	 */
	public void setNcorreoUsuario(String ncorreoUsuario) {
		this.ncorreoUsuario = ncorreoUsuario;
	}

	// El TipoUsuario
	private int ctipoUsuario;
	/**
	 * @return the context
	 */
	public FacesContext getContext() {
		return context;
	}

	/**
	 * @param context the context to set
	 */
	public void setContext(FacesContext context) {
		this.context = context;
	}

	/**
	 * @return the ctipoUsuario
	 */
	public int getCtipoUsuario() {
		return ctipoUsuario;
	}

	/**
	 * @param ctipoUsuario the ctipoUsuario to set
	 */
	public void setCtipoUsuario(int ctipoUsuario) {
		this.ctipoUsuario = ctipoUsuario;
	}

	
}
