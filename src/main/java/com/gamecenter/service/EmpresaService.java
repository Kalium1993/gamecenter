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
		empresaDTO.setId(empresa.getId());
	}

	public Empresa findById(Integer id) {
		Optional<Empresa> empFound = empresaRepository.findById(id);
		if (empFound.isPresent()) {
			return empFound.get();
		}
		throw new ServiceException("Empresa não encontrada");
	}

	public Empresa findByName(String nome) {
		Optional<Empresa> empFound = empresaRepository.findByName(nome);
		if (empFound.isPresent()) {
			return empFound.get();
		}
		throw new ServiceException("Empresa não encontrada");
	}

	private void validarEmpresa(Empresa empresa) {
		Optional<Empresa> empFound = empresaRepository.findByName(empresa.getNome());
		if (empFound.isPresent()) {
			throw new ServiceException("Empresa já cadastrada");
		}
	}

	public void update(EmpresaDTO empresaDTO) {
		String nome = empresaDTO.getNome();
		Integer id = empresaDTO.getId();

		Empresa empresa = new Empresa(id, nome);
		
		this.empresaRepository.saveAndFlush(empresa);
	}

	public void delete(Integer id) {
		this.empresaRepository.deleteById(id);
	}

	public void deleteAll() {
		this.empresaRepository.deleteAll();
	}

	public List<EmpresaDTO> findAll() {
		List<EmpresaDTO> empresaReturn = new ArrayList<EmpresaDTO>();
		List<Empresa> empresas = empresaRepository.findAll();

		for (Empresa empresa : empresas) {
			EmpresaDTO empresaDTO = new EmpresaDTO();
			empresaDTO.setId(empresa.getId());
			empresaDTO.setNome(empresa.getNome());
			empresaReturn.add(empresaDTO);
		}

		return empresaReturn;
	}
}
