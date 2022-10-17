package com.dev.firstapi.dto;

import com.dev.firstapi.domain.Endereco;
import com.dev.firstapi.domain.Pessoa;
import com.dev.firstapi.domain.Servidor;

import lombok.Data;

@Data
public class DocenteDTO {
    private ServidorDTO servidor;
    private Long idCentro;
}
