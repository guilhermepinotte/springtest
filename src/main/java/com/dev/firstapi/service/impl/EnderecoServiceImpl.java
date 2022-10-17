package com.dev.firstapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.dev.firstapi.domain.Endereco;
import com.dev.firstapi.dto.EnderecoDTO;
import com.dev.firstapi.repositories.EnderecoRepository;
import com.dev.firstapi.service.EnderecoService;

public class EnderecoServiceImpl implements EnderecoService{
    
    @Autowired
    private EnderecoRepository repository;

    @Override
    public Endereco salvar(EnderecoDTO dto) {
        Endereco endereco = new Endereco();
        endereco.setBairro(dto.getBairro());
        endereco.setCep(dto.getCep());
        endereco.setCidade(dto.getCidade());
        endereco.setComplemento(dto.getComplemento());
        endereco.setEstado(dto.getEstado());
        endereco.setNumero(dto.getNumero());
        endereco.setRua(dto.getRua());

        repository.save(endereco);
        return endereco;
    }

}
