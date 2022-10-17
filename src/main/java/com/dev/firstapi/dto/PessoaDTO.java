package com.dev.firstapi.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class PessoaDTO {
    private EnderecoDTO endereco;

    private String cpf;
    private LocalDate dataCadastro;
    private LocalDate dataNascimento;
    private String email;
    private String nome;
}
