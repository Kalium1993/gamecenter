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
		Optional<Plataforma> platFound = this.plataformaRepository.findByName(plataforma.getNome());
		if (platFound.isPresent()) {
			throw new ServiceException("Plataforma já cadastrada");
		}
	}
	
	public Plataforma findById(Integer id) {
		Optional<Plataforma> platFound = this.plataformaRepository.findById(id);
		if (platFound.isPresent()) {
			return platFound.get();
		}
		throw new ServiceException("Plataforma não encontrada");
	}
	
	public Plataforma findByName(Plataforma plataforma) {
		Optional<Plataforma> platFound = this.plataformaRepository.findByName(plataforma.getNome());
		if (platFound.isPresent()) {
			return platFound.get();
		}
		throw new ServiceException("Plataforma não encontrada");
	}
	
	public void update(PlataformaDTO plataformaDTO) {
		String nome = plataformaDTO.getNome();
		Integer id = plataformaDTO.getId();
		
		Plataforma plataforma = new Plataforma(id, nome);
		
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
