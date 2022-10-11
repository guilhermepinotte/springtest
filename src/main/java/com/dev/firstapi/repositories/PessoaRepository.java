package com.dev.firstapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.firstapi.domain.Pessoa;

public interface PessoaRepository extends JpaRepository <Pessoa, Long>{
    
    // @Query(value = "select p from Pessoa p where p.nome like %:nome%")
    // List<Pessoa> encontrarPorNome (@Param("nome") String nome);
}
