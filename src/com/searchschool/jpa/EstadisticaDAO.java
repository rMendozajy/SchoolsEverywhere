package com.searchschool.jpa;

import com.searchschool.bean.Visitaslogueo;

public interface EstadisticaDAO {
	public 	double getEstadisticaPrimerCuatrimestre(String fechaIni, String fechaFin, Integer codigoColegio);
	public 	double getEstadisticaSegundoCuatrimestre(String fechaIni, String fechaFin, Integer codigoColegio);
	public 	double getEstadisticaTercerCuatrimestre(String fechaIni, String fechaFin, Integer codigoColegio);
	public 	int getTotalVisitasPC(Integer codigoColegio);
	public 	int getTotalVisitasSC(Integer codigoColegio);
	public 	int getTotalVisitasTC(Integer codigoColegio);
	public 	Visitaslogueo getBeanVisitaslogueo(Integer codigouser, Integer codigocolegio, String dfecha);
	public  double getEstadisticasXNombreMes(String nombreMes, int codigoColegio);
	void insert(Visitaslogueo beanVisitas);
	void update(Visitaslogueo beanVisitas);
}
