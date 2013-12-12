package com.searchschool.bean;

import java.io.Serializable;

import java.lang.StringBuilder;

import javax.persistence.*;

@Entity
@Table (name="convenio_colegio")

@NamedQueries( {
		@NamedQuery(name = "FindConvenioColegioByDinicioConvenio", query = "select myConvenioColegio from ConvenioColegio myConvenioColegio where myConvenioColegio.dinicioConvenio = ?1"),
		@NamedQuery(name = "FindConvenioColegioByDinicioConvenioCount", query = "select count(myConvenioColegio.cconvenioColegio) from ConvenioColegio myConvenioColegio where myConvenioColegio.dinicioConvenio = ?1"),
		@NamedQuery(name = "FindConvenioColegioByDinicioConvenioContaining", query = "select myConvenioColegio from ConvenioColegio myConvenioColegio where myConvenioColegio.dinicioConvenio like ?1"),
		@NamedQuery(name = "FindConvenioColegioByDinicioConvenioContainingCount", query = "select count(myConvenioColegio.cconvenioColegio) from ConvenioColegio myConvenioColegio where myConvenioColegio.dinicioConvenio like ?1"),
		@NamedQuery(name = "FindConvenioColegioByCcolegio", query = "select myConvenioColegio from ConvenioColegio myConvenioColegio where myConvenioColegio.colegio.ccolegio = ?1"),
		@NamedQuery(name = "FindConvenioColegioByCcolegioCount", query = "select count(myConvenioColegio.cconvenioColegio) from ConvenioColegio myConvenioColegio where myConvenioColegio.colegio.ccolegio = ?1"),
		@NamedQuery(name = "FindAllConvenioColegios", query = "select myConvenioColegio from ConvenioColegio myConvenioColegio"),
		@NamedQuery(name = "FindAllConvenioColegiosCount", query = "select count(myConvenioColegio.cconvenioColegio) from ConvenioColegio myConvenioColegio"),
		@NamedQuery(name = "FindConvenioColegioByCconvenio", query = "select myConvenioColegio from ConvenioColegio myConvenioColegio where myConvenioColegio.convenio.cconvenio = ?1"),
		@NamedQuery(name = "FindConvenioColegioByCconvenioCount", query = "select count(myConvenioColegio.cconvenioColegio) from ConvenioColegio myConvenioColegio where myConvenioColegio.convenio.cconvenio = ?1")})
 public class ConvenioColegio implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "CConvenioColegio", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@GeneratedValue ( strategy=GenerationType.TABLE, 
	  generator="ConvenioColegio_SEQ")
	@TableGenerator(name="ConvenioColegio_SEQ", table="tbsequence",
	pkColumnName="SEQ_NAME",
	valueColumnName="SEQ_COUNT",
	pkColumnValue="convenio_colegio",
	allocationSize=1)
	private Integer cconvenioColegio;
	
	@Column(name = "DInicioConvenio", length = 20)
	@Basic(fetch = FetchType.EAGER)
	private String dinicioConvenio;

	@ManyToOne(cascade = { CascadeType.ALL, CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@JoinColumns( { @JoinColumn(name = "CConvenio", referencedColumnName = "CConvenio") })
	private Convenio convenio;

	@ManyToOne(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	@JoinColumns( { @JoinColumn(name = "CColegio", referencedColumnName = "CColegio") })
	private Colegio colegio;

	public ConvenioColegio() {
	}

	public void setDinicioConvenio(String dinicioConvenio) {
		this.dinicioConvenio = dinicioConvenio;
	}

	public String getDinicioConvenio() {
		return this.dinicioConvenio;
	}

	public void setConvenio(Convenio convenio) {
		this.convenio = convenio;
	}

	public Convenio getConvenio() {

		return this.convenio;
	}

	public void setColegio(Colegio colegio) {
		this.colegio = colegio;
	}

	public Colegio getColegio() {

		return this.colegio;
	}

	public void copy(ConvenioColegio that) {
		setCconvenioColegio(that.getCconvenioColegio());
		setDinicioConvenio(that.getDinicioConvenio());
		setConvenio(that.getConvenio());
		setColegio(that.getColegio());
	}

	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("cconvenio=[").append(cconvenioColegio).append("] ");
		buffer.append("dinicioConvenio=[").append(dinicioConvenio).append("] ");

		return buffer.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cconvenioColegio == null) ? 0 : cconvenioColegio.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof ConvenioColegio))
			return false;
		ConvenioColegio equalCheck = (ConvenioColegio) obj;
		if ((cconvenioColegio == null && equalCheck.cconvenioColegio != null) || (cconvenioColegio != null && equalCheck.cconvenioColegio == null))
			return false;
		if (cconvenioColegio != null && !cconvenioColegio.equals(equalCheck.cconvenioColegio))
			return false;
		return true;
	}

	public Integer getCconvenioColegio() {
		return cconvenioColegio;
	}

	public void setCconvenioColegio(Integer cconvenioColegio) {
		this.cconvenioColegio = cconvenioColegio;
	}

}
