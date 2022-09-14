package com.dev.firstapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.firstapi.domain.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    
}
