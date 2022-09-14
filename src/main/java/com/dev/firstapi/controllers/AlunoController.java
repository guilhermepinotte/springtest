package com.dev.firstapi.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.dev.firstapi.domain.Aluno;
import com.dev.firstapi.repositories.AlunoRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
}
