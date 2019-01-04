package com.gamecenter.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gamecenter.domain.Jogo;
import com.gamecenter.dto.JogoDTO;
import com.gamecenter.repository.JogoRepository;

@Service
public class JogoService {
	private JogoRepository jogoRepository;
	
	@Autowired
	public JogoService(JogoRepository jogoRepository) {
		this.jogoRepository = jogoRepository;
	}
	
	public void save(JogoDTO jogoDTO) {
		String nome = jogoDTO.getNome();
		LocalDate lancamento = jogoDTO.getLancamento();
		Float notaUsuario = jogoDTO.getNotaUsuario();
		Float notaMidia = jogoDTO.getNotaMidia();
		Integer classificacaoIndicativa = jogoDTO.getClassificaoIndicativa();
		
		Jogo jogo = new Jogo(nome, lancamento, notaUsuario, notaMidia, classificacaoIndicativa);
		validarJogo(jogo);
		
		this.jogoRepository.saveAndFlush(jogo);
		jogoDTO.setId(jogo.getId());
	}

	private void validarJogo(Jogo jogo) {
		Optional<Jogo> jogoFound = jogoRepository.findByName(jogo.getNome());
		if (jogoFound.isPresent()) {
			throw new ServiceException("Jogo já cadastrado");
		}
	}
	
	public Jogo findById(Integer id) {
		Optional<Jogo> jogoFound = jogoRepository.findById(id);
		if (jogoFound.isPresent()) {
			return jogoFound.get();
		}
		throw new ServiceException("Jogo não encontrado");
	}
	
	public Jogo findByName(String nome) {
		Optional<Jogo> jogoFound = jogoRepository.findByName(nome);
		if (jogoFound.isPresent()) {
			return jogoFound.get();
		}
		throw new ServiceException("Jogo não encontrado");
	}
	
	public void update(JogoDTO jogoDTO) {
		Integer id = jogoDTO.getId();
		String nome = jogoDTO.getNome();
		LocalDate lancamento = jogoDTO.getLancamento();
		Float notaUsuario = jogoDTO.getNotaUsuario();
		Float notaMidia = jogoDTO.getNotaMidia();
		Integer classificacaoIndicativa = jogoDTO.getClassificaoIndicativa();
		
		Jogo jogo = new Jogo(id, nome, lancamento, notaUsuario, notaMidia, classificacaoIndicativa);
		this.jogoRepository.saveAndFlush(jogo);
	}
	
	public void delete(Integer id) {
		this.jogoRepository.deleteById(id);
	}
	
	public void deleteAll() {
		this.jogoRepository.deleteAll();
	}
	
	public List<JogoDTO> findAll() {
		List<JogoDTO> jogoReturn = new ArrayList<JogoDTO>();
		List<Jogo> jogos = jogoRepository.findAll();
		
		for (Jogo jogo : jogos) {
			JogoDTO jogoDTO = new JogoDTO();
			jogoDTO.setId(jogo.getId());
			jogoDTO.setNome(jogo.getNome());
			jogoDTO.setLancamento(jogo.getLancamento());
			jogoDTO.setNotaUsuario(jogo.getNotaUsuario());
			jogoDTO.setNotaMidia(jogo.getNotaMidia());
			jogoDTO.setClassificaoIndicativa(jogo.getClassificacaoIndicativa());
			
			jogoReturn.add(jogoDTO);
		}
		
		return jogoReturn;
	}
}
