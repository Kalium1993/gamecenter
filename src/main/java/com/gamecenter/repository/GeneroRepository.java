package com.gamecenter.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gamecenter.domain.Genero;

@Repository
public interface GeneroRepository extends JpaRepository<Genero, Integer>{
	@Query("select g from Genero g where g.nome like %:nome% order by g.nome")
	public Optional<Genero> findByName(@Param("nome") String nome);
}
