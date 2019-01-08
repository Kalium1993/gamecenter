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
	
	@Before
	public void init() {
		empresaDTO = new EmpresaDTO();
		empresaDTO.setNome("Nintendo");
	}

	@After
	public void deleteAll() {
		empresaService.deleteAll();
	}
	
	@Test
	public void deveSalvarUmaEmpresa() {
		empresaService.save(empresaDTO);
		Empresa empresaSalva = empresaService.findById(empresaDTO.getId());
		
		assertEquals(empresaDTO.getNome(), empresaSalva.getNome());
	}
	
	@Test(expected = ServiceException.class)
	public void deveValidarSeEmpresaJaExiste() {
		empresaService.save(empresaDTO);
		empresaService.save(empresaDTO);
	}
	
	/*@Test(expected = ServiceException.class)
	public void deveTestarFuncaoDelete() {
		empresaService.save(empresaDTO);
		empresaService.delete(empresaDTO.getId());
	}*/
	
	@Test
	public void deveTestarFuncaoUpdate() {
		empresaService.save(empresaDTO);
		Empresa empresaSalva = empresaService.findById(empresaDTO.getId());
		
		EmpresaDTO empresaNova = new EmpresaDTO(empresaSalva.getId(), "Sony");
		empresaService.update(empresaNova);
		
		Empresa empresaAtualizada = empresaService.findById(empresaNova.getId());
		
		assertNotNull(empresaAtualizada);
		assertEquals(empresaAtualizada.getNome(), empresaNova.getNome());
	}

}
