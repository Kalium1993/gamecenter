package com.gamecenter.domain;

import static org.junit.Assert.*;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

import com.gamecenter.domain.DominioInvalidoException;

public class EmpresaTest {

	@Test
	public void deveCriarEmpresaValida() {
		Empresa emp = new Empresa("Nintendo");
		assertEquals("Nintendo", emp.getNome());
	}
	
	@Test(expected = DominioInvalidoException.class)
	public void deveValidarErroDeEmpresaNula() {
		new Empresa(null);
	}
	
	@Test(expected = DominioInvalidoException.class)
	public void deveValidarErroDeEmpresaVazia() {
		new Empresa("");
	}

	@Test(expected = DominioInvalidoException.class)
	public void deveValidarErroDeEmpresaCaractererMinimo() {
		String nome = RandomStringUtils.randomAlphabetic(2);
		new Empresa(nome);
	}
	
	@Test(expected = DominioInvalidoException.class)
	public void deveValidarErroDeEmpresaCaractererMaximo() {
		String nome = RandomStringUtils.randomAlphabetic(81);
		new Empresa(nome);
	}
}
