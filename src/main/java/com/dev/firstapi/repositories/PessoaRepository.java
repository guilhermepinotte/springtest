package com.dev.firstapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.firstapi.domain.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa,Long >{
    
}
