package com.dev.firstapi.domain;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

// @Entity
// @PrimaryKeyJoinColumn(name = "idServidor")
// @Table(name = "taes")
// @Data
public class Tae extends Servidor {
    
    // @ManyToOne
    // @JoinColumn(name = "idCentro")
    // private Centro centro;
}
