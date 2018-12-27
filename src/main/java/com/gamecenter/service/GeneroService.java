package com.gamecenter.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gamecenter.domain.Genero;
import com.gamecenter.dto.GeneroDTO;
import com.gamecenter.repository.GeneroRepository;

@Service
public class GeneroService {
	private GeneroRepository generoRepository;

	@Autowired
	public GeneroService(GeneroRepository generoRepository) {
		this.generoRepository = generoRepository;
	}
	
	public void save(GeneroDTO generoDTO) {
		String nome = generoDTO.getNome();
		
		Genero genero = new Genero(nome);
		
		validarGenero(genero);
		this.generoRepository.saveAndFlush(genero);
		generoDTO.setId(genero.getId());
	}

	private void validarGenero(Genero genero) {
		Optional<Genero> genFounded = this.generoRepository.findByName(genero.getNome());
		if (genFounded.isPresent()) {
			throw new ServiceException("Gênero já cadastrado");
		}
	}
	
	public Genero findById(Integer id) {
		Optional<Genero> genFounded = this.generoRepository.findById(id);
		if (genFounded.isPresent()) {
			return genFounded.get();
		}
		throw new ServiceException("Gênero não encontrado");
	}
	
	public Genero findByName(Genero genero) {
		Optional<Genero> genFounded = this.generoRepository.findByName(genero.getNome());
		if (genFounded.isPresent()) {
			return genFounded.get();
		}
		throw new ServiceException("Gênero não encontrado");
	}
	
	public void update(Genero genero) {
		this.generoRepository.saveAndFlush(genero);
	}
	
	public void delete(Integer id) {
		this.generoRepository.deleteById(id);
	}
	
	public void deleteAll() {
		this.generoRepository.deleteAll();
	}
	
	public List<GeneroDTO> findAll() {
		List<GeneroDTO> generoReturn = new ArrayList<GeneroDTO>();
		List<Genero> generos = generoRepository.findAll();
		
		for(Genero genero : generos) {
			GeneroDTO generoDTO = new GeneroDTO();
			generoDTO.setId(genero.getId());
			generoDTO.setNome(genero.getNome());
			generoReturn.add(generoDTO);
		}
		
		return generoReturn;
	}
	
}
