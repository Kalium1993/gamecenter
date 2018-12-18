package com.gamecenter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gamecenter.domain.Plataforma;

@Repository
public interface PlataformaRepository extends JpaRepository<Plataforma, Integer>{

}
