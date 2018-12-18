package com.gamecenter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gamecenter.domain.Genero;

@Repository
public interface GeneroRepository extends JpaRepository<Genero, Integer>{

}
