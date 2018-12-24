package com.gamecenter.service;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.gamecenter.domain.Empresa;
import com.gamecenter.dto.EmpresaDTO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmpresaServiceTest {
	
	@Autowired
	private EmpresaService empresaService;
	
	private EmpresaDTO empresaDTO;
	private Empresa empresaSalva;
	
	@Before
	public void init() {
		empresaDTO = new EmpresaDTO();
		empresaDTO.setNome("Nintendo");
		
		empresaService.save(empresaDTO);
		empresaSalva = empresaService.findByName(empresaDTO.getNome());
	}

	@After
	public void deleteAll() {
		empresaService.deleteAll();
	}
	
	@Test
	public void deveSalvarUmaEmpresa() {
	
		assertEquals(empresaDTO.getNome(), empresaSalva.getNome());
	}
	
	@Test(expected = ServiceException.class)
	public void deveValidarSeEmpresaJaExiste() {
		empresaService.save(empresaDTO);
	}
	
	/*@Test(expected = NullPointerException.class)
	public void deveTestarFuncaoDelete() {
		empresaService.delete(empresaDTO);
	}*/
	
	@Test
	public void deveTestarFuncaoUpdate() {
		Empresa empresaNova = new Empresa(empresaSalva.getId(), "Sony");
		empresaService.update(empresaNova);
		
		Empresa empresaAtualizada = empresaService.findById(empresaNova.getId());
		
		assertNotNull(empresaAtualizada);
		assertEquals(empresaAtualizada.getNome(), empresaNova.getNome());
	}

}
