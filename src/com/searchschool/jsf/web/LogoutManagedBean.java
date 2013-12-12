package com.searchschool.jsf.web;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
@ManagedBean (name="LOGOUT") 
@RequestScoped
public class LogoutManagedBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	public LogoutManagedBean()
	{}
	private FacesContext context;
	public String logoutSession() {
		System.out.println("Entra a logout" );
		//LoginManagedBean lmb = new LoginManagedBean();
		context = FacesContext.getCurrentInstance();
		context.getExternalContext().getSessionMap().remove("LOGIN"); 		
		/*
		lmb.setLoginVisible("visible");
		lmb.setRegisterVisible("visible");
		lmb.setNameVisible("hidden");
		lmb.setLogoutVisible("hidden");*/
		
		System.out.println("Sale de  logout");
		return "default";
	}
	
	public FacesContext getContext() {
		return context;
	}
	public void setContext(FacesContext context) {
		this.context = context;
	}
}
