package com.dev.firstapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.firstapi.domain.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    
    // List<Aluno> findByNomeLike (String nome);
    //List<Aluno> findByNomeLikeOrIdOrderById (String  nome, Long id);

    //findBy -- retorna uma lista // ecessário ter nome da variável na classe

    Aluno findOneByMatricula (Long matricula);

    //boolean existisByNome (String nome);

}
