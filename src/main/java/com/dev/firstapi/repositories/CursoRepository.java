package com.dev.firstapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.firstapi.domain.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long>{
    
}
