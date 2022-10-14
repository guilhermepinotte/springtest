package com.dev.firstapi.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "centros")
public class Centro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    // @ManyToOne
    // @JoinColumn(name = "idCampus")
    // private Campus campus;

    // @OneToMany(mappedBy = "centro")
    // private List<Curso> cursos;

    // @OneToMany(mappedBy = "centro")
    // private List<Docente> docentes;

    // @OneToMany(mappedBy = "centro")
    // private List<Tae> taes;
}
