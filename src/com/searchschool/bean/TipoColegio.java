package com.searchschool.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table (name="tipo_colegio")
@NamedQueries( {
		@NamedQuery(name = "FindTipoColegioByCtipoColegio", query = "select myTipoColegio from TipoColegio myTipoColegio where myTipoColegio.ctipoColegio = ?1"),
		@NamedQuery(name = "FindTipoColegioByCtipoColegioCount", query = "select count(myTipoColegio.ctipoColegio) from TipoColegio myTipoColegio where myTipoColegio.ctipoColegio = ?1"),
		@NamedQuery(name = "FindTipoColegioByPrimaryKey", query = "select myTipoColegio from TipoColegio myTipoColegio where myTipoColegio.ctipoColegio = ?1"),
		@NamedQuery(name = "FindTipoColegioByPrimaryKeyCount", query = "select count(myTipoColegio.ctipoColegio) from TipoColegio myTipoColegio where myTipoColegio.ctipoColegio = ?1"),
		@NamedQuery(name = "FindTipoColegioByNtipoColegioContaining", query = "select myTipoColegio from TipoColegio myTipoColegio where myTipoColegio.ntipoColegio like ?1"),
		@NamedQuery(name = "FindTipoColegioByNtipoColegioContainingCount", query = "select count(myTipoColegio.ctipoColegio) from TipoColegio myTipoColegio where myTipoColegio.ntipoColegio like ?1"),
		@NamedQuery(name = "FindAllTipoColegios", query = "select myTipoColegio from TipoColegio myTipoColegio"),
		@NamedQuery(name = "FindAllTipoColegiosCount", query = "select count(myTipoColegio.ctipoColegio) from TipoColegio myTipoColegio"),
		@NamedQuery(name = "FindTipoColegioByTdescripcionTipoColegioContaining", query = "select myTipoColegio from TipoColegio myTipoColegio where myTipoColegio.tdescripcionTipoColegio like ?1"),
		@NamedQuery(name = "FindTipoColegioByTdescripcionTipoColegioContainingCount", query = "select count(myTipoColegio.ctipoColegio) from TipoColegio myTipoColegio where myTipoColegio.tdescripcionTipoColegio like ?1"),
		@NamedQuery(name = "FindTipoColegioByNtipoColegio", query = "select myTipoColegio from TipoColegio myTipoColegio where myTipoColegio.ntipoColegio = ?1"),
		@NamedQuery(name = "FindTipoColegioByNtipoColegioCount", query = "select count(myTipoColegio.ctipoColegio) from TipoColegio myTipoColegio where myTipoColegio.ntipoColegio = ?1"),
		@NamedQuery(name = "FindTipoColegioByTdescripcionTipoColegio", query = "select myTipoColegio from TipoColegio myTipoColegio where myTipoColegio.tdescripcionTipoColegio = ?1"),
		@NamedQuery(name = "FindTipoColegioByTdescripcionTipoColegioCount", query = "select count(myTipoColegio.ctipoColegio) from TipoColegio myTipoColegio where myTipoColegio.tdescripcionTipoColegio = ?1") })
public class TipoColegio implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "CTipoColegio", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@GeneratedValue ( strategy=GenerationType.TABLE, 
	  generator="TipoColegio_SEQ")
	@TableGenerator(name="TipoColegio_SEQ", table="tbsequence",
	pkColumnName="SEQ_NAME",
	valueColumnName="SEQ_COUNT",
	pkColumnValue="tipo_colegio",
	allocationSize=1)
	private Integer ctipoColegio;

	@Column(name = "NTipoColegio", length = 100)
	@Basic(fetch = FetchType.EAGER)
	private String ntipoColegio;
	
	@Column(name = "TDescripcionTipoColegio", length = 500)
	@Basic(fetch = FetchType.EAGER)
	private String tdescripcionTipoColegio;

	@OneToMany(mappedBy = "tipoColegio", cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	private List<Colegio> colegios;

	public TipoColegio() {
	}

	public void setCtipoColegio(Integer ctipoColegio) {
		this.ctipoColegio = ctipoColegio;
	}

	public Integer getCtipoColegio() {
		return this.ctipoColegio;
	}

	public void setNtipoColegio(String ntipoColegio) {
		this.ntipoColegio = ntipoColegio;
	}

	public String getNtipoColegio() {
		return this.ntipoColegio;
	}

	public void setTdescripcionTipoColegio(String tdescripcionTipoColegio) {
		this.tdescripcionTipoColegio = tdescripcionTipoColegio;
	}

	public String getTdescripcionTipoColegio() {
		return this.tdescripcionTipoColegio;
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

	public void copy(TipoColegio that) {
		setCtipoColegio(that.getCtipoColegio());
		setNtipoColegio(that.getNtipoColegio());
		setTdescripcionTipoColegio(that.getTdescripcionTipoColegio());
		setColegios(new ArrayList<Colegio>(that.getColegios()));
	}

	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("ctipoColegio=[").append(ctipoColegio).append("] ");
		buffer.append("ntipoColegio=[").append(ntipoColegio).append("] ");
		buffer.append("tdescripcionTipoColegio=[").append(tdescripcionTipoColegio).append("] ");

		return buffer.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ctipoColegio == null) ? 0 : ctipoColegio.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof TipoColegio))
			return false;
		TipoColegio equalCheck = (TipoColegio) obj;
		if ((ctipoColegio == null && equalCheck.ctipoColegio != null) || (ctipoColegio != null && equalCheck.ctipoColegio == null))
			return false;
		if (ctipoColegio != null && !ctipoColegio.equals(equalCheck.ctipoColegio))
			return false;
		return true;
	}

}
