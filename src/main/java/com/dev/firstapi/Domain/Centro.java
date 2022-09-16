package com.dev.firstapi.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "centros")
@Data
public class Centro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @ManyToOne
    @JoinColumn(name = "idCampus")
    private Campus campus;

    @OneToMany(mappedBy = "centros")
    private List<Curso> cursos;

    @OneToMany(mappedBy = "centros")
    private List<Docente> docentes;

    @OneToMany(mappedBy = "centros")
    private List<Tae> taes;
}
