package com.gamecenter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gamecenter.domain.GameCenter;

@Repository
public interface GameCenterRepository extends JpaRepository<GameCenter, Integer>{

}
