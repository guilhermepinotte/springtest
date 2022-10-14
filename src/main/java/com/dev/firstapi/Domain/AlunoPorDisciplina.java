package com.dev.firstapi.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "alunosMatriculados")
public class AlunoPorDisciplina {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idDisciplina")
    private Disciplina disciplina;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idAluno")
    private Aluno aluno;

    @Column(name = "nota", precision = 2, columnDefinition = "double default '0.00'")
    private Double nota;

    @Column(name = "status")
    private String status;

}
