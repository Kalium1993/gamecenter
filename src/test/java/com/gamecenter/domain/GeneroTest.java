package com.gamecenter.domain;

import static org.junit.Assert.*;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

public class GeneroTest {

	@Test
	public void deveTestarCriacaoDeGeneroValido() {
		Genero genero = new Genero("Ação");
		assertEquals("Ação", genero.getNome());
	}
	
	@Test(expected = DominioInvalidoException.class)
	public void deveTestarErroGeneroNulo() {
		new Genero(null);
	}
	
	@Test(expected = DominioInvalidoException.class)
	public void deveTestarErroGeneroVazio() {
		new Genero("");
	}
	
	@Test(expected = DominioInvalidoException.class)
	public void deveTestarErroGeneroCaracterMinimo() {
		String nome = RandomStringUtils.randomAlphabetic(2);
		new Genero(nome);
	}
	
	@Test(expected = DominioInvalidoException.class)
	public void deveTestarErroGeneroCaracterMaximo() {
		String nome = RandomStringUtils.randomAlphabetic(65);
		new Genero(nome);
	}

}
