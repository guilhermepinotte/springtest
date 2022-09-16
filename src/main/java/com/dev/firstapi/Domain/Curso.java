package com.dev.firstapi.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "cursos")
@Data
public class Curso {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    private String nome;

    @OneToMany(mappedBy = "cursos")
    private List<Aluno> alunos;

    @OneToMany(mappedBy = "cursos")
    private List<Disciplina> disciplinas;
}
