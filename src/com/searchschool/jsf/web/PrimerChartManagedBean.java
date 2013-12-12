package com.searchschool.jsf.web;

import java.io.Serializable;
import javax.el.ELContext;
import javax.faces.FacesException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;
import com.searchschool.factory.BuenosColegiosFactory;
import com.searchschool.jpa.EstadisticaDAO;

//Colegio , Visitas (Visitas x Colegio) - solo saldrán, en un primer vistaso, los más visitados (Los 10 primeros) y habrá 
//una opción para generar la estadística de un colegio específico.
@ManagedBean(name="hd")
@SessionScoped
public class PrimerChartManagedBean implements Serializable {
	
	private LoginManagedBean personUsuario;
	private static final long serialVersionUID = 1L;
	private CartesianChartModel categoryModelunoTrimestre;
	private CartesianChartModel categoryModeldosTrimestre;
	private CartesianChartModel categoryModeltresTrimestre;
	private CartesianChartModel categoryModelflag;
	private String nomColegio;
	private int totalVisitas;
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
	public PrimerChartManagedBean(){
			personUsuario = (LoginManagedBean)PrimerChartManagedBean.getManagedBean("LOGIN");
			nomColegio = personUsuario.getUsuario().getColegio().getNcolegio();
		 	categoryModelunoTrimestre = new CartesianChartModel(); 
		 	categoryModeldosTrimestre = new CartesianChartModel(); 
		 	categoryModeltresTrimestre = new CartesianChartModel(); 
		 	categoryModelflag = new CartesianChartModel();
		 	ChartSeries chart = new ChartSeries();  
	        chart.setLabel(personUsuario.getUsuario().getColegio().getNcolegio());  
	        chart.set("Mes 1", 0);
	        chart.set("Mes 2", 0);
	        chart.set("Mes 3", 0);
	        chart.set("Mes 4", 0);
	        categoryModelunoTrimestre.addSeries(chart);
	        categoryModeldosTrimestre.addSeries(chart);
	        categoryModeltresTrimestre.addSeries(chart);
	        categoryModelflag.addSeries(chart);
	}
	public String createCategoryModelFlag() {  
		personUsuario = (LoginManagedBean)PrimerChartManagedBean.getManagedBean("LOGIN");
		nomColegio = personUsuario.getUsuario().getColegio().getNcolegio();
		categoryModelflag = new CartesianChartModel();   
        ChartSeries chart = new ChartSeries();  
        chart.setLabel(personUsuario.getUsuario().getColegio().getNcolegio());   
        chart.set("Mes 1", 0);
        chart.set("Mes 2", 0);
        chart.set("Mes 3", 0);
        chart.set("Mes 4", 0);         
        categoryModelflag.addSeries(chart);  
        return "chartFlag";
    } 	
	public String createCategoryModelPrimerTrimestre() {  
    	//Poner JPA, al jalarlos de la BD tengo que meterlos a una lista y crearlos un ChartSeries dinámicamente
    	//a cada Colegio y así poner los atributos que crea conveniente y generar algún Chart, y generar una esta_
    	//distica determinada.
		personUsuario = (LoginManagedBean)PrimerChartManagedBean.getManagedBean("LOGIN");
		nomColegio = personUsuario.getUsuario().getColegio().getNcolegio();
		categoryModelunoTrimestre = new CartesianChartModel();   
        ChartSeries chart = new ChartSeries();  
        chart.setLabel(personUsuario.getUsuario().getColegio().getNcolegio());  
        EstadisticaDAO est = BuenosColegiosFactory.getEstadistica();
        totalVisitas = est.getTotalVisitasPC(personUsuario.getUsuario().getColegio().getCcolegio());
        //System.out.println(personUsuario.getUsuario().getColegio().getCcolegio() + "UNBELIEBLEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE!!!");
        //System.out.println(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("ccolegio")+" PTMRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR");
        //Object codCol = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("ccolegio");
        chart.set("Enero", est.getEstadisticaPrimerCuatrimestre("2012-01-01", "2012-01-30", personUsuario.getUsuario().getColegio().getCcolegio()));  //2012-01-01 ||||  2012-01-30 ||| 1
        chart.set("Febrero", est.getEstadisticaPrimerCuatrimestre("2012-02-01", "2012-02-28",personUsuario.getUsuario().getColegio().getCcolegio()));  
        chart.set("Marzo", est.getEstadisticaPrimerCuatrimestre("2012-03-01", "2012-03-30",personUsuario.getUsuario().getColegio().getCcolegio()));  
        chart.set("Abril", est.getEstadisticaPrimerCuatrimestre("2012-04-01", "2012-04-30",personUsuario.getUsuario().getColegio().getCcolegio()));         
        categoryModelunoTrimestre.addSeries(chart);  
        return "Charts";
    } 
	public String createCategoryModelDosTrimestre() {  
		categoryModeldosTrimestre = new CartesianChartModel();
        ChartSeries tanguis2 = new ChartSeries();  
        tanguis2.setLabel(personUsuario.getUsuario().getColegio().getNcolegio());        
        EstadisticaDAO est = BuenosColegiosFactory.getEstadistica();
        personUsuario = (LoginManagedBean)PrimerChartManagedBean.getManagedBean("LOGIN");
        nomColegio = personUsuario.getUsuario().getColegio().getNcolegio();
        totalVisitas = est.getTotalVisitasSC(personUsuario.getUsuario().getColegio().getCcolegio());
        //Object codCol = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("ccolegio");
        tanguis2.set("Mayo", est.getEstadisticaSegundoCuatrimestre("2012-05-01", "2012-05-30",personUsuario.getUsuario().getColegio().getCcolegio()));  //2012-01-01 ||||  2012-01-30 ||| 1
        tanguis2.set("Junio", est.getEstadisticaSegundoCuatrimestre("2012-06-01", "2012-06-28",personUsuario.getUsuario().getColegio().getCcolegio()));  
        tanguis2.set("Julio", est.getEstadisticaSegundoCuatrimestre("2012-07-01", "2012-07-30",personUsuario.getUsuario().getColegio().getCcolegio()));  
        tanguis2.set("Agosto", est.getEstadisticaSegundoCuatrimestre("2012-08-01", "2012-08-30",personUsuario.getUsuario().getColegio().getCcolegio()));         
        categoryModeldosTrimestre.addSeries(tanguis2);  
        return "chartsSegundo";
    }
	public String createCategoryModelTresTrimestre() {  
		categoryModeltresTrimestre = new CartesianChartModel();   
        ChartSeries tanguis1 = new ChartSeries();  
        tanguis1.setLabel(personUsuario.getUsuario().getColegio().getNcolegio());  
        EstadisticaDAO est = BuenosColegiosFactory.getEstadistica();
        personUsuario = (LoginManagedBean)PrimerChartManagedBean.getManagedBean("LOGIN");
        nomColegio = personUsuario.getUsuario().getColegio().getNcolegio();
        totalVisitas = est.getTotalVisitasTC(personUsuario.getUsuario().getColegio().getCcolegio());
        System.out.println(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("ccolegio")+" PTMRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR");
        //Object codCol = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("ccolegio");
        tanguis1.set("Septiembre", est.getEstadisticaTercerCuatrimestre("2012-09-01", "2012-09-30",personUsuario.getUsuario().getColegio().getCcolegio()));  //2012-01-01 ||||  2012-01-30 ||| 1
        tanguis1.set("Octubre", est.getEstadisticaTercerCuatrimestre("2012-10-01", "2012-10-30",personUsuario.getUsuario().getColegio().getCcolegio()));  
        tanguis1.set("Noviembre", est.getEstadisticaTercerCuatrimestre("2012-11-01", "2012-11-30",personUsuario.getUsuario().getColegio().getCcolegio()));  
        tanguis1.set("Diciembre", est.getEstadisticaTercerCuatrimestre("2012-12-01", "2012-12-30",personUsuario.getUsuario().getColegio().getCcolegio()));         
        categoryModeltresTrimestre.addSeries(tanguis1);  
        return "chartsTercero";  
    }
	public CartesianChartModel getCategoryModelunoTrimestre() {
		//personUsuario = (LoginManagedBean)PrimerChartManagedBean.getManagedBean("LOGIN");
		return categoryModelunoTrimestre;
	}
	public void setCategoryModelunoTrimestre(
			CartesianChartModel categoryModelunoTrimestre) {
		this.categoryModelunoTrimestre = categoryModelunoTrimestre;
	}

	public CartesianChartModel getCategoryModeldosTrimestre() {
		return categoryModeldosTrimestre;
	}

	public void setCategoryModeldosTrimestre(
			CartesianChartModel categoryModeldosTrimestre) {
		this.categoryModeldosTrimestre = categoryModeldosTrimestre;
	}

	public CartesianChartModel getCategoryModeltresTrimestre() {
		return categoryModeltresTrimestre;
	}

	public void setCategoryModeltresTrimestre(
			CartesianChartModel categoryModeltresTrimestre) {
		this.categoryModeltresTrimestre = categoryModeltresTrimestre;
	}

	public CartesianChartModel getCategoryModelflag() {
		return categoryModelflag;
	}

	public void setCategoryModelflag(CartesianChartModel categoryModelflag) {
		this.categoryModelflag = categoryModelflag;
	}

	public LoginManagedBean getPersonUsuario() {
		return personUsuario;
	}

	public void setPersonUsuario(LoginManagedBean personUsuario) {
		this.personUsuario = personUsuario;
	}

	public String getNomColegio() {
		return nomColegio;
	}

	public void setNomColegio(String nomColegio) {
		this.nomColegio = nomColegio;
	}
	public int getTotalVisitas() {
		return totalVisitas;
	}
	public void setTotalVisitas(int totalVisitas) {
		this.totalVisitas = totalVisitas;
	}
}

