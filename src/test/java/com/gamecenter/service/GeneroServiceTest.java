package com.gamecenter.service;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.gamecenter.domain.Genero;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GeneroServiceTest {
	
	@Autowired
	private GeneroService generoService;
	
	private Genero genero;
	
	@Before
	public void init() {
		genero = new Genero("Ação");
	}
	
	@After
	public void deleteAll() {
		generoService.deleteAll();
	}
	
	@Test
	public void deveSalvarUmGenero() {
		generoService.save(genero);
		Genero generoSalvo = generoService.findById(genero.getId());
		
		assertEquals(genero.getNome(), generoSalvo.getNome());
	}
	
	@Test(expected = ServiceException.class)
	public void deveValidarseGeneroJaExiste() {
		generoService.save(genero);
		generoService.save(genero);
	}
	
	@Test
	public void deveTetarFuncaoDeUpdate() {
		generoService.save(genero);
		
		Genero generoSalvo = generoService.findById(genero.getId());
		
		Genero generoNovo = new Genero(generoSalvo.getId(), "RPG");
		generoService.update(generoNovo);
	
		Genero generoAtualizado = generoService.findById(generoNovo.getId());
		
		assertNotNull(generoAtualizado);
		assertEquals(generoAtualizado.getNome(), generoNovo.getNome());
	}
}