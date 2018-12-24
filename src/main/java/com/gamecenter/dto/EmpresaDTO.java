package com.gamecenter.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class EmpresaDTO {
	
	@NotNull
	@NotEmpty
	@Size(min = 3, max = 80, message = "Nome de empresa deve ter entre 3 e 80 caracteres")
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
