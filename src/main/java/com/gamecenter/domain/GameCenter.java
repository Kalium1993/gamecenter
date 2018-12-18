package com.gamecenter.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "gamecenter")
public class GameCenter extends BaseDominio{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="IDgamecenter")
	private Integer id;
	
	@ManyToOne
	@NotNull
	@JoinColumn(name="IDempresa")
	private Empresa empresa;
	
	@ManyToOne
	@NotNull
	@JoinColumn(name="IDgenero")
	private Genero genero;
	
	@ManyToOne
	@NotNull
	@JoinColumn(name="IDplataforma")
	private Plataforma plataforma;
	
	@ManyToOne
	@NotNull
	@JoinColumn(name="IDjogo")
	private Jogo jogo;
	
	@ManyToOne
	@NotNull
	@JoinColumn(name="IDusuario")
	private Usuario usuario;

	@SuppressWarnings("unused")
	private GameCenter() {
		//constructor for hibernate
	}

	public GameCenter(Empresa empresa, Genero genero, Plataforma plataforma, Jogo jogo, Usuario usuario) {
		this.empresa = empresa;
		this.genero = genero;
		this.plataforma = plataforma;
		this.jogo = jogo;
		this.usuario = usuario;
		validarDominio();
	}

	public GameCenter(Integer id, Empresa empresa, Genero genero, Plataforma plataforma, Jogo jogo, Usuario usuario) {
		this(empresa, genero, plataforma, jogo, usuario);
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public Genero getGenero() {
		return genero;
	}

	public Plataforma getPlataforma() {
		return plataforma;
	}

	public Jogo getJogo() {
		return jogo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((empresa == null) ? 0 : empresa.hashCode());
		result = prime * result + ((genero == null) ? 0 : genero.hashCode());
		result = prime * result + ((jogo == null) ? 0 : jogo.hashCode());
		result = prime * result + ((plataforma == null) ? 0 : plataforma.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GameCenter other = (GameCenter) obj;
		if (empresa == null) {
			if (other.empresa != null)
				return false;
		} else if (!empresa.equals(other.empresa))
			return false;
		if (genero == null) {
			if (other.genero != null)
				return false;
		} else if (!genero.equals(other.genero))
			return false;
		if (jogo == null) {
			if (other.jogo != null)
				return false;
		} else if (!jogo.equals(other.jogo))
			return false;
		if (plataforma == null) {
			if (other.plataforma != null)
				return false;
		} else if (!plataforma.equals(other.plataforma))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}
	
}
