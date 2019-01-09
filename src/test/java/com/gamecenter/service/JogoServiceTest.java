package com.gamecenter.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.gamecenter.domain.Jogo;
import com.gamecenter.dto.JogoDTO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JogoServiceTest {
	@Autowired
	private JogoService jogoService;
	
	private JogoDTO jogoDTO;
	
	@Before
	public void init() {
		jogoDTO = new JogoDTO();
		jogoDTO.setNome("Mario");
		jogoDTO.setLancamento(LocalDate.now());
		jogoDTO.setNotaUsuario(new Float(9.8));
		jogoDTO.setNotaMidia(new Float(9.8));
		jogoDTO.setClassificaoIndicativa(new Integer(0));
	}
	
	@After
	public void deletAll() {
		jogoService.deleteAll();
	}
	
	@Test
	public void deveSalvarUmJogo() {
		jogoService.save(jogoDTO);
		Jogo jogoSalvo = jogoService.findById(jogoDTO.getId());
		
		assertEquals(jogoDTO.getNome(), jogoSalvo.getNome());
		assertNotNull(jogoSalvo.getLancamento());
		assertEquals(jogoDTO.getNotaUsuario(), jogoSalvo.getNotaUsuario());
		assertEquals(jogoDTO.getNotaMidia(), jogoSalvo.getNotaMidia());
		assertEquals(jogoDTO.getClassificaoIndicativa(), jogoSalvo.getClassificacaoIndicativa());
	}
	
	@Test(expected = ServiceException.class)
	public void deveValidarSeJogoJaExiste() {
		jogoService.save(jogoDTO);
		jogoService.save(jogoDTO);
	}
	
	@Test
	public void deveTestarFuncaoUpdate() {
		jogoService.save(jogoDTO);
		Jogo jogoSalvo = jogoService.findById(jogoDTO.getId());
		
		JogoDTO jogoNovo = new JogoDTO();
		jogoNovo.setId(jogoSalvo.getId());
		jogoNovo.setNome("Zelda");
		jogoNovo.setLancamento(LocalDate.now());
		jogoNovo.setNotaUsuario(new Float(9.9));
		jogoNovo.setNotaMidia(new Float(9.9));
		jogoNovo.setClassificaoIndicativa(new Integer(12));
		jogoService.update(jogoNovo);
		
		Jogo jogoAtualizado = jogoService.findById(jogoNovo.getId());
		
		assertNotNull(jogoAtualizado);
		assertEquals(jogoAtualizado.getNome(), jogoNovo.getNome());
		assertNotNull(jogoAtualizado.getLancamento());
		assertEquals(jogoAtualizado.getNotaUsuario(), jogoNovo.getNotaUsuario());
		assertEquals(jogoAtualizado.getNotaMidia(), jogoNovo.getNotaMidia());
		assertEquals(jogoAtualizado.getClassificacaoIndicativa(), jogoNovo.getClassificaoIndicativa());
	}
}
