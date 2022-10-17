package com.dev.firstapi.service;

import com.dev.firstapi.domain.Endereco;
import com.dev.firstapi.dto.EnderecoDTO;

public interface EnderecoService {
    Endereco salvar (EnderecoDTO dto);
}
