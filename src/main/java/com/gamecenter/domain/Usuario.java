package com.gamecenter.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.gamecenter.domain.beanvalidation.DataNascimento;

@Entity
@Table(name = "usuario")
public class Usuario extends BaseDominio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDusuario")
	private Integer id;
	
	@NotNull
	@NotEmpty
	@Size(min = 5, max = 30, message = "login deve ter entre 5 e 30 caracteres")
	private String login;
	
	@NotNull
	@NotEmpty
	@Size(min = 8, max = 24, message = "senha deve ter entre 5 e 30 caracteres")
	@Column(name = "pass")
	private String senha;
	
	@NotNull
	@NotEmpty
	@Size(min = 5, max = 30, message = "nickname deve ter entre 5 e 30 caracteres")
	@Column(name = "nick")
	private String nickname;
	
	@NotNull
	@NotEmpty
	@Email
	@Size(max = 100, message = "email deve ter no máximo 100 caracteres")
	private String email;
	
	@NotNull
	@DataNascimento
	private LocalDate nascimento;
	
	@SuppressWarnings("unused")
	private Usuario() {
		//constructor for hibernate
	}

	public Usuario(String login, String senha, String nickname, String email, LocalDate nascimento) {
		this.login = login;
		this.senha = senha;
		this.nickname = nickname;
		this.email = email;
		this.nascimento = nascimento;
		validarDominio();
	}

	public Usuario(Integer id, String login, String senha, String nickname, String email, LocalDate nascimento) {
		this(login, senha, nickname, email, nascimento);
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public String getLogin() {
		return login;
	}

	public String getSenha() {
		return senha;
	}

	public String getNickname() {
		return nickname;
	}

	public String getEmail() {
		return email;
	}

	public LocalDate getNascimento() {
		return nascimento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((nascimento == null) ? 0 : nascimento.hashCode());
		result = prime * result + ((nickname == null) ? 0 : nickname.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
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
		Usuario other = (Usuario) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (nascimento == null) {
			if (other.nascimento != null)
				return false;
		} else if (!nascimento.equals(other.nascimento))
			return false;
		if (nickname == null) {
			if (other.nickname != null)
				return false;
		} else if (!nickname.equals(other.nickname))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		return true;
	}
	
}
