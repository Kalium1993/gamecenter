package com.gamecenter.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PlataformaDTO {
	private Integer id;

	@NotEmpty
	@NotNull
	@Size(min = 3, max = 64, message = "A plataforma do jogo deve ter entre 3 e 64 caracteres")
	private String nome;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
