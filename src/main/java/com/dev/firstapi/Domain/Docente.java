package com.dev.firstapi.domain;

import java.util.List;

import javax.persistence.CascadeType;
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
@Table(name = "docentes")
@Data
public class Docente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idServidor")
    private Servidor servidor;

    @ManyToOne
    @JoinColumn(name = "idCentro")
    private Centro centro;

    @OneToMany(mappedBy = "docente")
    private List<Disciplina> disciplinas;
    
}
