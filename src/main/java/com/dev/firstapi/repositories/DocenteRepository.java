package com.dev.firstapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.firstapi.domain.Docente;

public interface DocenteRepository extends JpaRepository <Docente, Long> {
    
}
