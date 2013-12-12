package com.searchschool.jsf.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpSession;

import com.searchschool.bean.Colegio;
import com.searchschool.bean.Usuario;
import com.searchschool.bean.Comentario;
import com.searchschool.factory.BuenosColegiosFactory;
import com.searchschool.jpa.ComentarioDAO;
import com.searchschool.jsf.exception.SearchSchoolException;


@ManagedBean (name = "COMENTAR")
@SessionScoped
public class ComentarManagedBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private FacesContext context;
	private int rating;
	private String texto="";
	private Colegio college;
	private List<Comentario> comentarios;
	public List<Comentario> getComentarios() {
		context = FacesContext.getCurrentInstance();	
		HttpSession session = (HttpSession)context.getExternalContext().getSession(true); 
		college=(Colegio) session.getAttribute("colegio");
		ComentarioDAO comentarioif = BuenosColegiosFactory.getComentario();		
		comentarios= comentarioif.findByColegio(college);
		return comentarios;
	}
	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}
	public void reCaptcha(ActionEvent event)
	{
		
	}

	public void addComent() throws SearchSchoolException
	{
		System.out.println("Entra a addComent");
		context = FacesContext.getCurrentInstance();	
		HttpSession session = (HttpSession)context.getExternalContext().getSession(true);  

		Usuario user=(Usuario) session.getAttribute("usuario");
		if(user!=null)
		{
			
			if(user.getTipoUsuario().getCtipoUsuario()==2)
			{
				college=(Colegio) session.getAttribute("colegio");
				ComentarioDAO comentarioif = BuenosColegiosFactory.getComentario();		
				comentarioif.insert(texto, rating, user.getCusuario(), college.getCcolegio());
			}else{
				context.addMessage("validar", 
						new FacesMessage(FacesMessage.SEVERITY_ERROR,
								"El usuario no tiene privilegios para registrar un comentario","XX") );
			}
			texto="";
			ComentarioDAO comentarioif = BuenosColegiosFactory.getComentario();		
			comentarios= comentarioif.findByColegio(college);
		}else{
			context.addMessage("validar", 
			new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Necesita logearse para registrar un comentario","XX") );
		}
	}

	
	public Colegio getCollege() {
		context = FacesContext.getCurrentInstance();	
		HttpSession session = (HttpSession)context.getExternalContext().getSession(true); 
		college=(Colegio) session.getAttribute("colegio");
		return college;
	}

	public void setCollege(Colegio college) {
		this.college = college;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public FacesContext getContext() {
		return context;
	}

	public void setContext(FacesContext context) {
		this.context = context;
	}
	
	public String getTexto() {
		return texto;
	}


	public void setTexto(String texto) {
		this.texto = texto;
	}
	

}
