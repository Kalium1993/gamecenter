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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gamecenter.dto.GeneroDTO;
import com.gamecenter.service.GeneroService;

@RestController
@RequestMapping(value = "gamecenter")
public class GeneroController {
	private GeneroService generoService;
	
	@Autowired
	public GeneroController(GeneroService generoService) {
		this.generoService = generoService;
	}
	
	@GetMapping(value = "/genero")
	public ResponseEntity<List<GeneroDTO>> obterGenero() {
		List<GeneroDTO> generos = generoService.findAll();
		
		return new ResponseEntity<List<GeneroDTO>>(generos, HttpStatus.OK);
	}
	
	@PostMapping(value = "/genero")
	public ResponseEntity<?> salvar(@RequestBody @Valid GeneroDTO generoDTO) {
		this.generoService.save(generoDTO);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/genero/{id}")
	public ResponseEntity<?> deletar(@PathVariable("id") Integer id) {
		this.generoService.delete(id);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
