package com.searchschool.bean;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@NamedQueries( {
		@NamedQuery(name = "FindComentarioByCcomentario", query = "select myComentario from Comentario myComentario where myComentario.ccomentario = ?1"),
		@NamedQuery(name = "FindComentarioByCcomentarioCount", query = "select count(myComentario.ccomentario) from Comentario myComentario where myComentario.ccomentario = ?1"),
		@NamedQuery(name = "FindComentarioByDcomentarioContaining", query = "select myComentario from Comentario myComentario where myComentario.dcomentario like ?1"),
		@NamedQuery(name = "FindComentarioByDcomentarioContainingCount", query = "select count(myComentario.ccomentario) from Comentario myComentario where myComentario.dcomentario like ?1"),
		@NamedQuery(name = "FindAllComentarios", query = "select myComentario from Comentario myComentario"),
		@NamedQuery(name = "FindAllComentariosCount", query = "select count(myComentario.ccomentario) from Comentario myComentario"),
		@NamedQuery(name = "FindComentarioByTcomentario", query = "select myComentario from Comentario myComentario where myComentario.tcomentario = ?1"),
		@NamedQuery(name = "FindComentarioByTcomentarioCount", query = "select count(myComentario.ccomentario) from Comentario myComentario where myComentario.tcomentario = ?1"),
		@NamedQuery(name = "FindComentarioByDcomentario", query = "select myComentario from Comentario myComentario where myComentario.dcomentario = ?1"),
		@NamedQuery(name = "FindComentarioByDcomentarioCount", query = "select count(myComentario.ccomentario) from Comentario myComentario where myComentario.dcomentario = ?1"),
		@NamedQuery(name = "FindComentarioByTcomentarioContaining", query = "select myComentario from Comentario myComentario where myComentario.tcomentario like ?1"),
		@NamedQuery(name = "FindComentarioByTcomentarioContainingCount", query = "select count(myComentario.ccomentario) from Comentario myComentario where myComentario.tcomentario like ?1"),
		@NamedQuery(name = "FindComentarioByPrimaryKey", query = "select myComentario from Comentario myComentario where myComentario.ccomentario = ?1"),
		@NamedQuery(name = "FindComentarioByPrimaryKeyCount", query = "select count(myComentario.ccomentario) from Comentario myComentario where myComentario.ccomentario = ?1") })
public class Comentario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "CComentario", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@GeneratedValue ( strategy=GenerationType.TABLE, 
	  generator="Comentario_SEQ")
	@TableGenerator(name="Comentario_SEQ", table="tbsequence",
	pkColumnName="SEQ_NAME",
	valueColumnName="SEQ_COUNT",
	pkColumnValue="comentario",
	allocationSize=1)
	private Integer ccomentario;

	@Column(name = "TComentario", length = 500)
	@Basic(fetch = FetchType.EAGER)
	private String tcomentario;

	@Column(name = "DComentario", length = 20)
	@Basic(fetch = FetchType.EAGER)
	private String dcomentario;

	@Column(name = "IRating")
	@Basic(fetch = FetchType.EAGER)
	private int irating;
	
	
	@ManyToOne(cascade = { CascadeType.ALL, CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@JoinColumns( { @JoinColumn(name = "CUsuario", referencedColumnName = "CUsuario") })
	private Usuario usuario;

	@ManyToOne(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	@JoinColumns( { @JoinColumn(name = "CColegio", referencedColumnName = "CColegio") })
	private Colegio colegio;

	public Comentario() {
	}

	public void setCcomentario(Integer ccomentario) {
		this.ccomentario = ccomentario;
	}

	public Integer getCcomentario() {
		return this.ccomentario;
	}

	public void setTcomentario(String tcomentario) {
		this.tcomentario = tcomentario;
	}

	public String getTcomentario() {
		return this.tcomentario;
	}

	public void setDcomentario(String dcomentario) {
		this.dcomentario = dcomentario;
	}

	public String getDcomentario() {
		return this.dcomentario;
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


	public void copy(Comentario that) {
		setCcomentario(that.getCcomentario());
		setTcomentario(that.getTcomentario());
		setDcomentario(that.getDcomentario());
		setUsuario(that.getUsuario());
		setColegio(that.getColegio());
	}

	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("ccomentario=[").append(ccomentario).append("] ");
		buffer.append("tcomentario=[").append(tcomentario).append("] ");
		buffer.append("dcomentario=[").append(dcomentario).append("] ");

		return buffer.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ccomentario == null) ? 0 : ccomentario.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Comentario))
			return false;
		Comentario equalCheck = (Comentario) obj;
		if ((ccomentario == null && equalCheck.ccomentario != null) || (ccomentario != null && equalCheck.ccomentario == null))
			return false;
		if (ccomentario != null && !ccomentario.equals(equalCheck.ccomentario))
			return false;
		return true;
	}

	public int getIrating() {
		return irating;
	}

	public void setIrating(int irating) {
		this.irating = irating;
	}

}
