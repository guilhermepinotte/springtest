package com.dev.firstapi.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import java.util.List;

import lombok.Data;

@Entity
// @PrimaryKeyJoinColumn(name="id")
@Table(name = "alunos")
// @Data
public class Aluno extends Pessoa {
// public class Aluno {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private long matricula;
    
    // @Column(name = "id_pessoa")
    private long idPessoa;
    
    @Column(nullable = false, length = 50)
    private String situacao;


    //pesquisar tipo data no java
    // private String dataIngresso;

    // private Double cr;

    // @ManyToOne
    // @JoinColumn(name = "idCurso")
    // private Curso curso;

    // @ManyToMany
    // private List<Disciplina> disciplinas;
}
