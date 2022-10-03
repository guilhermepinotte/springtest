package com.dev.firstapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dev.firstapi.domain.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa,Long >{
    
    // @Query(value = "select p from Pessoa p where p.nome like %:nome%")
    // List<Pessoa> encontrarPorNome (@Param("nome") String nome);
}
