package com.gamecenter.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gamecenter.dto.EmpresaDTO;
import com.gamecenter.service.EmpresaService;

@RestController
@RequestMapping(value = "gamecenter")
public class EmpresaController {
	
	private EmpresaService empresaService;
	
	@Autowired
	public EmpresaController(EmpresaService empresaService) {
		this.empresaService = empresaService;
	}
	
	@GetMapping(value="/empresa")
	public ResponseEntity<?> obterEmpresa(@RequestBody @Valid EmpresaDTO empresaDTO) {
		this.empresaService.save(empresaDTO);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping(value="/empresa")
	public ResponseEntity<?> salvar(@RequestBody @Valid EmpresaDTO empresaDTO) {
		this.empresaService.save(empresaDTO);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
