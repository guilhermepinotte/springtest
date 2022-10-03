package com.dev.firstapi.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Data;

@Entity
// @PrimaryKeyJoinColumn(name = "idPessoa")
@Table(name = "servidores")
@Data
public class Servidor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long siape;
    
    @Column(name = "titulacao")
    private String titulacao;

    @Column(name = "funcao")
    private String funcao;

}
