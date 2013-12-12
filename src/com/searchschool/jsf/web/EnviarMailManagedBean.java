package com.searchschool.jsf.web;

import java.util.Properties;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.persistence.EntityManager;

import com.searchschool.bean.Correo;
import com.searchschool.jpa.EMF;
@ManagedBean (name="MAIL")
@SessionScoped
public class EnviarMailManagedBean {
	
	private String para;
	private String tema;
	private String texto;
	public void sendMail()
	{
		String result="";
		try{
			
			Properties props=new Properties();
			Session session=Session.getDefaultInstance(props,null);
			Message msg=new MimeMessage(session);
			msg.setFrom(new InternetAddress("diane.walls@gmail.com"));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(para));
			msg.setSubject(tema);
			msg.setText(texto);
			Transport.send(msg);
			
			//Grabar
			
			Correo c=new Correo();
			c.setPara(para);
			c.setTema(tema);
			c.setCuerpo(texto);
			EntityManager em = EMF.get().createEntityManager();
			try{
				em.getTransaction().begin();
				em.persist(c);
				
				em.getTransaction().commit();
				result+="se graba";
			}catch(Exception e){
				System.out.print(e);
				em.close();
				result+="no se graba";
			}
			result+="Correo enviado .. mira tu correo";
			System.out.println(result);
		}
		catch(Exception e){
			result+="Error al usar servicio de Maill";
			System.out.println(result);
		}
	}
	public String getPara() {
		return para;
	}
	public void setPara(String para) {
		this.para = para;
	}
	public String getTema() {
		return tema;
	}
	public void setTema(String tema) {
		this.tema = tema;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	

}
