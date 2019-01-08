package com.gamecenter.service;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.gamecenter.domain.Usuario;
import com.gamecenter.dto.UsuarioDTO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UsuarioServiceTest {
	@Autowired
	private UsuarioService usuarioService;

	private UsuarioDTO usuarioDTO;
	
	@Before
	public void init() {
		LocalDate nascimento = LocalDate.of(1993, 10, 27);
		
		usuarioDTO = new UsuarioDTO();
		usuarioDTO.setLogin("Kalium");
		usuarioDTO.setSenha("123456789");
		usuarioDTO.setNickname("Kalium");
		usuarioDTO.setEmail("mail@mail.com");
		usuarioDTO.setNascimento(nascimento);
	}
	
	@After
	public void deleteAll() {
		usuarioService.deleteAll();
	}
	
	@Test
	public void deveSalvarUmUsuario() {
		usuarioService.save(usuarioDTO);
		Usuario usuarioSalvo = usuarioService.findByLogin(usuarioDTO.getLogin());
		
		assertEquals(usuarioDTO.getLogin(), usuarioSalvo.getLogin());
		assertEquals(usuarioDTO.getSenha(), usuarioSalvo.getSenha());
		assertEquals(usuarioDTO.getNickname(), usuarioSalvo.getNickname());
		assertEquals(usuarioDTO.getEmail(), usuarioSalvo.getEmail());
		assertNotNull(usuarioSalvo.getNascimento());
	}
	
	@Test(expected = ServiceException.class)
	public void deveValidarSeUsuarioJaExiste() {
		usuarioService.save(usuarioDTO);
		usuarioService.save(usuarioDTO);
	}
	
	@Test
	public void deveTestarFuncaoUpdate() {
		usuarioService.save(usuarioDTO);
		Usuario usuarioSalvo = usuarioService.findById(usuarioDTO.getId());
		
		UsuarioDTO usuarioEditado = new UsuarioDTO(usuarioSalvo.getId(), "Kalium", "12345678910", "20matar", "email@mail.com", usuarioSalvo.getNascimento());
		usuarioService.update(usuarioEditado);
		
		Usuario usuarioAtualizado = usuarioService.findById(usuarioEditado.getId());
		
		assertNotNull(usuarioAtualizado);
		assertEquals(usuarioAtualizado.getLogin(), usuarioEditado.getLogin());
		assertEquals(usuarioAtualizado.getSenha(), usuarioEditado.getSenha());
		assertEquals(usuarioAtualizado.getNickname(), usuarioEditado.getNickname());
		assertEquals(usuarioAtualizado.getEmail(), usuarioEditado.getEmail());
		assertNotNull(usuarioAtualizado.getNascimento());
	}

}
