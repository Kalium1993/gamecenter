package com.gamecenter.domain;

import static org.junit.Assert.*;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

public class PlataformaTest {

	@Test
	public void deveTestarCriacaoValidaPlataforma() {
		Plataforma plataforma = new Plataforma("Switch");
		assertEquals("Switch", plataforma.getNome());
	}
	
	@Test(expected = DominioInvalidoException.class)
	public void deveTestarErroPlataformaNula() {
		new Plataforma(null);
	}
	
	@Test(expected = DominioInvalidoException.class)
	public void deveTestarErroPlataformaVazia() {
		new Plataforma("");
	}
	
	@Test(expected = DominioInvalidoException.class)
	public void deveTestarErroCaracteresMinimo() {
		String nome = RandomStringUtils.randomAlphabetic(2);
		new Plataforma(nome);
	}
	
	@Test(expected = DominioInvalidoException.class)
	public void deveTestarErroCaracteresMaximo() {
		String nome = RandomStringUtils.randomAlphabetic(65);
		new Plataforma(nome);
	}

}
