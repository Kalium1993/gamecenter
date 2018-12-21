package com.gamecenter.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gamecenter.domain.Plataforma;

@Repository
public interface PlataformaRepository extends JpaRepository<Plataforma, Integer>{
	@Query("select p from Plataforma p where p.nome like %:nome% order by p.nome")
	public Optional<Plataforma> findByName(@Param("nome") String nome);
}
