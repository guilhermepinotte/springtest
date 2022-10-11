package com.dev.firstapi.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dev.firstapi.domain.Curso;
import com.dev.firstapi.repositories.CursoRepository;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    // FAZER A IMPLETAÇÃO DESSA CLASSE
    @Autowired
    private CursoRepository repository;

    // @Autowired
    // private CentroRepository centroRepository;
    
    @GetMapping
    public List<Curso> retornaTodosCursos(){
        return this.repository.findAll();
    }

    // @GetMapping(value = "/{id}")
    // public ResponseEntity<Curso> retornaCursoPorId (@PathVariable Long id){
    //     Optional<Curso> curso = this.repository.findById(id);
    //     if (curso.isPresent()) {
    //         return ResponseEntity.ok(curso.get());
    //     }
    //     return ResponseEntity.notFound().build();
    // }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Curso salvarCurso (@RequestBody @Valid Curso curso) {
              
        if (Curso.naoExiste(repository.findOneByCodigo(curso.getCodigo()))) {
            repository.save(curso);
            System.out.println("CURSO NÃO EXISTE");
            return curso;
        }
        return curso;
    }


}
