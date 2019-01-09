package com.gamecenter.controller;

//import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gamecenter.dto.GamecenterDTO;
import com.gamecenter.service.GamecenterService;

@RestController
@RequestMapping(value = "gamecenter")
public class GamecenterController {
	private GamecenterService gamecenterService;
	
	@Autowired
	public GamecenterController(GamecenterService gamecenterService) {
		this.gamecenterService = gamecenterService;
	}
	
	/*@GetMapping(value = "/gamecenter")
	public ResponseEntity<List<GamecenterDTO>> obtainAll() {
		List<GamecenterDTO> gamecenters = gamecenterService.findAll();
		
		return new ResponseEntity<List<GamecenterDTO>>(gamecenters, HttpStatus.OK);
	}*/
	
	@PostMapping(value = "/gamecenter") 
	public ResponseEntity<?> save(@RequestBody @Valid GamecenterDTO gamecenterDTO) {
		this.gamecenterService.save(gamecenterDTO);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping(value = "/gamecenter") 
	public ResponseEntity<?> update(@RequestBody @Valid GamecenterDTO gamecenterDTO) {
		this.gamecenterService.update(gamecenterDTO);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/gamecenter{id}") 
	public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
		this.gamecenterService.delete(id);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
