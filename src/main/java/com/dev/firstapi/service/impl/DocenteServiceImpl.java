package com.dev.firstapi.service.impl;

import java.time.LocalDateTime;

import javax.print.Doc;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.firstapi.domain.Centro;
import com.dev.firstapi.domain.Docente;
import com.dev.firstapi.domain.Endereco;
import com.dev.firstapi.domain.Pessoa;
import com.dev.firstapi.domain.Servidor;
import com.dev.firstapi.dto.DocenteDTO;
import com.dev.firstapi.repositories.CentroRepository;
import com.dev.firstapi.repositories.DocenteRepository;
import com.dev.firstapi.service.DocenteService;

@Service
public class DocenteServiceImpl implements DocenteService {
    
    @Autowired
    private DocenteRepository repository;
    @Autowired
    private CentroRepository centroRepository;

    @Override
    @Transactional
    public Docente salvar(DocenteDTO dto) {
        Long idCentro = dto.getIdCentro(); 
        Centro centro = centroRepository
                            .findById(idCentro)
                            .orElseThrow(() -> new RegraNegocioException("Centro não existe"))
        
        Endereco endereco = new Endereco();
        endereco.setBairro(dto.getServidor().getPessoa().getEndereco().getBairro());
        endereco.setCep(dto.getServidor().getPessoa().getEndereco().getCep());
        endereco.setCidade(dto.getServidor().getPessoa().getEndereco().getCidade());
        endereco.setComplemento(dto.getServidor().getPessoa().getEndereco().getComplemento());
        endereco.setEstado(dto.getServidor().getPessoa().getEndereco().getEstado());
        endereco.setNumero(dto.getServidor().getPessoa().getEndereco().getNumero());
        endereco.setRua(dto.getServidor().getPessoa().getEndereco().getRua());

        Pessoa pessoa = new Pessoa();
        pessoa.setEndereco(endereco);
        pessoa.setCpf(dto.getServidor().getPessoa().getCpf());
        pessoa.setDataCadastro(LocalDateTime.now());
        pessoa.setDataNascimento(dto.getServidor().getPessoa().getDataNascimento());
        pessoa.setEmail(dto.getServidor().getPessoa().getEmail());
        pessoa.setNome(dto.getServidor().getPessoa().getNome());

        Servidor servidor = new Servidor();
        servidor.setPessoa(pessoa);
        servidor.setFuncao(dto.getServidor().getFuncao());
        servidor.setSiape(dto.getServidor().getSiape());
        servidor.setTitulacao(dto.getServidor().getTitulacao());

        Docente docente = new Docente();
        docente.setServidor(servidor);
        docente.setCentro(centro);

        repository.save(docente);        

        return null;
    }
}
