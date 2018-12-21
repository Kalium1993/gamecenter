package com.gamecenter.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gamecenter.domain.Jogo;

@Repository
public interface JogoRepository extends JpaRepository<Jogo, Integer>{
	@Query("select j from Jogo j where j.nome like %:nome% order by j.nome")
	public Optional<Jogo> findByName(@Param("nome") String nome);
}
