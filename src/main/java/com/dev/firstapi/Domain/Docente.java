package com.dev.firstapi.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Data;

@Entity
// @PrimaryKeyJoinColumn(name = "idServidor")
@Table(name = "docentes")
// @Data
public class Docente extends Servidor {
    
    @ManyToOne
    @JoinColumn(name = "idCentro")
    private Centro centro;

    @OneToMany(mappedBy = "docente")
    private List<Disciplina> disciplinas;
    
}
