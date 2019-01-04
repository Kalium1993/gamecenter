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

import com.gamecenter.dto.UsuarioDTO;
import com.gamecenter.service.UsuarioService;

@RestController
@RequestMapping(value = "gamecenter")
public class UsuarioController {
	private UsuarioService usuarioService;
	
	@Autowired
	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
	@GetMapping(value = "/usuario")
	public ResponseEntity<List<UsuarioDTO>> obterUsuarios() {
		List<UsuarioDTO> usuarios = usuarioService.findAll();
		
		return new ResponseEntity<List<UsuarioDTO>>(usuarios, HttpStatus.OK);
	}
	
	@PostMapping(value = "/usuario")
	public ResponseEntity<?> salvar(@RequestBody @Valid UsuarioDTO usuarioDTO) {
		this.usuarioService.save(usuarioDTO);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping(value = "/usuario")
	public ResponseEntity<?> editar(@RequestBody @Valid UsuarioDTO usuarioDTO) {
		this.usuarioService.update(usuarioDTO);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/usuario/{id}")
	public ResponseEntity<?> deletar(@PathVariable("id") Integer id) {
		this.usuarioService.delete(id);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
