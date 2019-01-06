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
@Table(name = "empresa")
public class Empresa extends BaseDominio{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDempresa")
	private Integer id;
	
	@NotNull
	@NotEmpty
	@Size(min = 3, max = 80, message = "Nome de empresa deve ter entre 3 e 80 caracteres")
	@Column(name = "empresa")
	private String nome;
	
	
	@SuppressWarnings("unused")
	private Empresa() {
		// constructor for hibernate
	}

	public Empresa(String nome) {
		//ifMicrosoft(nome);
		this.nome = nome;
		validarDominio();
	}

	/*private void ifMicrosoft(String nome) {
		if (nome.length() == 2) {
			nome.toUpperCase();
			
			if (nome.equals("MS")) {
				nome = "Microsoft";
			}
		}
	}*/

	public Empresa(Integer id, String nome) {
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
		Empresa other = (Empresa) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
	
	
	
}
