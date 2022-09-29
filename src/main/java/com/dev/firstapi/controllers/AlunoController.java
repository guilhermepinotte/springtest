package com.dev.firstapi.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.dev.firstapi.domain.Aluno;
import com.dev.firstapi.repositories.AlunoRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
    public Aluno findById (@PathVariable Long id) {
        return this.repository.findById(id).get();
    }

    @GetMapping(value = "matr/{matricula}")
    public Aluno findOneByMatricula (@PathVariable Long matricula) {
        return this.repository.findOneByMatricula(matricula);
    }

    @GetMapping(value = "nome/{n}")
    public List<Aluno> encontrarAlunoPorNome (@PathVariable String n) {
        return this.repository.encontrarPorNome(n);
    }

    // @DeleteMapping(value = "delete/{id}")
    // public ResponseEntity<Long> deleteAluno (@PathVariable Long id) {
    //     var isRemoved = this.repository.delete(this.repository.findById(id).get());
    //     if (!isRemoved) {
    //         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    //     }
    //     return new ResponseEntity<>(id, HttpStatus.OK);
    // } 

    @DeleteMapping(value = "/delete/{id}")
    public void deleteAluno (@PathVariable Long id) {
        
        this.repository.deleteById(id);
        
    } 

    // @GetMapping(value = "/{nome}")
    // public List<Aluno> findByNomeLike (@PathVariable String nome) {
    //     Aluno aluno = this.repository.fin
    //     return this.repository.findByNomeLike(nome);
    // }

    @PostMapping
    public Aluno insert (@RequestBody Aluno aluno) {
        return this.repository.save(aluno);
    }

    @DeleteMapping(value = "/{id}")
    public void delete (@PathVariable Long id) {

    }
}
