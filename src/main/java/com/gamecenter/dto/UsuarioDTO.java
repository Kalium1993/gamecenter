package com.gamecenter.dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.gamecenter.domain.beanvalidation.DataNascimento;

public class UsuarioDTO {
	private Integer id;
	
	@NotNull
	@NotEmpty
	@Size(min = 5, max = 30, message = "login deve ter entre 5 e 30 caracteres")
	@Column(updatable=false, insertable=true)
	private String login;
	
	@NotNull
	@NotEmpty
	@Size(min = 8, max = 24, message = "senha deve ter entre 8 e 24 caracteres")
	private String senha;
	
	@NotNull
	@NotEmpty
	@Size(min = 5, max = 30, message = "nickname deve ter entre 5 e 30 caracteres")
	private String nickname;
	
	@NotNull
	@NotEmpty
	@Email
	@Size(max = 100, message = "email deve ter no máximo 100 caracteres")
	private String email;
	
	@NotNull
	@DataNascimento
	private LocalDate nascimento;

	public UsuarioDTO() {
		
	}

	public UsuarioDTO(Integer id, String login, String senha, String nickname, String email, LocalDate nascimento) {
		this.id = id;
		this.login = login;
		this.senha = senha;
		this.nickname = nickname;
		this.email = email;
		this.nascimento = nascimento;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getNascimento() {
		return nascimento;
	}

	public void setNascimento(LocalDate nascimento) {
		this.nascimento = nascimento;
	}
	
}
