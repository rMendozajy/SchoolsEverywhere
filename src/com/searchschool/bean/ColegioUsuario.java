package com.searchschool.bean;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table (name="colegio_usuario")
/*
@NamedQueries( {
		@NamedQuery(name = "FindColegioUsuarioByCusuario", query = "select myColegioUsuario from ColegioUsuario myColegioUsuario where myColegioUsuario.Usuario.cusuario = ?1"),
		@NamedQuery(name = "FindColegioUsuarioByCusuarioCount", query = "select count(myColegioUsuario.colegio.ccolegio) from ColegioUsuario myColegioUsuario where myColegioUsuario.Usuario.cusuario  = ?1"),
		@NamedQuery(name = "FindColegioUsuarioByDregistroFavoritoContaining", query = "select myColegioUsuario from ColegioUsuario myColegioUsuario where myColegioUsuario.dregistroFavorito like ?1"),
		@NamedQuery(name = "FindColegioUsuarioByDregistroFavoritoContainingCount", query = "select count(myColegioUsuario.colegio.ccolegio) from ColegioUsuario myColegioUsuario where myColegioUsuario.dregistroFavorito like ?1"),
		@NamedQuery(name = "FindColegioUsuarioByDregistroFavorito", query = "select myColegioUsuario from ColegioUsuario myColegioUsuario where myColegioUsuario.dregistroFavorito = ?1"),
		@NamedQuery(name = "FindColegioUsuarioByDregistroFavoritoCount", query = "select count(myColegioUsuario.colegio.ccolegio) from ColegioUsuario myColegioUsuario where myColegioUsuario.dregistroFavorito = ?1"),
		@NamedQuery(name = "FindColegioUsuarioByCcolegio", query = "select myColegioUsuario from ColegioUsuario myColegioUsuario where myColegioUsuario.colegio.ccolegio = ?1"),
		@NamedQuery(name = "FindColegioUsuarioByCcolegioCount", query = "select count(myColegioUsuario.colegio.ccolegio) from ColegioUsuario myColegioUsuario where myColegioUsuario.colegio.ccolegio = ?1"),
		@NamedQuery(name = "FindColegioUsuarioByPrimaryKey", query = "select myColegioUsuario from ColegioUsuario myColegioUsuario where myColegioUsuario.colegio.ccolegio = ?1 and myColegioUsuario.cusuario = ?2"),
		@NamedQuery(name = "FindColegioUsuarioByPrimaryKeyCount", query = "select count(myColegioUsuario.colegio.ccolegio) from ColegioUsuario myColegioUsuario where myColegioUsuario.colegio.ccolegio = ?1 and myColegioUsuario.cusuario = ?2"),
		@NamedQuery(name = "FindAllColegioUsuarios", query = "select myColegioUsuario from ColegioUsuario myColegioUsuario"),
		@NamedQuery(name = "FindAllColegioUsuariosCount", query = "select count(myColegioUsuario.colegio.ccolegio) from ColegioUsuario myColegioUsuario") })
*/public class ColegioUsuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "CFavorito", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@GeneratedValue ( strategy=GenerationType.TABLE, 
	  generator="ColegioUsuario_SEQ")
	@TableGenerator(name="ColegioUsuario_SEQ", table="tbsequence",
	pkColumnName="SEQ_NAME",
	valueColumnName="SEQ_COUNT",
	pkColumnValue="colegio_usuario",
	allocationSize=1)
	private Integer cfavorito;

	@Column(name = "DRegistroFavorito", length = 20)
	@Basic(fetch = FetchType.EAGER)
	private String dregistroFavorito;

	@ManyToOne(cascade = { CascadeType.ALL, CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@JoinColumns( { @JoinColumn(name = "CUsuario", referencedColumnName = "CUsuario") })
	private Usuario usuario;

	@ManyToOne(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	@JoinColumns( { @JoinColumn(name = "CColegio", referencedColumnName = "CColegio") })
	private Colegio colegio;

	public ColegioUsuario() {
	}

	public void setDregistroFavorito(String dregistroFavorito) {
		this.dregistroFavorito = dregistroFavorito;
	}

	public String getDregistroFavorito() {
		return this.dregistroFavorito;
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

	public void copy(ColegioUsuario that) {

		setDregistroFavorito(that.getDregistroFavorito());
		setUsuario(that.getUsuario());
		setColegio(that.getColegio());
	}

	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("cfavorito=[").append(cfavorito).append("] ");
		buffer.append("dregistroFavorito=[").append(dregistroFavorito).append("] ");

		return buffer.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cfavorito == null) ? 0 : cfavorito.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof ColegioUsuario))
			return false;
		ColegioUsuario equalCheck = (ColegioUsuario) obj;
		if ((cfavorito == null && equalCheck.cfavorito != null) || (cfavorito != null && equalCheck.cfavorito == null))
			return false;
		if (cfavorito != null && !cfavorito.equals(equalCheck.cfavorito))
			return false;
		return true;
	}

}
