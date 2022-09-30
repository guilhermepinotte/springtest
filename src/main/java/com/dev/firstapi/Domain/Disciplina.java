package com.dev.firstapi.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import lombok.Data;

@Entity
@Table(name = "disciplinas")
@Data
public class Disciplina {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @ManyToOne
    @JoinColumn(name = "idDocente")
    private Docente docente;

    @ManyToOne
    @JoinColumn(name = "idCurso")
    private Curso curso;

    // @ManyToMany
    // @JoinTable(
    //     name = "disciplinas_aluno",
    //     joinColumns = @JoinColumn(name = "idDisciplina"),
    //     inverseJoinColumns = @JoinColumn(name = "idAluno")
    // )
    private List<Aluno> alunosMatriculados;
}
