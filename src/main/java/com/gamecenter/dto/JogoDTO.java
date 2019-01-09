package com.gamecenter.dto;

import java.time.LocalDate;

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

	@Size(min = 0, max = 10, message = "A nota deve ser entre 0 e 10")
	private Float notaUsuario;

	@Size(min = 0, max = 10, message = "A nota deve ser entre 0 e 10")
	private Float notaMidia;

	@NotNull
	@Size(min = 0, max = 18, message = "A classificação deve ser entre 0 e 18")
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

	public Float getNotaUsuario() {
		return notaUsuario;
	}

	public void setNotaUsuario(Float notaUsuario) {
		this.notaUsuario = notaUsuario;
	}

	public Float getNotaMidia() {
		return notaMidia;
	}

	public void setNotaMidia(Float notaMidia) {
		this.notaMidia = notaMidia;
	}

	public Integer getClassificaoIndicativa() {
		return classificaoIndicativa;
	}

	public void setClassificaoIndicativa(Integer classificaoIndicativa) {
		this.classificaoIndicativa = classificaoIndicativa;
	}
}
