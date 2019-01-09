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

import com.gamecenter.dto.PlataformaDTO;
import com.gamecenter.service.PlataformaService;

@RestController
@RequestMapping(value = "gamecenter")
public class PlataformaController {
	private PlataformaService plataformaService;
	
	@Autowired
	public PlataformaController(PlataformaService plataformaService) {
		this.plataformaService = plataformaService;
	}
	
	@GetMapping(value = "/plataforma")
	public ResponseEntity<List<PlataformaDTO>> obterPlataformas() {
		List<PlataformaDTO> plataformas = plataformaService.findAll();
		
		return new ResponseEntity<List<PlataformaDTO>>(plataformas, HttpStatus.OK);
	}
	
	@PostMapping(value = "/plataforma")
	public ResponseEntity<?> salvar(@RequestBody @Valid PlataformaDTO plataformaDTO) {
		this.plataformaService.save(plataformaDTO);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/plataforma/{id}")
	public ResponseEntity<?> deletar(@PathVariable("id") Integer id) {
		this.plataformaService.delete(id);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping(value = "/plataforma")
	public ResponseEntity<?> editar(@RequestBody @Valid PlataformaDTO plataformaDTO) {
		this.plataformaService.update(plataformaDTO);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
