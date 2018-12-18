package com.gamecenter.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gamecenter.domain.Genero;
import com.gamecenter.repository.GeneroRepository;

@Service
public class GeneroService {
	private GeneroRepository genRep;

	@Autowired
	public GeneroService(GeneroRepository genRep) {
		this.genRep = genRep;
	}
	
	public void save(Genero gen) {
		validarGenero(gen);
		this.genRep.saveAndFlush(gen);
	}

	public void findById(Integer id) {
		Optional<Genero> genFounded = this.genRep.findById(id);
		if (genFounded.isPresent()) {
			genFounded.get();
		}
		throw new ServiceException("Gênero não encontrado");
	}
	
	public void validarGenero(Genero gen) {
		Optional<Genero> genFounded = this.genRep.findById(gen.getId());
		if (genFounded.isPresent()) {
			throw new ServiceException("Gênero já cadastrado");
		}
	}
	
	public void update(Genero gen) {
		this.genRep.saveAndFlush(gen);
	}
	
	public void delete(Genero gen) {
		this.genRep.delete(gen);
	}
	
}
