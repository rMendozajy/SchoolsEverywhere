package com.searchschool.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
@Entity
@Table (name="red_colegio")
@NamedQueries( {
		@NamedQuery(name = "FindRedColegioByNredColegioContaining", query = "select myRedColegio from RedColegio myRedColegio where myRedColegio.nredColegio like ?1"),
		@NamedQuery(name = "FindRedColegioByNredColegioContainingCount", query = "select count(myRedColegio.credColegio) from RedColegio myRedColegio where myRedColegio.nredColegio like ?1"),
		@NamedQuery(name = "FindRedColegioByCredColegio", query = "select myRedColegio from RedColegio myRedColegio where myRedColegio.credColegio = ?1"),
		@NamedQuery(name = "FindRedColegioByCredColegioCount", query = "select count(myRedColegio.credColegio) from RedColegio myRedColegio where myRedColegio.credColegio = ?1"),
		@NamedQuery(name = "FindRedColegioByNredColegio", query = "select myRedColegio from RedColegio myRedColegio where myRedColegio.nredColegio = ?1"),
		@NamedQuery(name = "FindRedColegioByNredColegioCount", query = "select count(myRedColegio.credColegio) from RedColegio myRedColegio where myRedColegio.nredColegio = ?1"),
		@NamedQuery(name = "FindRedColegioByTdescripcionRed", query = "select myRedColegio from RedColegio myRedColegio where myRedColegio.tdescripcionRed = ?1"),
		@NamedQuery(name = "FindRedColegioByTdescripcionRedCount", query = "select count(myRedColegio.credColegio) from RedColegio myRedColegio where myRedColegio.tdescripcionRed = ?1"),
		@NamedQuery(name = "FindRedColegioByTdescripcionRedContaining", query = "select myRedColegio from RedColegio myRedColegio where myRedColegio.tdescripcionRed like ?1"),
		@NamedQuery(name = "FindRedColegioByTdescripcionRedContainingCount", query = "select count(myRedColegio.credColegio) from RedColegio myRedColegio where myRedColegio.tdescripcionRed like ?1"),
		@NamedQuery(name = "FindAllRedColegios", query = "select myRedColegio from RedColegio myRedColegio"),
		@NamedQuery(name = "FindAllRedColegiosCount", query = "select count(myRedColegio.credColegio) from RedColegio myRedColegio"),
		@NamedQuery(name = "FindRedColegioByPrimaryKey", query = "select myRedColegio from RedColegio myRedColegio where myRedColegio.credColegio = ?1"),
		@NamedQuery(name = "FindRedColegioByPrimaryKeyCount", query = "select count(myRedColegio.credColegio) from RedColegio myRedColegio where myRedColegio.credColegio = ?1") })

public class RedColegio implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "CRedColegio", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@GeneratedValue ( strategy=GenerationType.TABLE, 
	  generator="RedColegio_SEQ")
	@TableGenerator(name="RedColegio_SEQ", table="tbsequence",
	pkColumnName="SEQ_NAME",
	valueColumnName="SEQ_COUNT",
	pkColumnValue="red_colegio",
	allocationSize=1)
	private Integer credColegio;
	
	@Column(name = "NRedColegio", length = 100)
	@Basic(fetch = FetchType.EAGER)
	private String nredColegio;
	
	@Column(name = "TDescripcionRed", length = 300)
	@Basic(fetch = FetchType.EAGER)
	private String tdescripcionRed;
	
	@OneToMany(mappedBy = "redColegio", cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	private List<Colegio> colegios;

	public RedColegio() {
	}

	public void setCredColegio(Integer credColegio) {
		this.credColegio = credColegio;
	}

	public Integer getCredColegio() {
		return this.credColegio;
	}

	public void setNredColegio(String nredColegio) {
		this.nredColegio = nredColegio;
	}

	public String getNredColegio() {
		return this.nredColegio;
	}

	public void setTdescripcionRed(String tdescripcionRed) {
		this.tdescripcionRed = tdescripcionRed;
	}

	public String getTdescripcionRed() {
		return this.tdescripcionRed;
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

	public void copy(RedColegio that) {
		setCredColegio(that.getCredColegio());
		setNredColegio(that.getNredColegio());
		setTdescripcionRed(that.getTdescripcionRed());
		setColegios(new ArrayList<Colegio>(that.getColegios()));
	}

	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("credColegio=[").append(credColegio).append("] ");
		buffer.append("nredColegio=[").append(nredColegio).append("] ");
		buffer.append("tdescripcionRed=[").append(tdescripcionRed).append("] ");

		return buffer.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((credColegio == null) ? 0 : credColegio.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof RedColegio))
			return false;
		RedColegio equalCheck = (RedColegio) obj;
		if ((credColegio == null && equalCheck.credColegio != null) || (credColegio != null && equalCheck.credColegio == null))
			return false;
		if (credColegio != null && !credColegio.equals(equalCheck.credColegio))
			return false;
		return true;
	}

}
