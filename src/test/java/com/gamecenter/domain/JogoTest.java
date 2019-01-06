package com.gamecenter.domain;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

public class JogoTest {
	private LocalDate lancamento = LocalDate.of(2017, 10, 27);

	@Test
	public void deveTestarCriacaoJogo() {
		Jogo jogo = new Jogo("Mario", lancamento, new Float(9.8), new Float(9.8), new Integer(0));
		
		assertEquals("Mario", jogo.getNome());
		assertNotNull(lancamento);
		assertEquals(new Float(9.8), jogo.getNotaUsuario());
		assertEquals(new Float(9.8), jogo.getNotaMidia());
		assertEquals(new Integer(0), jogo.getClassificacaoIndicativa());
	}
	
	@Test(expected = DominioInvalidoException.class)
	public void deveTestarErroDeNulo() {
		new Jogo(null, lancamento, new Float(9.8), new Float(9.8), new Integer(0));
	}
	
	@Test(expected = DominioInvalidoException.class)
	public void deveTestarErroDeVazio() {
		new Jogo("", lancamento, new Float(9.8), new Float(9.8), new Integer(0));
	}
	
	@Test(expected = DominioInvalidoException.class)
	public void deveTestarErroDeCaracterMax() {
		String nome = RandomStringUtils.randomAlphabetic(65);
		new Jogo(nome, lancamento, new Float(9.8), new Float(9.8), new Integer(0));
	}
	
	@Test(expected = DominioInvalidoException.class)
	public void deveTestarErroDeCaracterMin() {
		String nome = RandomStringUtils.randomAlphabetic(2);
		new Jogo(nome, lancamento, new Float(9.8), new Float(9.8), new Integer(0));
	}
	
	@Test(expected = DominioInvalidoException.class)
	public void deveTestarErroDeFloatMax() {
		new Jogo("Mario", lancamento, new Float(10.1), new Float(10.1), new Integer(0));
	}
	
	@Test(expected = DominioInvalidoException.class)
	public void deveTestarErroDeIntMax() {
		new Jogo("Mario", lancamento, new Float(9.8), new Float(9.8), new Integer(19));
	}
}
