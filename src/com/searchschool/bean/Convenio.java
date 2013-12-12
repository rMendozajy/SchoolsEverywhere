package com.searchschool.bean;

import java.io.Serializable;

import java.lang.StringBuilder;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@NamedQueries( {
		@NamedQuery(name = "FindConvenioByTconvenio", query = "select myConvenio from Convenio myConvenio where myConvenio.tconvenio = ?1"),
		@NamedQuery(name = "FindConvenioByTconvenioCount", query = "select count(myConvenio.cconvenio) from Convenio myConvenio where myConvenio.tconvenio = ?1"),
		@NamedQuery(name = "FindConvenioByCconvenio", query = "select myConvenio from Convenio myConvenio where myConvenio.cconvenio = ?1"),
		@NamedQuery(name = "FindConvenioByCconvenioCount", query = "select count(myConvenio.cconvenio) from Convenio myConvenio where myConvenio.cconvenio = ?1"),
		@NamedQuery(name = "FindConvenioByTconvenioContaining", query = "select myConvenio from Convenio myConvenio where myConvenio.tconvenio like ?1"),
		@NamedQuery(name = "FindConvenioByTconvenioContainingCount", query = "select count(myConvenio.cconvenio) from Convenio myConvenio where myConvenio.tconvenio like ?1"),
		@NamedQuery(name = "FindAllConvenios", query = "select myConvenio from Convenio myConvenio"),
		@NamedQuery(name = "FindAllConveniosCount", query = "select count(myConvenio.cconvenio) from Convenio myConvenio"),
		@NamedQuery(name = "FindConvenioByPrimaryKey", query = "select myConvenio from Convenio myConvenio where myConvenio.cconvenio = ?1"),
		@NamedQuery(name = "FindConvenioByPrimaryKeyCount", query = "select count(myConvenio.cconvenio) from Convenio myConvenio where myConvenio.cconvenio = ?1"),
		@NamedQuery(name = "FindConvenioByNconvenioContaining", query = "select myConvenio from Convenio myConvenio where myConvenio.nconvenio like ?1"),
		@NamedQuery(name = "FindConvenioByNconvenioContainingCount", query = "select count(myConvenio.cconvenio) from Convenio myConvenio where myConvenio.nconvenio like ?1"),
		@NamedQuery(name = "FindConvenioByNconvenio", query = "select myConvenio from Convenio myConvenio where myConvenio.nconvenio = ?1"),
		@NamedQuery(name = "FindConvenioByNconvenioCount", query = "select count(myConvenio.cconvenio) from Convenio myConvenio where myConvenio.nconvenio = ?1") })
public class Convenio implements Serializable {

	private static final long serialVersionUID = 1L;
	@Column(name = "CConvenio", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@GeneratedValue ( strategy=GenerationType.TABLE, 
	  generator="Convenio_SEQ")
	@TableGenerator(name="Convenio_SEQ", table="tbsequence",
	pkColumnName="SEQ_NAME",
	valueColumnName="SEQ_COUNT",
	pkColumnValue="convenio",
	allocationSize=1)
	private Integer cconvenio;

	@Column(name = "NConvenio", length = 100)
	@Basic(fetch = FetchType.EAGER)
	private String nconvenio;

	@Column(name = "TConvenio", length = 500)
	@Basic(fetch = FetchType.EAGER)
	private String tconvenio;

	@OneToMany(mappedBy = "convenio", cascade = {
			CascadeType.ALL,
			CascadeType.REMOVE }, fetch = FetchType.LAZY)
	private List<ConvenioColegio> convenioColegios;

	public Convenio() {
	}

	public void setCconvenio(Integer cconvenio) {
		this.cconvenio = cconvenio;
	}

	public Integer getCconvenio() {
		return this.cconvenio;
	}

	public void setNconvenio(String nconvenio) {
		this.nconvenio = nconvenio;
	}

	public String getNconvenio() {
		return this.nconvenio;
	}

	public void setTconvenio(String tconvenio) {
		this.tconvenio = tconvenio;
	}

	public String getTconvenio() {
		return this.tconvenio;
	}

	public void setConvenioColegios(List<ConvenioColegio> convenioColegios) {
		this.convenioColegios = convenioColegios;
	}

	public List<ConvenioColegio> getConvenioColegios() {
		if (convenioColegios == null) {
			convenioColegios = new ArrayList<ConvenioColegio>();
		}

		return this.convenioColegios;
	}

	public void copy(Convenio that) {
		setCconvenio(that.getCconvenio());
		setNconvenio(that.getNconvenio());
		setTconvenio(that.getTconvenio());
		setConvenioColegios(new ArrayList<ConvenioColegio>(that.getConvenioColegios()));
	}

	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("cconvenio=[").append(cconvenio).append("] ");
		buffer.append("nconvenio=[").append(nconvenio).append("] ");
		buffer.append("tconvenio=[").append(tconvenio).append("] ");

		return buffer.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cconvenio == null) ? 0 : cconvenio.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Convenio))
			return false;
		Convenio equalCheck = (Convenio) obj;
		if ((cconvenio == null && equalCheck.cconvenio != null) || (cconvenio != null && equalCheck.cconvenio == null))
			return false;
		if (cconvenio != null && !cconvenio.equals(equalCheck.cconvenio))
			return false;
		return true;
	}

}
