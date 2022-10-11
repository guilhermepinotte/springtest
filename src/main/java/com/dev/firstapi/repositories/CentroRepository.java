package com.dev.firstapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.firstapi.domain.Centro;

public interface CentroRepository extends JpaRepository <Centro, Long> {
    
}
