package com.gamecenter.domain;

import java.time.LocalDate;

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
@Table(name = "jogo")
public class Jogo extends BaseDominio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDjogo")
	private Integer id;
	
	@NotEmpty
	@NotNull
	@Size(min = 3, max = 64, message = "o nome do jogo deve ter entre 3 e 80 caracteres")
	@Column(name = "jogo")
	private String nome;
	
	@NotNull
	private LocalDate lancamento;
	
	@Size(min = 0, max = 10, message = "A nota deve ser entre 0 e 10")
	@Column(name = "nota_usuarios")
	private Float notaUsuario;
	
	@Size(min = 0, max = 10, message = "A nota deve ser entre 0 e 10")
	@Column(name = "nota_midia")
	private Float notaMidia;
	
	@NotNull
	@Size(min = 0, max = 18, message = "A classificação deve ser entre 0 e 18")
	@Column(name = "classificacao")
	private Integer classificacaoIndicativa;

	@SuppressWarnings("unused")
	private Jogo() {
		//constructor for hibernate
	}

	public Jogo(String nome, LocalDate lancamento, Float notaUsuario, Float notaMidia, Integer classificacaoIndicativa) {
		this.nome = nome;
		this.lancamento = lancamento;
		this.notaUsuario = notaUsuario;
		this.notaMidia = notaMidia;
		this.classificacaoIndicativa = classificacaoIndicativa;
		validarDominio();
	}

	public Jogo(Integer id, String nome, LocalDate lancamento, Float notaUsuario, Float notaMidia, Integer classificacaoIndicativa) {
		this(nome, lancamento, notaUsuario, notaMidia, classificacaoIndicativa);
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public LocalDate getLancamento() {
		return lancamento;
	}

	public Float getNotaUsuario() {
		return notaUsuario;
	}

	public Float getNotaMidia() {
		return notaMidia;
	}

	public Integer getClassificacaoIndicativa() {
		return classificacaoIndicativa;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((classificacaoIndicativa == null) ? 0 : classificacaoIndicativa.hashCode());
		result = prime * result + ((lancamento == null) ? 0 : lancamento.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((notaMidia == null) ? 0 : notaMidia.hashCode());
		result = prime * result + ((notaUsuario == null) ? 0 : notaUsuario.hashCode());
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
		Jogo other = (Jogo) obj;
		if (classificacaoIndicativa == null) {
			if (other.classificacaoIndicativa != null)
				return false;
		} else if (!classificacaoIndicativa.equals(other.classificacaoIndicativa))
			return false;
		if (lancamento == null) {
			if (other.lancamento != null)
				return false;
		} else if (!lancamento.equals(other.lancamento))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (notaMidia == null) {
			if (other.notaMidia != null)
				return false;
		} else if (!notaMidia.equals(other.notaMidia))
			return false;
		if (notaUsuario == null) {
			if (other.notaUsuario != null)
				return false;
		} else if (!notaUsuario.equals(other.notaUsuario))
			return false;
		return true;
	}
	
}
