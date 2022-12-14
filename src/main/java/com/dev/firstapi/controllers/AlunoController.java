package com.dev.firstapi.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.dev.firstapi.domain.Aluno;
import com.dev.firstapi.domain.Curso;
import com.dev.firstapi.repositories.AlunoRepository;
import com.dev.firstapi.repositories.CursoRepository;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.*;
@RestController
@RequestMapping("/alunos")
public class AlunoController {
    
    @Autowired
    private AlunoRepository repository;

    @Autowired
    private CursoRepository cursoRepository;

    @GetMapping(value = "{id}")
    public Aluno encontrarAlunoPorId (@PathVariable Long id) {
        return repository
                .findById(id)
                .orElseThrow( () -> new ResponseStatusException(NOT_FOUND, "Aluno não encontrado"));
    }

    // @GetMapping(value = "matr/{matricula}")
    // public Aluno findOneByMatricula (@PathVariable Long matricula) {
    //     return this.repository.findOneByMatricula(matricula);
    // }

    // @GetMapping(value = "nome/{n}")
    // public List<Aluno> encontrarAlunoPorNome (@PathVariable String n) {
    //     return this.repository.encontrarPorNome(n);
    // }

    @GetMapping
    public List<Aluno> pesquisarAlunos (Aluno filtro) {
        ExampleMatcher matcher = ExampleMatcher
                                    .matching()
                                    .withIgnoreCase()
                                    .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        
        Example example = Example.of(filtro, matcher);
        return this.repository.findAll(example);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Aluno salvarAluno (@RequestBody @Valid Aluno aluno) {
        // Optional<Curso> curso =  this.cursoRepository.findById(aluno.getCurso().getId());
        // if (!curso.isPresent()) {
        //     return ResponseEntity.notFound().build();
        // }

        Curso curso = this.cursoRepository
                            .findById(aluno.getCurso().getId())
                            .orElseThrow( () -> new ResponseStatusException(NOT_FOUND, "Não é possível cadastrar aluno sem Curso"));

        aluno.setCurso(curso);
        
        return this.repository.save(aluno);
    }

    @DeleteMapping(value = "{id}")
    @ResponseStatus(NO_CONTENT)
    public void deletarAluno (@PathVariable Long id) {
        repository
            .findById(id)
            .map( aluno -> {
                repository.delete(aluno);
                return aluno;
            })
            .orElseThrow( () -> new ResponseStatusException(NOT_FOUND, "Aluno não enontrado"));
    }

    @PutMapping(value = "{id}")
    @ResponseStatus(NO_CONTENT)
    public void atualizarAluno (@PathVariable Long id, @RequestBody Aluno aluno) {
        repository
            .findById(id)
            .map(alunoExistente -> {
                aluno.setId(alunoExistente.getId());
                repository.save(aluno);
                return alunoExistente;
            }).orElseThrow( () -> new ResponseStatusException(NOT_FOUND, "Aluno não enontrado"));
    }
}
