package com.gamecenter.dto;

import java.time.LocalDate;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class JogoDTO {
	private Integer id;

	@NotEmpty
	@NotNull
	@Size(min = 3, max = 64, message = "o nome do jogo deve ter entre 3 e 80 caracteres")
	private String nome;

	@NotNull
	private LocalDate lancamento;

	@Min(0)
	@Max(10)
	private Integer notaUsuario;

	@Min(0)
	@Max(10)
	private Integer notaMidia;

	@NotNull
	@Min(0)
	@Max(18)
	private Integer classificaoIndicativa;

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

	public LocalDate getLancamento() {
		return lancamento;
	}

	public void setLancamento(LocalDate lancamento) {
		this.lancamento = lancamento;
	}

	public Integer getNotaUsuario() {
		return notaUsuario;
	}

	public void setNotaUsuario(Integer notaUsuario) {
		this.notaUsuario = notaUsuario;
	}

	public Integer getNotaMidia() {
		return notaMidia;
	}

	public void setNotaMidia(Integer notaMidia) {
		this.notaMidia = notaMidia;
	}

	public Integer getClassificaoIndicativa() {
		return classificaoIndicativa;
	}

	public void setClassificaoIndicativa(Integer classificaoIndicativa) {
		this.classificaoIndicativa = classificaoIndicativa;
	}
}
