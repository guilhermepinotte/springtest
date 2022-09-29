package com.dev.firstapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dev.firstapi.domain.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    
    // List<Aluno> findByNomeLike (String nome);
    //List<Aluno> findByNomeLikeOrIdOrderById (String  nome, Long id);

    //findBy -- retorna uma lista // ecessário ter nome da variável na classe

    @Query(value = "select a from Aluno a where a.pessoa.nome like %:nome%")
    List<Aluno> encontrarPorNome (@Param("nome") String nome);
    
    Aluno findOneByMatricula (Long matricula);

    //boolean existisByNome (String nome);

}
