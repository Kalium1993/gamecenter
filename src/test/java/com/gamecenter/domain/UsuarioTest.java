package com.gamecenter.domain;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

public class UsuarioTest {
	private LocalDate nascimento = LocalDate.of(1993, 10, 27);
	
	@Test
	public void deveTestarCriacaoUsuario() {
		Usuario usuario = new Usuario("Kalium", "123456789", "Kalium", "mail@mail.com", nascimento);
		
		assertEquals("Kalium", usuario.getLogin());
		assertEquals("123456789", usuario.getSenha());
		assertEquals("Kalium", usuario.getNickname());
		assertEquals("mail@mail.com", usuario.getEmail());
		assertNotNull(nascimento);
	}
	
	@Test(expected = DominioInvalidoException.class)
	public void deveTestarErroNascimentoFuturo() {
		nascimento = LocalDate.of(2020, 10, 27);
		
		new Usuario("Kalium", "123456789", "Kalium", "mail@mail.com", nascimento);
	}
	
	@Test(expected = DominioInvalidoException.class)
	public void deveTestarErroSenhaCaracterMin() {
		String senha = RandomStringUtils.randomAlphabetic(7);
		
		new Usuario("Kalium", senha, "Kalium", "mail@mail.com", nascimento);
	}
	
	@Test(expected = DominioInvalidoException.class)
	public void deveTestarErroSenhaCaracterMax() {
		String senha = RandomStringUtils.randomAlphabetic(25);
		
		new Usuario("Kalium", senha, "Kalium", "mail@mail.com", nascimento);
	}
	
	@Test(expected = DominioInvalidoException.class)
	public void deveTestarErroEmail() {
		new Usuario("Kalium", "123456789", "Kalium", "email", nascimento);
	}
	
	@Test(expected = DominioInvalidoException.class)
	public void deveTestarErroLoginNulo() {
		new Usuario(null, "123456789", "Kalium", "mail@mail.com", nascimento);
	}
	
	@Test(expected = DominioInvalidoException.class)
	public void deveTestarErroLoginVazio() {
		new Usuario("", "123456789", "Kalium", "mail@mail.com", nascimento);
	}

}
