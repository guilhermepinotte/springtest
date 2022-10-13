package com.dev.firstapi.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.dev.firstapi.domain.Centro;
import com.dev.firstapi.domain.Curso;
import com.dev.firstapi.repositories.CentroRepository;
import com.dev.firstapi.repositories.CursoRepository;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    // FAZER A IMPLETAÇÃO DESSA CLASSE
    @Autowired
    private CursoRepository repository;

    @Autowired
    private CentroRepository centroRepository;
    
    @GetMapping
    public List<Curso> retornaTodosCursos(){
        return this.repository.findAll();
    }

    @GetMapping(value = "{id}")
    public Curso retornarCursoPorId (@PathVariable Long id){
         return repository
                    .findById(id)
                    .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Curso não encontrado"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Curso salvarCurso (@RequestBody @Valid Curso curso) {
              
        if (Curso.naoExiste(repository.findOneByCodigo(curso.getCodigo()))) {
            Centro centro = centroRepository
                                .findById(curso.getCentro().getId())
                                .orElseThrow( () -> 
                                    new ResponseStatusException(HttpStatus.NOT_FOUND, "Não é possível cadastrar Curso sem Centro"));
            curso.setCentro(centro);

            repository.save(curso);
            return curso;
        } 
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Curso já existe");
        }
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarCurso (@PathVariable Long id) {
        repository
            .findById(id)
            .map((curso) -> {
                repository.delete(curso);
                return curso;
            })
            .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Curso não existe"));
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarCurso (@PathVariable Long id, @RequestBody Curso curso) {
        repository
            .findById(id)
            .map((cursoExistente) -> {
                curso.setId(cursoExistente.getId());
                // curso.setCodigo(cursoExistente.getCodigo());
                // curso.setNome(cursoExistente.getNome());
                // curso.setCentro(cursoExistente.getCentro());
                repository.save(curso);
                return cursoExistente;
            })
            .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Curso não existe"));
    }
}
