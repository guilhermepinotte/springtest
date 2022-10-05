package com.dev.firstapi.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

import lombok.Data;

@Entity
@Table(name = "alunos")
@Data
// @EqualsAndHashCode(callSuper = true)

public class Aluno {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "matricula")
    @NotNull
    private Long matricula;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idPessoa")
    private Pessoa pessoa;
    
    @Column(nullable = false, length = 50)
    private String situacao;

    @Column(name = "dataIngresso")
    private LocalDate dataIngresso;

    @Column(name = "cr", precision = 20, scale = 2, columnDefinition = "double default '10.00'")
    private Double cr;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idCurso")
    private Curso curso;

    // @OneToMany(mappedBy = "aluno")
    // private List<AlunoPorDisciplina> disciplinasMatriculadas;

}
