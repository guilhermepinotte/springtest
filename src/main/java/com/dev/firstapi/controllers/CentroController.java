package com.dev.firstapi.controllers;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import com.dev.firstapi.repositories.CentroRepository;


@RestController
@RequestMapping("/centros")
public class CentroController {
    
    @Autowired
    private CentroRepository repository;

    @GetMapping
    public List<Centro> retornaTodosCentros () {
        return repository.findAll();
    } 

    @GetMapping("{id}")
    public Centro retornaCentroPorId (@PathVariable Long id) {
        return repository
                .findById(id)
                .orElseThrow( () -> 
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Centro não encontrado"));       
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Centro salvaCentro (@RequestBody Centro centro) {
        return repository.save(centro);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletaCentro (@PathVariable Long id) {
        repository
            .findById(id)
            .map(centro -> {
                repository.delete(centro);
                return centro;
            })
            .orElseThrow( () -> 
                            new ResponseStatusException(HttpStatus.NOT_FOUND, "Centro não encontrado"));
    }

    // NÃO ESTÁ FUNCIONANDO
    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizaCentro (@RequestBody Centro centro, @PathVariable Long id) {
        repository
            .findById(id)
            .map(centroExistente -> {
                repository.save(centroExistente);
                return centroExistente;
            })
            .orElseThrow( () -> 
                            new ResponseStatusException(HttpStatus.NOT_FOUND, "Centro não encontrado"));
    }

}
