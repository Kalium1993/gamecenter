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

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmpresaServiceTest {
	
	@Autowired
	private EmpresaService empServ;
	
	private Empresa emp;
	
	@Before
	public void init() {
		emp = new Empresa("Nintendo");
	}

	@After
	public void deleteAll() {
		empServ.deleteAll();
	}
	
	@Test
	public void deveSalvarUmaEmpresa() {
		empServ.save(emp);
		
		Empresa empSalva = empServ.findById(emp.getId());
		assertEquals(emp.getNome(), empSalva.getNome());
	}
	
	@Test(expected = ServiceException.class)
	public void deveValidarSeEmpresaJaExiste() {
		empServ.save(emp);
		empServ.save(emp);
	}
	
	/*@Test(expected = NullPointerException.class)
	public void deveTestarFuncaoDelete() {
		empServ.save(emp);
		empServ.delete(emp);
	}*/
	
	@Test
	public void deveTestarFuncaoUpdate() {
		empServ.save(emp);
		
		Empresa empSalva = empServ.findById(emp.getId());
		
		Empresa empNova = new Empresa(empSalva.getId(), "Sony");
		empServ.update(empNova);
		
		Empresa empAtualizada = empServ.findById(empNova.getId());
		
		assertNotNull(empAtualizada);
		assertEquals(empAtualizada.getNome(), empNova.getNome());
	}

}
