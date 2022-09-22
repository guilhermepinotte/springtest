package com.dev.firstapi.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;

import lombok.Data;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "pessoas")
@Data
public class Pessoa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)   
    private String nome;
    @Column(nullable = false, length = 100)
    private String email;
    @Column(length = 11)
    private String cpf;
    @Column(name = "dataNascimento")
    private LocalDate dataNascimento;
    @Column(name = "dataCadastro", columnDefinition = "TIMESTAMP")
    private LocalDateTime dataCadastro = LocalDateTime.now();
    
    @OneToOne(cascade = CascadeType.ALL) 
    // @OneToOne
    // @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="idEndereco", referencedColumnName = "id")
    private Endereco endereco;
}
