package com.searchschool.jsf.web;
 
import java.io.Serializable;

import javax.el.ELContext;
import javax.faces.FacesException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;


import com.searchschool.bean.Colegio;

import com.searchschool.factory.BuenosColegiosFactory;
import com.searchschool.jpa.ColegioDAO;

@ManagedBean (name="ACTUALIZAR")
@SessionScoped
public class ActualizarColegioManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private int codigo1;
	private String nombre;
	private String tipo;
	private String logo;
	private String descripcion;
	private String origen;
	private String redcolegio;
	private String telefono;
	private String fundacion;
	private String web;
	private FacesContext context;
	private LoginManagedBean personUsuario;
	
	
	public static Object getManagedBean(final String beanName) {
		FacesContext fc = FacesContext.getCurrentInstance();
		Object bean;
		try{
		ELContext elContext = fc.getELContext();
		bean = elContext.getELResolver().getValue(elContext, null, beanName);

		}catch(RuntimeException e){
		throw new FacesException(e.getMessage(),e);
		}
		if (bean == null){
		throw new FacesException("Managed bean with name '" + beanName
		+ "' was not found. Check my faces-config.xml or @ManagedBean annotation.");
		}
		return bean;
		}
	
	public void handleSave() {
		
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message =new FacesMessage();
		context.addMessage("Escriba datos correctos", message );
		//add faces message with update text value
		}
	
	public void Actualizar(){
		System.out.println("* * * Actualizando...." );
		ColegioDAO colegioif = BuenosColegiosFactory.getColegio();
		personUsuario = (LoginManagedBean)ActualizarColegioManagedBean.getManagedBean("LOGIN");

		context = FacesContext.getCurrentInstance();
	
		try {
			 Colegio colegio = new Colegio();
			 colegio.setNcolegio(personUsuario.getUsuario().getColegio().getNcolegio());//nombre
			 colegio.setTdescripcionColegio(personUsuario.getUsuario().getColegio().getTdescripcionColegio());//descripcion
			 colegio.setDfundacionColegio(personUsuario.getUsuario().getColegio().getDfundacionColegio());//fundacion
			 colegio.setTelefonoPrincipalColegio(personUsuario.getUsuario().getColegio().getTelefonoPrincipalColegio());//telefono
			 colegio.setTpaginaWeb(personUsuario.getUsuario().getColegio().getTpaginaWeb());//web
			 colegio.setCcolegio(personUsuario.getUsuario().getColegio().getCcolegio());
			 colegio.setQvaloracionPromedio(personUsuario.getUsuario().getColegio().getQvaloracionPromedio());
			 colegio.setTurlImagen(personUsuario.getUsuario().getColegio().getTurlImagen());
			 colegio.setOrigen(personUsuario.getUsuario().getColegio().getOrigen());
			 colegio.setRedColegio(personUsuario.getUsuario().getColegio().getRedColegio());
			 colegio.setTipoColegio(personUsuario.getUsuario().getColegio().getTipoColegio());
			 colegio.setUsuario(personUsuario.getUsuario().getColegio().getUsuario());
			 colegio.setColegioUsuarios(personUsuario.getUsuario().getColegio().getColegioUsuarios());
			 colegio.setValoracions(personUsuario.getUsuario().getColegio().getValoracions());
			 colegio.setComentarios(personUsuario.getUsuario().getColegio().getComentarios());
			 colegio.setConvenioColegios(personUsuario.getUsuario().getColegio().getConvenioColegios());
			 colegio.setPosX(personUsuario.getUsuario().getColegio().getPosX());
			 colegio.setPosY(personUsuario.getUsuario().getColegio().getPosY());

			 colegioif.update(colegio);
			 
		} catch (Exception e) {
			System.out.println("* * * UsuarioException * * *");
			context.addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							 "Ocurrio un error al Actualiazar","YY") );
		}
		
	}
	
	
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}
	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	/**
	 * @return the logo
	 */
	public String getLogo() {
		return logo;
	}
	/**
	 * @param logo the logo to set
	 */
	public void setLogo(String logo) {
		this.logo = logo;
	}
	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}
	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	/**
	 * @return the origen
	 */
	public String getOrigen() {
		return origen;
	}
	/**
	 * @param origen the origen to set
	 */
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	/**
	 * @return the redcolegio
	 */
	public String getRedcolegio() {
		return redcolegio;
	}
	/**
	 * @param redcolegio the redcolegio to set
	 */
	public void setRedcolegio(String redcolegio) {
		this.redcolegio = redcolegio;
	}
	/**
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}
	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	/**
	 * @return the fundacion
	 */
	public String getFundacion() {
		return fundacion;
	}
	/**
	 * @param fundacion the fundacion to set
	 */
	public void setFundacion(String fundacion) {
		this.fundacion = fundacion;
	}
	/**
	 * @return the web
	 */
	public String getWeb() {
		return web;
	}
	/**
	 * @param web the web to set
	 */
	public void setWeb(String web) {
		this.web = web;
	}
	/**
	 * @param web the codigo to set
	 */
	public int getCodigo1() {
		return codigo1;
	}
	/**
	 * @param web the codigo to set
	 */

	public void setCodigo1(int codigo1) {
		this.codigo1 = codigo1;
	}
	
}
        