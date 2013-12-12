package com.searchschool.jsf.web;

import javax.faces.application.FacesMessage;  
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;  
import javax.faces.event.ActionEvent;  
  

@ManagedBean (name="CAPTCHA")
@SessionScoped

public class CaptchaManagedBean {  
  
    public void submit(ActionEvent event) {  
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Correct", "Correct");  
          
        FacesContext.getCurrentInstance().addMessage(null, msg);  
    }  
}