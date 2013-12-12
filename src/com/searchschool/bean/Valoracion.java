package com.searchschool.bean;

import java.io.Serializable;

import java.lang.StringBuilder;

import javax.persistence.*;


@Entity

@NamedQueries( {
		@NamedQuery(name = "FindValoracionByQvaloracion", query = "select myValoracion from Valoracion myValoracion where myValoracion.qvaloracion = ?1"),
		@NamedQuery(name = "FindValoracionByQvaloracionCount", query = "select count(myValoracion.cvaloracion) from Valoracion myValoracion where myValoracion.qvaloracion = ?1"),
		@NamedQuery(name = "FindValoracionByCcolegio", query = "select myValoracion from Valoracion myValoracion where myValoracion.colegio.ccolegio = ?1"),
		@NamedQuery(name = "FindValoracionByCcolegioCount", query = "select count(myValoracion.cvaloracion) from Valoracion myValoracion where myValoracion.colegio.ccolegio = ?1"),
		@NamedQuery(name = "FindAllValoracions", query = "select myValoracion from Valoracion myValoracion"),
		@NamedQuery(name = "FindAllValoracionsCount", query = "select count(myValoracion.cvaloracion) from Valoracion myValoracion"),
		@NamedQuery(name = "FindValoracionByCusuario", query = "select myValoracion from Valoracion myValoracion where myValoracion.usuario.cusuario = ?1"),
		@NamedQuery(name = "FindValoracionByCusuarioCount", query = "select count(myValoracion.cvaloracion) from Valoracion myValoracion where myValoracion.usuario.cusuario = ?1"),
		@NamedQuery(name = "FindValoracionByPrimaryKey", query = "select myValoracion from Valoracion myValoracion where myValoracion.colegio.ccolegio = ?1 and myValoracion.usuario.cusuario = ?2"),
		@NamedQuery(name = "FindValoracionByPrimaryKeyCount", query = "select count(myValoracion.cvaloracion) from Valoracion myValoracion where myValoracion.colegio.ccolegio = ?1 and myValoracion.usuario.cusuario = ?2") })

public class Valoracion implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Column(name = "CValoracion", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@GeneratedValue ( strategy=GenerationType.TABLE, 
	  generator="Valoracion_SEQ")
	@TableGenerator(name="Valoracion_SEQ", table="tbsequence",
	pkColumnName="SEQ_NAME",
	valueColumnName="SEQ_COUNT",
	pkColumnValue="valoracion",
	allocationSize=1)
	private Integer cvaloracion;

	@Column(name = "QValoracion")
	@Basic(fetch = FetchType.EAGER)
	private Integer qvaloracion;

	@ManyToOne(cascade = { CascadeType.ALL, CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@JoinColumns( { @JoinColumn(name = "CUsuario", referencedColumnName = "CUsuario") })
	private Usuario usuario;

	@ManyToOne(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	@JoinColumns( { @JoinColumn(name = "CColegio", referencedColumnName = "CColegio") })
	private Colegio colegio;

	public Valoracion() {
	}


	public void setQvaloracion(Integer qvaloracion) {
		this.qvaloracion = qvaloracion;
	}

	public Integer getQvaloracion() {
		return this.qvaloracion;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Usuario getUsuario() {

		return this.usuario;
	}

	public void setColegio(Colegio colegio) {
		this.colegio = colegio;
	}

	public Colegio getColegio() {

		return this.colegio;
	}

	public void copy(Valoracion that) {
		setQvaloracion(that.getQvaloracion());
		setUsuario(that.getUsuario());
		setColegio(that.getColegio());
	}

	public String toString() {

		StringBuilder buffer = new StringBuilder();
		buffer.append("qvaloracion=[").append(qvaloracion).append("] ");

		return buffer.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cvaloracion == null) ? 0 : cvaloracion.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Valoracion))
			return false;
		Valoracion equalCheck = (Valoracion) obj;
		if ((cvaloracion == null && equalCheck.cvaloracion != null) || (cvaloracion != null && equalCheck.cvaloracion == null))
			return false;
		if (cvaloracion != null && !cvaloracion.equals(equalCheck.cvaloracion))
			return false;
		return true;
	}

}
