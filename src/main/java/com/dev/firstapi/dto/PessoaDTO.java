package com.dev.firstapi.dto;

import java.time.LocalDate;

import net.bytebuddy.asm.Advice.Local;

public class PessoaDTO {
    private Long idEndereco;

    private String cpf;
    private LocalDate dataCadastro;
    private LocalDate dataNascimento;
    private String email;
    private String nome;
}
