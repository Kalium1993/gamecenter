package com.gamecenter.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gamecenter.domain.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	@Query("select u from Usuario u where u.login = :login")
	Optional<Usuario> findByLogin(@Param("login") String login);
	
	@Query("select u from Usuario u where u.nickname = :nickname")
	Optional<Usuario> findByNickname(@Param("nickname") String nickname);
}
