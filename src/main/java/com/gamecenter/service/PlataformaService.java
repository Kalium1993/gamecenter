package com.gamecenter.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gamecenter.domain.Plataforma;
import com.gamecenter.repository.PlataformaRepository;

@Service
public class PlataformaService {
	private PlataformaRepository platRep;
	
	@Autowired
	public PlataformaService(PlataformaRepository platRep) {
		this.platRep = platRep;
	}
	
	public void save(Plataforma plat) {
		validarPlataforma(plat);
		this.platRep.saveAndFlush(plat);
	}

	public void findById(Integer id) {
		Optional<Plataforma> platFounded = this.platRep.findById(id);
		if (platFounded.isPresent()) {
			platFounded.get();
		}
		throw new ServiceException("Plataforma não encontrada");
	}
	
	private void validarPlataforma(Plataforma plat) {
		Optional<Plataforma> platFounded = this.platRep.findById(plat.getId());
		if (platFounded.isPresent()) {
			throw new ServiceException("Plataforma já cadastrada");
		}
	}
}
