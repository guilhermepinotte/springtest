package com.dev.firstapi.domain;

import javax.persistence.CascadeType;
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

import java.time.LocalDate;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
// @PrimaryKeyJoinColumn(name="id")
@Table(name = "alunos")
@Data
// @EqualsAndHashCode(callSuper = true)
public class Aluno  {
// public class Aluno {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long matricula;
    
    // @Column(name = "idPessoa")
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idPessoa")
    private Pessoa pessoa;
    
    @Column(nullable = false, length = 50)
    private String situacao;


    @Column(name = "dataIngresso")
    private LocalDate dataIngresso;

    @Column(name = "cr", precision = 2, columnDefinition = "double default '10.00'")
    private Double cr;

    @ManyToOne
    @JoinColumn(name = "idCurso")
    private Curso curso;

    // @ManyToMany
    // private List<Disciplina> disciplinas;
}
