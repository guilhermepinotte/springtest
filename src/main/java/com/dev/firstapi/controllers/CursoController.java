package com.dev.firstapi.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dev.firstapi.domain.Curso;
import com.dev.firstapi.repositories.CursoRepository;

@RestController
@RequestMapping(name = "/cursos")
public class CursoController {

    @Autowired
    private CursoRepository repository;
    
    @GetMapping
    @ResponseBody
    public List<Curso> retornaTodosCursos(){
        return this.repository.findAll();
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public ResponseEntity<Curso> retornaCursoPorId (@PathVariable Long id){
        Optional<Curso> curso = this.repository.findById(id);
        if (curso.isPresent()) {
            return ResponseEntity.ok(curso.get());
        }
        return ResponseEntity.notFound().build();
    }
}
