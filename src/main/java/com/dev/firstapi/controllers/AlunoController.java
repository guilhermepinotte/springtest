package com.dev.firstapi.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.dev.firstapi.domain.Aluno;
import com.dev.firstapi.domain.Curso;
import com.dev.firstapi.repositories.AlunoRepository;
import com.dev.firstapi.repositories.CursoRepository;

import java.net.http.HttpRequest;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
    
    @Autowired
    private AlunoRepository repository;

    @Autowired
    private CursoRepository cursoRepository;

    @GetMapping
    public List<Aluno> findAll () {
        return this.repository.findAll();
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public ResponseEntity<Aluno> findById (@PathVariable Long id) {
        Optional<Aluno> aluno = this.repository.findById(id);
        if (aluno.isPresent()) {
            return ResponseEntity.ok(aluno.get());
        }
        return ResponseEntity.notFound().build();
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

    // @GetMapping(value = "/{nome}")
    // public List<Aluno> findByNomeLike (@PathVariable String nome) {
    //     Aluno aluno = this.repository.fin
    //     return this.repository.findByNomeLike(nome);
    // }

    @PostMapping
    @ResponseBody
    public ResponseEntity salvarAluno (@RequestBody @Valid Aluno aluno) {
        
        Optional<Curso> curso =  this.cursoRepository.findById(aluno.getCurso().getId());
        if (!curso.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        aluno.setCurso(curso.get());
        
        return ResponseEntity.ok(this.repository.save(aluno));
    }

    @DeleteMapping(value = "/{id}")
    @ResponseBody
    public ResponseEntity deletarAluno (@PathVariable Long id) {
        Optional<Aluno> aluno = this.repository.findById(id);
        
        if (aluno.isPresent()) {
            this.repository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping(value = "/{id}")
    @ResponseBody
    public ResponseEntity atualizarAluno (@PathVariable Long id, @RequestBody Aluno aluno) {
        Optional<Aluno> alunoExistente = this.repository.findById(id);
        
        if (alunoExistente.isPresent()) {
            alunoExistente.map( alunoE -> {
               aluno.setId(alunoE.getId());
               return ResponseEntity.ok(this.repository.save(aluno)); 
            } );
            // aluno.setId(id);
            
            // this.repository.save(aluno);
            // return ResponseEntity.ok(this.repository.save(aluno));
        }
        return ResponseEntity.notFound().build();
    }
}
