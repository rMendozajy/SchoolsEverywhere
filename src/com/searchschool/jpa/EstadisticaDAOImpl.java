package com.searchschool.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.searchschool.bean.Visitaslogueo;

public class EstadisticaDAOImpl implements EstadisticaDAO {

	private EstadisticaDAOImpl(){
		
	}
	private static EstadisticaDAOImpl instance;

	public static EstadisticaDAOImpl getInstance(){
		synchronized (EstadisticaDAOImpl.class) {
            if (instance == null) 
                    instance = new EstadisticaDAOImpl();
            return instance;
		}
	}
	
	private static EntityManager getEntityManager() {
	    return EMF.get().createEntityManager();
	  }
	@SuppressWarnings("rawtypes")
	@Override
	public double getEstadisticaPrimerCuatrimestre(String fechaIni, String fechaFin,
			Integer codigoColegio) {
		EntityManager em = getEntityManager();
		String sql1 = "SELECT v FROM Visitaslogueo v WHERE v.dfecha >= '2012-01-01' AND v.dfecha <= '2012-04-30'";
		double sumaTotalVisitas=0;//2012-01-01 ||||  2012-01-30 ||| 1
		double resultado=0;
		List l1 = em.createQuery(sql1).getResultList();
		for(int i=0; i<l1.size();i++){
			Visitaslogueo o = (Visitaslogueo)l1.get(i);
			System.out.println("Visita :" + o);
			sumaTotalVisitas = sumaTotalVisitas + o.getQingreso();
		}
		System.out.println(sumaTotalVisitas);
		String sql = "SELECT v FROM Visitaslogueo v WHERE (v.dfecha >= '"+fechaIni+"' AND v.dfecha <= '"+fechaFin+"') AND v.colegio_ccolegio="+codigoColegio+"";
		double sumaVisitas=0;//2012-01-01 ||||  2012-01-30 ||| 1
		List l = em.createQuery(sql).getResultList();
		for(int i=0; i<l.size();i++){
			Visitaslogueo o = (Visitaslogueo)l.get(i);
			if(o!=null){
			System.out.println("Visita :" + o);
			sumaVisitas = sumaVisitas + o.getQingreso();
			}
		}
		System.out.println(sumaVisitas);
		resultado = (sumaVisitas*100)/sumaTotalVisitas;
		em.close();	
	return resultado;
	}

	@SuppressWarnings("rawtypes")
	public double getEstadisticasXNombreMes(String nombreMes, int codigoColegio) {
		String fechaIniEnvio ="";
		String fechaFinEnvio = "";
		if(nombreMes == "Enero"){
			fechaIniEnvio = "2012-01-01";
			fechaFinEnvio = "2012-01-30";
		}else if(nombreMes=="Febrero"){
			fechaIniEnvio = "2012-02-01";
			fechaFinEnvio = "2012-02-30";
		}else if(nombreMes=="Marzo"){
			fechaIniEnvio = "2012-03-01";
			fechaFinEnvio = "2012-03-30";
		}else if(nombreMes=="Abril"){
			fechaIniEnvio = "2012-04-01";
			fechaFinEnvio = "2012-04-30";
		}else if(nombreMes=="Mayo"){
			fechaIniEnvio = "2012-05-01";
			fechaFinEnvio = "2012-05-30";
		}else if(nombreMes=="Junio"){
			fechaIniEnvio = "2012-06-01";
			fechaFinEnvio = "2012-06-30";
		}else if(nombreMes=="Julio"){
			fechaIniEnvio = "2012-07-01";
			fechaFinEnvio = "2012-07-30";
		}else if(nombreMes=="Agosto"){
			fechaIniEnvio = "2012-08-01";
			fechaFinEnvio = "2012-08-30";
		}else if(nombreMes=="Setiembre"){
			fechaIniEnvio = "2012-09-01";
			fechaFinEnvio = "2012-09-30";
		}else if(nombreMes=="Octubre"){
			fechaIniEnvio = "2012-10-01";
			fechaFinEnvio = "2012-10-30";
		}else if(nombreMes=="Noviembre"){
			fechaIniEnvio = "2012-11-01";
			fechaFinEnvio = "2012-11-30";
		}else if(nombreMes=="Diciembre"){
			fechaIniEnvio = "2012-12-01";
			fechaFinEnvio = "2012-12-30";
		}
		EntityManager em = getEntityManager();
		String sql = "SELECT v FROM Visitaslogueo v WHERE (v.dfecha > '"+fechaIniEnvio+"' AND v.dfecha < '"+fechaFinEnvio+") AND v.colegio_ccolegio='"+codigoColegio+"'";
		double sumaVisitas=0;//2012-01-01 ||||  2012-01-30 ||| 1
		List l = em.createQuery(sql).getResultList();
		
		for(int i=0; i<l.size();i++){
			Visitaslogueo o = (Visitaslogueo)l.get(i);
			if(o!=null){
			System.out.println("Visita :" + o);
			sumaVisitas = sumaVisitas + o.getQingreso();
			}
		}
		em.close();	
		return sumaVisitas;
	}

	@Override
	public double getEstadisticaSegundoCuatrimestre(String fechaIni,
			String fechaFin, Integer codigoColegio) {
		EntityManager em = getEntityManager();
		String sql1 = "SELECT v FROM Visitaslogueo v WHERE v.dfecha >= '2012-05-01' AND v.dfecha <= '2012-08-30'";
		double sumaTotalVisitas=0;//2012-01-01 ||||  2012-01-30 ||| 1
		double resultado=0;
		List l1 = em.createQuery(sql1).getResultList();
		for(int i=0; i<l1.size();i++){
			Visitaslogueo o = (Visitaslogueo)l1.get(i);
			sumaTotalVisitas = sumaTotalVisitas + o.getQingreso();
		}
		System.out.println(sumaTotalVisitas);
		String sql = "SELECT v FROM Visitaslogueo v WHERE (v.dfecha >= '"+fechaIni+"' AND v.dfecha <= '"+fechaFin+"') AND v.colegio_ccolegio="+codigoColegio+"";
		double sumaVisitas=0;//2012-01-01 ||||  2012-01-30 ||| 1
		List l = em.createQuery(sql).getResultList();
		for(int i=0; i<l.size();i++){
			Visitaslogueo o = (Visitaslogueo)l.get(i);
			if(o!=null){
			sumaVisitas = sumaVisitas + o.getQingreso();
			}
		}
		resultado = (sumaVisitas*100)/sumaTotalVisitas;
		em.close();	
	return resultado;
	}

	@Override
	public double getEstadisticaTercerCuatrimestre(String fechaIni,
			String fechaFin, Integer codigoColegio) {
		EntityManager em = getEntityManager();
		String sql1 = "SELECT v FROM Visitaslogueo v WHERE v.dfecha >= '2012-09-01' AND v.dfecha <= '2012-12-30'";
		double sumaTotalVisitas=0;//2012-01-01 ||||  2012-01-30 ||| 1
		double resultado=0;
		List l1 = em.createQuery(sql1).getResultList();
		for(int i=0; i<l1.size();i++){
			Visitaslogueo o = (Visitaslogueo)l1.get(i);
			sumaTotalVisitas = sumaTotalVisitas + o.getQingreso();
		}
		System.out.println(sumaTotalVisitas);
		String sql = "SELECT v FROM Visitaslogueo v WHERE (v.dfecha >= '"+fechaIni+"' AND v.dfecha <= '"+fechaFin+"') AND v.colegio_ccolegio="+codigoColegio+"";
		double sumaVisitas=0;//2012-01-01 ||||  2012-01-30 ||| 1
		List l = em.createQuery(sql).getResultList();
		for(int i=0; i<l.size();i++){
			Visitaslogueo o = (Visitaslogueo)l.get(i);
			if(o!=null){
			System.out.println("Visita :" + o);
			sumaVisitas = sumaVisitas + o.getQingreso();
			}
		}
		resultado = (sumaVisitas*100)/sumaTotalVisitas;
		em.close();	
	return resultado;
	}

	@Override
	public int getTotalVisitasPC(
			Integer codigoColegio) {
		EntityManager em = getEntityManager();
		String sql1 = "SELECT v FROM Visitaslogueo v WHERE v.dfecha >= '2012-01-01' AND v.dfecha <= '2012-04-30'";
		int sumaTotalVisitas=0;//2012-01-01 ||||  2012-01-30 ||| 1
		List l1 = em.createQuery(sql1).getResultList();
		for(int i=0; i<l1.size();i++){
			Visitaslogueo o = (Visitaslogueo)l1.get(i);
			System.out.println("Visita :" + o);
			sumaTotalVisitas = sumaTotalVisitas + o.getQingreso();
		}
		em.close();	
	return sumaTotalVisitas;
	}

	@Override
	public int getTotalVisitasSC(
			Integer codigoColegio) {
		EntityManager em = getEntityManager();
		String sql1 = "SELECT v FROM Visitaslogueo v WHERE v.dfecha >= '2012-05-01' AND v.dfecha <= '2012-08-30'";
		int sumaTotalVisitas=0;//2012-01-01 ||||  2012-01-30 ||| 1
		List l1 = em.createQuery(sql1).getResultList();
		for(int i=0; i<l1.size();i++){
			Visitaslogueo o = (Visitaslogueo)l1.get(i);
			System.out.println("Visita :" + o);
			sumaTotalVisitas = sumaTotalVisitas + o.getQingreso();
		}
		em.close();	
	return sumaTotalVisitas;
	}

	@Override
	public int getTotalVisitasTC(
			Integer codigoColegio) {
		EntityManager em = getEntityManager();
		String sql1 = "SELECT v FROM Visitaslogueo v WHERE v.dfecha >= '2012-09-01' AND v.dfecha <= '2012-12-30'";
		int sumaTotalVisitas=0;//2012-01-01 ||||  2012-01-30 ||| 1
		List l1 = em.createQuery(sql1).getResultList();
		for(int i=0; i<l1.size();i++){
			Visitaslogueo o = (Visitaslogueo)l1.get(i);
			System.out.println("Visita :" + o);
			sumaTotalVisitas = sumaTotalVisitas + o.getQingreso();
		}
		em.close();	
	return sumaTotalVisitas;
	}

	@Override
	public void insert(Visitaslogueo beanVisitas) {
		EntityManager em=getEntityManager();
		EntityTransaction t = em.getTransaction();
		try {
			t.begin();
			em.persist(beanVisitas);
			t.commit();
		} finally {
			if ( t.isActive() ) {
				t.rollback();
			}
			em.close();
		}
	}

	@Override
	public void update(Visitaslogueo beanVisitas) {
		EntityManager em=getEntityManager();
		em.getTransaction().begin();
		em.merge(beanVisitas);
		em.flush();
		em.getTransaction().commit();
		
	}

	@Override
	public Visitaslogueo getBeanVisitaslogueo(Integer codigouser,
			Integer codigocolegio, String dfecha) {
		EntityManager em = getEntityManager();
		Visitaslogueo vlogueo = new Visitaslogueo();
		try{
		String sql1 = "SELECT v FROM Visitaslogueo v WHERE v.dfecha = '"+dfecha+"' AND v.usuario_cusuario = "+codigouser+" AND v.colegio_ccolegio = "+codigocolegio+"";
		//String sql1 = "SELECT v FROM Visitaslogueo v WHERE v.dfecha = '2012-10-28' AND v.usuario_cusuario = 3 AND v.colegio_ccolegio = 3";
		//ya despues usas namedQuery xd
		vlogueo = (Visitaslogueo) em.createQuery(sql1).getSingleResult();
		}catch(Exception e){
			return null;
		}
		em.close();	
		//FindVisitaLogueoUsu
		return vlogueo;
	}
}
