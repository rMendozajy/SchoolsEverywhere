package com.searchschool.bean;

import java.io.Serializable;

import java.lang.StringBuilder;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table (name="tipo_usuario")
@NamedQueries( {
		@NamedQuery(name = "FindTipoUsuarioByTdescripcionTipoUsuarioContaining", query = "select myTipoUsuario from TipoUsuario myTipoUsuario where myTipoUsuario.tdescripcionTipoUsuario like ?1"),
		@NamedQuery(name = "FindTipoUsuarioByTdescripcionTipoUsuarioContainingCount", query = "select count(myTipoUsuario.ctipoUsuario) from TipoUsuario myTipoUsuario where myTipoUsuario.tdescripcionTipoUsuario like ?1"),
		@NamedQuery(name = "FindTipoUsuarioByNtipoUsuario", query = "select myTipoUsuario from TipoUsuario myTipoUsuario where myTipoUsuario.ntipoUsuario = ?1"),
		@NamedQuery(name = "FindTipoUsuarioByNtipoUsuarioCount", query = "select count(myTipoUsuario.ctipoUsuario) from TipoUsuario myTipoUsuario where myTipoUsuario.ntipoUsuario = ?1"),
		@NamedQuery(name = "FindAllTipoUsuarios", query = "select myTipoUsuario from TipoUsuario myTipoUsuario"),
		@NamedQuery(name = "FindAllTipoUsuariosCount", query = "select count(myTipoUsuario.ctipoUsuario) from TipoUsuario myTipoUsuario"),
		@NamedQuery(name = "FindTipoUsuarioByCtipoUsuario", query = "select myTipoUsuario from TipoUsuario myTipoUsuario where myTipoUsuario.ctipoUsuario = ?1"),
		@NamedQuery(name = "FindTipoUsuarioByCtipoUsuarioCount", query = "select count(myTipoUsuario.ctipoUsuario) from TipoUsuario myTipoUsuario where myTipoUsuario.ctipoUsuario = ?1"),
		@NamedQuery(name = "FindTipoUsuarioByTdescripcionTipoUsuario", query = "select myTipoUsuario from TipoUsuario myTipoUsuario where myTipoUsuario.tdescripcionTipoUsuario = ?1"),
		@NamedQuery(name = "FindTipoUsuarioByTdescripcionTipoUsuarioCount", query = "select count(myTipoUsuario.ctipoUsuario) from TipoUsuario myTipoUsuario where myTipoUsuario.tdescripcionTipoUsuario = ?1"),
		@NamedQuery(name = "FindTipoUsuarioByNtipoUsuarioContaining", query = "select myTipoUsuario from TipoUsuario myTipoUsuario where myTipoUsuario.ntipoUsuario like ?1"),
		@NamedQuery(name = "FindTipoUsuarioByNtipoUsuarioContainingCount", query = "select count(myTipoUsuario.ctipoUsuario) from TipoUsuario myTipoUsuario where myTipoUsuario.ntipoUsuario like ?1"),
		@NamedQuery(name = "FindTipoUsuarioByPrimaryKey", query = "select myTipoUsuario from TipoUsuario myTipoUsuario where myTipoUsuario.ctipoUsuario = ?1"),
		@NamedQuery(name = "FindTipoUsuarioByPrimaryKeyCount", query = "select count(myTipoUsuario.ctipoUsuario) from TipoUsuario myTipoUsuario where myTipoUsuario.ctipoUsuario = ?1") })
public class TipoUsuario implements Serializable {

	private static final long serialVersionUID = 1L;
	@Column(name = "CTipoUsuario", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@GeneratedValue ( strategy=GenerationType.TABLE, 
	  generator="TipoUsuario_SEQ")
	@TableGenerator(name="TipoUsuario_SEQ", table="tbsequence",
	pkColumnName="SEQ_NAME",
	valueColumnName="SEQ_COUNT",
	pkColumnValue="tipo_usuario",
	allocationSize=1)
	private Integer ctipoUsuario;

	@Column(name = "NTipoUsuario", length = 50)
	@Basic(fetch = FetchType.EAGER)
	private String ntipoUsuario;

	@Column(name = "TDescripcionTipoUsuario", length = 200)
	@Basic(fetch = FetchType.EAGER)
	private String tdescripcionTipoUsuario;

	@OneToMany(mappedBy = "tipoUsuario", cascade = {
			CascadeType.ALL,
			CascadeType.REMOVE }, fetch = FetchType.LAZY)
	private List<Usuario> usuarios;

	public TipoUsuario() {
	}

	public void setCtipoUsuario(Integer ctipoUsuario) {
		this.ctipoUsuario = ctipoUsuario;
	}

	public Integer getCtipoUsuario() {
		return this.ctipoUsuario;
	}

	public void setNtipoUsuario(String ntipoUsuario) {
		this.ntipoUsuario = ntipoUsuario;
	}

	public String getNtipoUsuario() {
		return this.ntipoUsuario;
	}

	public void setTdescripcionTipoUsuario(String tdescripcionTipoUsuario) {
		this.tdescripcionTipoUsuario = tdescripcionTipoUsuario;
	}

	public String getTdescripcionTipoUsuario() {
		return this.tdescripcionTipoUsuario;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public List<Usuario> getUsuarios() {
		if (usuarios == null) {
			usuarios = new ArrayList<Usuario>();
		}

		return this.usuarios;
	}

	public void copy(TipoUsuario that) {
		setCtipoUsuario(that.getCtipoUsuario());
		setNtipoUsuario(that.getNtipoUsuario());
		setTdescripcionTipoUsuario(that.getTdescripcionTipoUsuario());
		setUsuarios(new ArrayList<Usuario>(that.getUsuarios()));
	}

	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("ctipoUsuario=[").append(ctipoUsuario).append("] ");
		buffer.append("ntipoUsuario=[").append(ntipoUsuario).append("] ");
		buffer.append("tdescripcionTipoUsuario=[").append(tdescripcionTipoUsuario).append("] ");

		return buffer.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ctipoUsuario == null) ? 0 : ctipoUsuario.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof TipoUsuario))
			return false;
		TipoUsuario equalCheck = (TipoUsuario) obj;
		if ((ctipoUsuario == null && equalCheck.ctipoUsuario != null) || (ctipoUsuario != null && equalCheck.ctipoUsuario == null))
			return false;
		if (ctipoUsuario != null && !ctipoUsuario.equals(equalCheck.ctipoUsuario))
			return false;
		return true;
	}

}
