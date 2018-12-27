package com.gamecenter.service;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.gamecenter.domain.Plataforma;
import com.gamecenter.dto.PlataformaDTO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PlataformaServiceTest {
	
	@Autowired
	private PlataformaService plataformaService;
	
	private PlataformaDTO plataformaDTO;
	
	@Before
	public void init() {
		plataformaDTO = new PlataformaDTO();
		plataformaDTO.setNome("Switch");
	}
	
	@After
	public void deleteAll() {
		plataformaService.deleteAll();
	}

	@Test
	public void DeveSalvarUmaPlataforma() {
		plataformaService.save(plataformaDTO);
		Plataforma plataformaSalva = plataformaService.findById(plataformaDTO.getId());
		
		assertEquals(plataformaDTO.getNome(), plataformaSalva.getNome());
	}
	
	@Test(expected = ServiceException.class)
	public void deveValidarSePlataformaJaExiste() {
		plataformaService.save(plataformaDTO);
		plataformaService.save(plataformaDTO);
	}
	
	@Test
	public void deveTestarFuncaoDeUpdate() {
		plataformaService.save(plataformaDTO);
		Plataforma plataformaSalva = plataformaService.findById(plataformaDTO.getId());
		
		Plataforma plataformaNova = new Plataforma(plataformaSalva.getId(), "PS4");
		plataformaService.update(plataformaNova);
		
		Plataforma plataformaAtualizada = plataformaService.findById(plataformaNova.getId());
		
		assertNotNull(plataformaAtualizada);
		assertEquals(plataformaAtualizada.getNome(), plataformaNova.getNome());
	}
}
