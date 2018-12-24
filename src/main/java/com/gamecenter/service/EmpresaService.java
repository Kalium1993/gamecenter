package com.gamecenter.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gamecenter.domain.Empresa;
import com.gamecenter.dto.EmpresaDTO;
import com.gamecenter.repository.EmpresaRepository;

@Service
public class EmpresaService {
	private EmpresaRepository empresaRepository;

	@Autowired
	public EmpresaService(EmpresaRepository empresaRepository) {
		this.empresaRepository = empresaRepository;
	}
	
	public void save(EmpresaDTO empresaDTO) {
		String nome = empresaDTO.getNome();
		
		Empresa empresa = new Empresa(nome);
		
		validarEmpresa(empresa);
		this.empresaRepository.saveAndFlush(empresa);
	}
	
	public Empresa findById(Integer id) {
		Optional<Empresa> empFounded = empresaRepository.findById(id);
		if (empFounded.isPresent()) {
			return empFounded.get();
		}
		throw new ServiceException("Empresa não encontrada");
	}
	
	public Empresa findByName(String nome) {
		Optional<Empresa> empFounded = empresaRepository.findByName(nome);
		if (empFounded.isPresent()) {
			return empFounded.get();
		}
		throw new ServiceException("Empresa não encontrada");
	}
	
	private void validarEmpresa(Empresa empresa) {
		Optional<Empresa> empFounded = empresaRepository.findByName(empresa.getNome());
		if (empFounded.isPresent()) {
			throw new ServiceException("Empresa já cadastrada");
		}
	}
	
	public void update(Empresa empresa) {
		this.empresaRepository.saveAndFlush(empresa);
	}
	
	public void delete(Empresa empresa) {
		this.empresaRepository.delete(empresa);
	}

	public void deleteAll() {
		this.empresaRepository.deleteAll();
	}
	
	public List<EmpresaDTO> findAll() {
		List<EmpresaDTO> empresaReturn = new ArrayList<EmpresaDTO>();
		List<Empresa> empresas = empresaRepository.findAll();
		
		for(Empresa empresa : empresas) {
			EmpresaDTO empresaDTO = new EmpresaDTO();
			empresaDTO.setNome(empresa.getNome());
			empresaReturn.add(empresaDTO);
		}
		
		return empresaReturn;
	}
}
