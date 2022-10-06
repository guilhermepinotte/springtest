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

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.util.List;

import lombok.Data;

@Entity
@Table(name = "alunos")
@Data
public class Aluno {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "matricula")
    // @NotNull
    private Long matricula;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idPessoa")
    private Pessoa pessoa;
    
    @Column(nullable = false, length = 50)
    private String situacao;

    @Column(name = "dataIngresso")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataIngresso;

    @Column(name = "cr", precision = 20, scale = 2, columnDefinition = "double default '10.00'")
    private Double cr = 10.00;

    @ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH})
    // @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idCurso")
    // @OnDelete(action = OnDeleteAction.NO_ACTION)
    private Curso curso;

    // @OneToMany(mappedBy = "aluno")
    // private List<AlunoPorDisciplina> disciplinasMatriculadas;

}
