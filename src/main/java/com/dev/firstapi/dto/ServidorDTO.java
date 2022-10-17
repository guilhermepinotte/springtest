package com.dev.firstapi.dto;

import lombok.Data;

@Data
public class ServidorDTO {
    private PessoaDTO pessoa;
    private String funcao;
    private String siape;
    private String titulacao;
}
