package com.dev.firstapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.*;

import com.dev.firstapi.domain.Docente;
import com.dev.firstapi.dto.DocenteDTO;
import com.dev.firstapi.service.DocenteService;

@RestController
@RequestMapping("/docentes")
public class DocenteController {
    
    private DocenteService service;

    public DocenteController (DocenteService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public long cadastrardDocente (@RequestBody DocenteDTO dto) {
        Docente docente = service.salvar(dto);
        return docente.getId();
    }
}
