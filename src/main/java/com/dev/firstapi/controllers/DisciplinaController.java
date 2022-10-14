package com.dev.firstapi.controllers;

import static org.springframework.http.HttpStatus.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dev.firstapi.domain.Disciplina;
import com.dev.firstapi.dto.DisciplinaDTO;
import com.dev.firstapi.service.DisciplinaService;

@RestController
@RequestMapping("/disciplinas")
public class DisciplinaController {
    
    private DisciplinaService service;

    public DisciplinaController(DisciplinaService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Long cadastrarDisciplina (@RequestBody DisciplinaDTO dto) {
        Disciplina disciplina = service.salvar(dto);
        return disciplina.getId();
    }
}
