package com.gamecenter.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gamecenter.domain.Empresa;
import com.gamecenter.repository.EmpresaRepository;

@Service
public class EmpresaService {
	private EmpresaRepository empRep;

	@Autowired
	public EmpresaService(EmpresaRepository empRep) {
		this.empRep = empRep;
	}
	
	public void save(Empresa empresa) {
		validarEmpresa(empresa);
		this.empRep.saveAndFlush(empresa);
	}
	
	public void findById(Integer id) {
		Optional<Empresa> empFounded = this.empRep.findById(id);
		if (empFounded.isPresent()) {
			empFounded.get();
		}
		throw new ServiceException("Empresa não encontrada");
	}
	
	public void validarEmpresa(Empresa empresa) {
		Optional<Empresa> empFounded = this.empRep.findById(empresa.getId());
		if (empFounded.isPresent()) {
			throw new ServiceException("Empresa já cadastrada");
		}
	}
	
	public void update(Empresa empresa) {
		this.empRep.saveAndFlush(empresa);
	}
	
	public void deleteById(Integer id) {
		this.empRep.deleteById(id);
	}
}
