package com.dev.firstapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.firstapi.domain.Endereco;

public interface EnderecoRepository extends JpaRepository <Endereco, Long >{
    
}
