package com.dev.firstapi.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.dev.firstapi.domain.Aluno;
import com.dev.firstapi.repositories.AlunoRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
    
    @Autowired
    private AlunoRepository repository;

    @GetMapping
    public List<Aluno> findAll () {
        return this.repository.findAll();
    }

    @GetMapping(value = "/{id}")
    public Aluno findById (@PathVariable long id) {
        return this.repository.findById(id).get();
    }

    @PostMapping
    public Aluno insert (@RequestBody Aluno aluno) {
        return this.repository.save(aluno);
    }
}
