package com.dev.firstapi.Domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "alunos")
public class Aluno {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter 
    private long id;
    
    @Getter @Setter private String nome;
    @Getter @Setter private String email;

    @ManyToOne
    @JoinColumn(name = "idCurso")
    @Getter @Setter private Curso curso;

    public Aluno() {
        
    }
    
}
