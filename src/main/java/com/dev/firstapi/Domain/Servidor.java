package com.dev.firstapi.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "servidores")
public class Servidor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "siape")
    private Long siape;

    @ManyToOne
    @JoinColumn(name = "idPessoa")
    private Pessoa pessoa;
    
    @Column(name = "titulacao")
    private String titulacao;

    @Column(name = "funcao", columnDefinition = "varchar default 'sem função'")
    private String funcao;

}
