package com.dev.firstapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.firstapi.domain.Disciplina;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Long>{
    
}
