package com.gamecenter.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "genero")
public class Genero extends BaseDominio{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDgenero")
	private Integer id;
	
	@NotNull
	@NotEmpty
	@Size(min = 3, max = 64, message = "Genero de jogo deve ter entre 3 e 64 caracteres")
	@Column(name = "genero")
	private String nome;
	
	@SuppressWarnings("unused")
	private Genero() {
		//constructor for hibernate
	}
	
	public Genero(String nome) {
		this.nome = nome;
		validarDominio();
	}

	public Genero(Integer id, String nome) {
		this(nome);
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Genero other = (Genero) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
}
