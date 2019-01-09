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
import com.gamecenter.dto.GeneroDTO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GeneroServiceTest {
	
	@Autowired
	private GeneroService generoService;
	
	private GeneroDTO generoDTO;
	
	@Before
	public void init() {
		generoDTO = new GeneroDTO();
		generoDTO.setNome("Ação");
	}
	
	@After
	public void deleteAll() {
		generoService.deleteAll();
	}
	
	@Test
	public void deveSalvarUmGenero() {
		generoService.save(generoDTO);
		Genero generoSalvo = generoService.findById(generoDTO.getId());
		
		assertEquals(generoDTO.getNome(), generoSalvo.getNome());
	}
	
	@Test(expected = ServiceException.class)
	public void deveValidarseGeneroJaExiste() {
		generoService.save(generoDTO);
		generoService.save(generoDTO);
	}
	
	@Test
	public void deveTetarFuncaoDeUpdate() {
		generoService.save(generoDTO);
		
		Genero generoSalvo = generoService.findById(generoDTO.getId());
		
		GeneroDTO generoNovo = new GeneroDTO();
		generoNovo.setId(generoSalvo.getId());
		generoNovo.setNome("RPG");
		generoService.update(generoNovo);
	
		Genero generoAtualizado = generoService.findById(generoNovo.getId());
		
		assertNotNull(generoAtualizado);
		assertEquals(generoAtualizado.getNome(), generoNovo.getNome());
	}
}