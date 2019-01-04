package com.gamecenter.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gamecenter.dto.JogoDTO;
import com.gamecenter.service.JogoService;

@RestController
@RequestMapping(value = "gamecenter")
public class JogoController {
	private JogoService jogoService;
	
	@Autowired
	public JogoController(JogoService jogoService) {
		this.jogoService = jogoService;
	}
	
	@GetMapping(value = "/jogo")
	public ResponseEntity<List<JogoDTO>> obterJogos() {
		List<JogoDTO> jogos = jogoService.findAll();
		
		return new ResponseEntity<List<JogoDTO>>(jogos, HttpStatus.OK);
	}
	
	@PostMapping(value = "/jogo")
	public ResponseEntity<?> salvar(@RequestBody @Valid JogoDTO jogoDTO) {
		this.jogoService.save(jogoDTO);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping(value = "/jogo")
	public ResponseEntity<?> editar(@RequestBody @Valid JogoDTO jogoDTO) {
		this.jogoService.update(jogoDTO);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/jogo/{id}")
	public ResponseEntity<?> deletar(@PathVariable("id") Integer id) {
		this.jogoService.delete(id);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
