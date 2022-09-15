package com.dev.firstapi.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "alunos")
@Data
public class Aluno extends Pessoa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long matricula;
    
    private String email;

    @ManyToOne
    @JoinColumn(name = "id_curso")
    private Curso curso;

    // @ManyToMany
    // private DisciplinasMatriculadas matriculadas;
}
