package com.gamecenter.service;

//import java.util.ArrayList;
//import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gamecenter.domain.Empresa;
import com.gamecenter.domain.Gamecenter;
import com.gamecenter.domain.Genero;
import com.gamecenter.domain.Jogo;
import com.gamecenter.domain.Plataforma;
import com.gamecenter.domain.Usuario;
import com.gamecenter.dto.GamecenterDTO;
import com.gamecenter.repository.EmpresaRepository;
import com.gamecenter.repository.GamecenterRepository;
import com.gamecenter.repository.GeneroRepository;
import com.gamecenter.repository.JogoRepository;
import com.gamecenter.repository.PlataformaRepository;
import com.gamecenter.repository.UsuarioRepository;

@Service
public class GamecenterService {
	
	private GamecenterRepository gamecenterRepository;
	private EmpresaRepository empresaRepository;
	private GeneroRepository generoRepository;
	private PlataformaRepository plataformaRepository;
	private JogoRepository jogoRepository;
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	public GamecenterService(GamecenterRepository gamecenterRepository, EmpresaRepository empresaRepository, GeneroRepository generoRepository, 
			PlataformaRepository plataformaRepository, JogoRepository jogoRepository, UsuarioRepository usuarioRepository) {
		this.gamecenterRepository = gamecenterRepository;
		this.empresaRepository = empresaRepository;
		this.generoRepository = generoRepository;
		this.plataformaRepository = plataformaRepository;
		this.jogoRepository = jogoRepository;
		this.usuarioRepository = usuarioRepository;
	}
	
	public void save(GamecenterDTO gamecenterDTO) {
		Optional<Empresa> empresa = empresaRepository.findByName(gamecenterDTO.getEmpresa());
		Optional<Genero> genero = generoRepository.findByName(gamecenterDTO.getGenero());
		Optional<Plataforma> plataforma = plataformaRepository.findByName(gamecenterDTO.getPlataforma());
		Optional<Jogo> jogo = jogoRepository.findByName(gamecenterDTO.getJogo());
		Optional<Usuario> usuario = usuarioRepository.findByLogin(gamecenterDTO.getUsuario());
		
		Gamecenter gamecenter = new Gamecenter(empresa.get(), genero.get(), plataforma.get(), jogo.get(), usuario.get());
		
		validarGamecenter(gamecenter);
		this.gamecenterRepository.saveAndFlush(gamecenter);
		gamecenterDTO.setId(gamecenter.getId());
	}

	private void validarGamecenter(Gamecenter gamecenter) {
		Optional<Gamecenter> gamecenterFound = gamecenterRepository.findByUser(gamecenter.getUsuario().getLogin());
		if (gamecenterFound.isPresent()) {
			throw new ServiceException("Dados já registrados");
		}
	}
	
	public Gamecenter findById(Integer id) {
		Optional<Gamecenter> gamecenterFound = gamecenterRepository.findById(id);
		if (gamecenterFound.isPresent()) {
			gamecenterFound.get();
		}
		throw new ServiceException("Dados não encontrados");
	}
	
	public Gamecenter findByCompany(Integer id) {
		Optional<Gamecenter> gamecenterFound = gamecenterRepository.findById(id);
		if (gamecenterFound.isPresent()) {
			gamecenterFound.get();
		}
		throw new ServiceException("Dados não encontrados");
	}
	
	public Gamecenter findByGender(String nome) {
		Optional<Gamecenter> gamecenterFound = gamecenterRepository.findByCompany(nome);
		if (gamecenterFound.isPresent()) {
			gamecenterFound.get();
		}
		throw new ServiceException("Dados não encontrados");
	}
	
	public Gamecenter findByPlatform(String nome) {
		Optional<Gamecenter> gamecenterFound = gamecenterRepository.findByPlatform(nome);
		if (gamecenterFound.isPresent()) {
			gamecenterFound.get();
		}
		throw new ServiceException("Dados não encontrados");
	}
	
	public Gamecenter findByGame(String nome) {
		Optional<Gamecenter> gamecenterFound = gamecenterRepository.findByGame(nome);
		if (gamecenterFound.isPresent()) {
			gamecenterFound.get();
		}
		throw new ServiceException("Dados não encontrados");
	}
	
	public Gamecenter findByUser(String login) {
		Optional<Gamecenter> gamecenterFound = gamecenterRepository.findByUser(login);
		if (gamecenterFound.isPresent()) {
			gamecenterFound.get();
		}
		throw new ServiceException("Dados não encontrados");
	}
	
	public void update(GamecenterDTO gamecenterDTO) {
		Integer id = gamecenterDTO.getId();
		Optional<Empresa> empresa = empresaRepository.findByName(gamecenterDTO.getEmpresa());
		Optional<Genero> genero = generoRepository.findByName(gamecenterDTO.getGenero());
		Optional<Plataforma> plataforma = plataformaRepository.findByName(gamecenterDTO.getPlataforma());
		Optional<Jogo> jogo = jogoRepository.findByName(gamecenterDTO.getJogo());
		Optional<Usuario> usuario = usuarioRepository.findByLogin(gamecenterDTO.getUsuario());
		
		Gamecenter gamecenter = new Gamecenter(id, empresa.get(), genero.get(), plataforma.get(), jogo.get(), usuario.get());
		this.gamecenterRepository.saveAndFlush(gamecenter);
	}
	
	public void delete(Integer id) {
		this.gamecenterRepository.deleteById(id);
	}
	
	public void deleteAll() {
		this.gamecenterRepository.deleteAll();
	}
	
	/*public List<GamecenterDTO> findAll() {
		List<GamecenterDTO> gamecenterReturn = new ArrayList<GamecenterDTO>();
		List<Gamecenter> gamecenters = this.gamecenterRepository.findAll();
		
		for(Gamecenter gamecenter : gamecenters) {
			GamecenterDTO gamecenterDTO = new GamecenterDTO();
			gamecenterDTO.setId(gamecenter.getId());
			gamecenterDTO.setEmpresa(empresaRepository.findByName(gamecenter.getEmpresa()));
			gamecenterDTO.setGenero(gamecenter.getGenero().getNome());
			gamecenterDTO.setJogo(gamecenter.getJogo());
			gamecenterDTO.setPlataforma(gamecenter.getPlataforma());
			gamecenterDTO.setUsuario(gamecenter.getUsuario());
			
			gamecenterReturn.add(gamecenterDTO);
		}
		return gamecenterReturn;
	}*/
}
