package com.gamecenter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gamecenter.domain.Gamecenter;

@Repository
public interface GamecenterRepository extends JpaRepository<Gamecenter, Integer>{

}
