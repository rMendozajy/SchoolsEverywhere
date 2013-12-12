package com.searchschool.bean;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@NamedQueries( {
	@NamedQuery(name = "FindVisitaLogueoUsu", query = "SELECT v FROM Visitaslogueo v WHERE v.dfecha = ?1 AND v.usuario_cusuario = ?2 AND v.colegio_ccolegio = ?3")
	})
@Table(name="visitaslogueo")
public class Visitaslogueo implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
  	@Column (name="CCodigoVisita", nullable= false)
		private int ccodigovisita;
	@Column (name="CUsuario")
		private int usuario_cusuario;
	@Column (name="CColegio", nullable= true)
		private int colegio_ccolegio;
		private String dfecha;
		private int qfrecuencia;
		private int qingreso;
	@ManyToOne (fetch=FetchType.EAGER)
	@JoinColumn (name="CUsuario",referencedColumnName="CUsuario", updatable=false, insertable=false)//CUSUARIO
	private Usuario usuario;
	//select * from Visitaslogueo vl join Usuario1 u1 on (vl.CUsuario_Usuario = u1=C_Usuario)
	public Visitaslogueo(){}
	
	public Visitaslogueo(int usuario_cusuario,int colegio_ccolegio,String dfecha,int qfrecuencia,int qingreso){
		super();
		this.usuario_cusuario = usuario_cusuario;
		this.colegio_ccolegio = colegio_ccolegio;
		this.dfecha = dfecha;
		this.qfrecuencia =  qfrecuencia;	
		this.qingreso = qingreso;
	}	
		public int getCcodigovisita() {
			return ccodigovisita;
		}
		public void setCcodigovisita(int ccodigovisita) {
			
			this.ccodigovisita = ccodigovisita;
		}
		public int getUsuario_cusuario() {
			return usuario_cusuario;
		}
		public void setUsuario_cusuario(int usuario_cusuario) {
			this.usuario_cusuario = usuario_cusuario;
		}
		public int getColegio_ccolegio() {
			return colegio_ccolegio;
		}
		public void setColegio_ccolegio(int colegio_ccolegio) {
			this.colegio_ccolegio = colegio_ccolegio;
		}
		public String getDfecha() {
			return dfecha;
		}
		public void setDfecha(String dfecha) {
			this.dfecha = dfecha;
		}
		public int getQfrecuencia() {
			return qfrecuencia;
		}
		public void setQfrecuencia(int qfrecuencia) {
			this.qfrecuencia = qfrecuencia;
		}
		public int getQingreso() {
			return qingreso;
		}
		public void setQingreso(int qingreso) {
			this.qingreso = qingreso;
		}

		public Usuario getUsuario() {
			return usuario;
		}

		public void setUsuario(Usuario usuario) {
			this.usuario = usuario;
		}

		@Override
		public String toString() {
			return "Visitaslogueo [ccodigovisita=" + ccodigovisita
					+ ", usuario_cusuario=" + usuario_cusuario
					+ ", colegio_ccolegio=" + colegio_ccolegio + ", dfecha="
					+ dfecha + ", qfrecuencia=" + qfrecuencia + ", qingreso="
					+ qingreso + "]";
		}

		
}
