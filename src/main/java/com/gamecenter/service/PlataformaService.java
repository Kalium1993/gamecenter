package com.gamecenter.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gamecenter.domain.Plataforma;
import com.gamecenter.dto.PlataformaDTO;
import com.gamecenter.repository.PlataformaRepository;

@Service
public class PlataformaService {
	private PlataformaRepository plataformaRepository;
	
	@Autowired
	public PlataformaService(PlataformaRepository plataformaRepository) {
		this.plataformaRepository = plataformaRepository;
	}
	
	public void save(PlataformaDTO plataformaDTO) {
		String nome = plataformaDTO.getNome();
		
		Plataforma plataforma = new Plataforma(nome);
		
		validarPlataforma(plataforma);
		this.plataformaRepository.saveAndFlush(plataforma);
		plataformaDTO.setId(plataforma.getId());
	}

	private void validarPlataforma(Plataforma plataforma) {
		Optional<Plataforma> platFounded = this.plataformaRepository.findByName(plataforma.getNome());
		if (platFounded.isPresent()) {
			throw new ServiceException("Plataforma já cadastrada");
		}
	}
	
	public Plataforma findById(Integer id) {
		Optional<Plataforma> platFounded = this.plataformaRepository.findById(id);
		if (platFounded.isPresent()) {
			return platFounded.get();
		}
		throw new ServiceException("Plataforma não encontrada");
	}
	
	public Plataforma findByName(Plataforma plataforma) {
		Optional<Plataforma> platFounded = this.plataformaRepository.findByName(plataforma.getNome());
		if (platFounded.isPresent()) {
			return platFounded.get();
		}
		throw new ServiceException("Plataforma não encontrada");
	}
	
	public void update(Plataforma plataforma) {
		this.plataformaRepository.saveAndFlush(plataforma);
	}
	
	public void delete(Integer id) {
		this.plataformaRepository.deleteById(id);
	}
	
	public void deleteAll() {
		this.plataformaRepository.deleteAll();
	}
	
	public List<PlataformaDTO> findAll() {
		List<PlataformaDTO> plataformaReturn = new ArrayList<PlataformaDTO>();
		List<Plataforma> plataformas = plataformaRepository.findAll();
		
		for(Plataforma plataforma : plataformas) {
			PlataformaDTO plataformaDTO = new PlataformaDTO();
			plataformaDTO.setId(plataforma.getId());
			plataformaDTO.setNome(plataforma.getNome());
			plataformaReturn.add(plataformaDTO);
		}
		
		return plataformaReturn;
	}
}
