package com.gamecenter.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gamecenter.domain.Gamecenter;

@Repository
public interface GamecenterRepository extends JpaRepository<Gamecenter, Integer>{
	@Query("select gc from Gamecenter gc where gc.empresa.nome = :nome")
	Optional<Gamecenter> findByCompany(@Param("nome") String nome);
	
	@Query("select gc from Gamecenter gc where gc.genero.nome = :nome")
	Optional<Gamecenter> findByGender(@Param("nome") String nome);
	
	@Query("select gc from Gamecenter gc where gc.plataforma.nome = :nome")
	Optional<Gamecenter> findByPlatform(@Param("nome") String nome);
	
	@Query("select gc from Gamecenter gc where gc.jogo.nome = :nome")
	Optional<Gamecenter> findByGame(@Param("nome") String nome);
	
	@Query("select gc from Gamecenter gc where gc.usuario.nome = :nome")
	Optional<Gamecenter> findByUser(@Param("nome") String nome);
}
