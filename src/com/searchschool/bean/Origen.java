package com.searchschool.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@NamedQueries( {
		@NamedQuery(name = "FindOrigenByTdescripcionOrigenContaining", query = "select myOrigen from Origen myOrigen where myOrigen.tdescripcionOrigen like ?1"),
		@NamedQuery(name = "FindOrigenByTdescripcionOrigenContainingCount", query = "select count(myOrigen.corigen) from Origen myOrigen where myOrigen.tdescripcionOrigen like ?1"),
		@NamedQuery(name = "FindOrigenByCorigen", query = "select myOrigen from Origen myOrigen where myOrigen.corigen = ?1"),
		@NamedQuery(name = "FindOrigenByCorigenCount", query = "select count(myOrigen.corigen) from Origen myOrigen where myOrigen.corigen = ?1"),
		@NamedQuery(name = "FindOrigenByNidiomaOrigen", query = "select myOrigen from Origen myOrigen where myOrigen.nidiomaOrigen = ?1"),
		@NamedQuery(name = "FindOrigenByNidiomaOrigenCount", query = "select count(myOrigen.corigen) from Origen myOrigen where myOrigen.nidiomaOrigen = ?1"),
		@NamedQuery(name = "FindOrigenByTdescripcionOrigen", query = "select myOrigen from Origen myOrigen where myOrigen.tdescripcionOrigen = ?1"),
		@NamedQuery(name = "FindOrigenByTdescripcionOrigenCount", query = "select count(myOrigen.corigen) from Origen myOrigen where myOrigen.tdescripcionOrigen = ?1"),
		@NamedQuery(name = "FindAllOrigens", query = "select myOrigen from Origen myOrigen"),
		@NamedQuery(name = "FindAllOrigensCount", query = "select count(myOrigen.corigen) from Origen myOrigen"),
		@NamedQuery(name = "FindOrigenByPrimaryKey", query = "select myOrigen from Origen myOrigen where myOrigen.corigen = ?1"),
		@NamedQuery(name = "FindOrigenByPrimaryKeyCount", query = "select count(myOrigen.corigen) from Origen myOrigen where myOrigen.corigen = ?1"),
		@NamedQuery(name = "FindOrigenByNidiomaOrigenContaining", query = "select myOrigen from Origen myOrigen where myOrigen.nidiomaOrigen like ?1"),
		@NamedQuery(name = "FindOrigenByNidiomaOrigenContainingCount", query = "select count(myOrigen.corigen) from Origen myOrigen where myOrigen.nidiomaOrigen like ?1") })
public class Origen implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "COrigen", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@GeneratedValue ( strategy=GenerationType.TABLE, 
	  generator="Origen_SEQ")
	@TableGenerator(name="Origen_SEQ", table="tbsequence",
	pkColumnName="SEQ_NAME",
	valueColumnName="SEQ_COUNT",
	pkColumnValue="origen",
	allocationSize=1)
	private Integer corigen;

	@Column(name = "TDescripcionOrigen", length = 200)
	@Basic(fetch = FetchType.EAGER)
	private String tdescripcionOrigen;

	@Column(name = "NIdiomaOrigen", length = 200)
	@Basic(fetch = FetchType.EAGER)
	private String nidiomaOrigen;

	@OneToMany(mappedBy = "origen", cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	private List<Colegio> colegios;

	public Origen() {
	}

	public void setCorigen(Integer corigen) {
		this.corigen = corigen;
	}

	public Integer getCorigen() {
		return this.corigen;
	}

	public void setTdescripcionOrigen(String tdescripcionOrigen) {
		this.tdescripcionOrigen = tdescripcionOrigen;
	}

	public String getTdescripcionOrigen() {
		return this.tdescripcionOrigen;
	}

	public void setNidiomaOrigen(String nidiomaOrigen) {
		this.nidiomaOrigen = nidiomaOrigen;
	}

	public String getNidiomaOrigen() {
		return this.nidiomaOrigen;
	}

	public void setColegios(List<Colegio> colegios) {
		this.colegios = colegios;
	}

	public List<Colegio> getColegios() {
		if (colegios == null) {
			colegios = new ArrayList<Colegio>();
		}

		return this.colegios;
	}

	public void copy(Origen that) {
		setCorigen(that.getCorigen());
		setTdescripcionOrigen(that.getTdescripcionOrigen());
		setNidiomaOrigen(that.getNidiomaOrigen());
		setColegios(new ArrayList<Colegio>(that.getColegios()));
	}

	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("corigen=[").append(corigen).append("] ");
		buffer.append("tdescripcionOrigen=[").append(tdescripcionOrigen).append("] ");
		buffer.append("nidiomaOrigen=[").append(nidiomaOrigen).append("] ");

		return buffer.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((corigen == null) ? 0 : corigen.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Origen))
			return false;
		Origen equalCheck = (Origen) obj;
		if ((corigen == null && equalCheck.corigen != null) || (corigen != null && equalCheck.corigen == null))
			return false;
		if (corigen != null && !corigen.equals(equalCheck.corigen))
			return false;
		return true;
	}

}
