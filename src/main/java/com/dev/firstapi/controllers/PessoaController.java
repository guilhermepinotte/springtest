package com.dev.firstapi.controllers;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.firstapi.domain.Pessoa;
import com.dev.firstapi.repositories.PessoaRepository;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {
    @Autowired
    private PessoaRepository repository;

    @GetMapping
    public List<Pessoa> findAll () {
        List<Pessoa> pessoas = this.repository.findAll();
        for (Pessoa pessoa : pessoas) {
            // System.out.println(pessoa.getEndereco());
            Hibernate.unproxy(pessoa.getEndereco());
        }
        return pessoas;
    }

    @GetMapping(value = "/{id}")
    public Pessoa findById (@PathVariable long id){
        return this.repository.findById(id).get();
    }

    @PostMapping
    public Pessoa insert (@RequestBody Pessoa pessoa) {    
        System.out.println(pessoa);
        return this.repository.save(pessoa);
    }
}
