package com.dev.firstapi.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "enderecos")
@Data
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 45) 
    private String cep;
    @Column(length = 45) 
    private String rua;
    @Column(length = 45) 
    private String numero;
    @Column(length = 45) 
    private String complemento;
    @Column(length = 45) 
    private String bairro;
    @Column(length = 45) 
    private String cidade;
    @Column(length = 45) 
    private String estado;
}
