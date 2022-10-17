package com.dev.firstapi.dto;

import lombok.Data;

@Data
public class EnderecoDTO {
    private String bairro;
    private String cep;
    private String cidade;
    private String complemento;
    private String estado;
    private String numero;
    private String rua;
}
