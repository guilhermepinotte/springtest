package com.dev.firstapi.domain;

import java.util.List;

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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cursos")
public class Curso {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "idCentro")
    private Centro centro;

    @Column(name = "codigo")
    private Long codigo;

    // @OneToMany(mappedBy = "curso")
    // private List<Aluno> alunos;

    // @OneToMany(mappedBy = "curso")
    // private List<Disciplina> disciplinas;

    @Column(name = "nome")
    private String nome;


    public static boolean naoExiste (Curso curso) {
        return curso == null;
    }
}
