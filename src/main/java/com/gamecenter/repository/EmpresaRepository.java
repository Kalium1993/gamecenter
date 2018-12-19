package com.gamecenter.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gamecenter.domain.Empresa;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Integer>{
	@Query("select e from Empresa e where e.nome like %:nome% order by e.nome")
	public Optional<Empresa> findByName(@Param("nome") String nome);
}
//usar classes e atributos do java (tabela tem qe ter nome exatamente igual da classe)
