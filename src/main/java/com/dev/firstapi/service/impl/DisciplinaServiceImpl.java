package com.dev.firstapi.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.firstapi.domain.Curso;
import com.dev.firstapi.domain.Disciplina;
import com.dev.firstapi.domain.Docente;
import com.dev.firstapi.dto.DisciplinaDTO;
import com.dev.firstapi.exception.RegraNegocioException;
import com.dev.firstapi.repositories.CursoRepository;
import com.dev.firstapi.repositories.DisciplinaRepository;
import com.dev.firstapi.repositories.DocenteRepository;
import com.dev.firstapi.service.DisciplinaService;

@Service
public class DisciplinaServiceImpl implements DisciplinaService {
    
    @Autowired
    private DisciplinaRepository repository;
    @Autowired
    private CursoRepository cursoRepository;
    @Autowired
    private DocenteRepository docenteRespository;

    public DisciplinaServiceImpl (Disciplina disciplina) {

    }

    @Override
    @Transactional
    public Disciplina salvar(DisciplinaDTO dto) {
        
        Long idCurso = dto.getIdCurso();
        Curso curso = cursoRepository
                        .findById(idCurso)
                        .orElseThrow(() -> new RegraNegocioException("Código de Curso não existe"));


        Long idDocente = dto.getIdDocente();
        Docente docente = docenteRespository
                        .findById(idDocente)
                        .orElseThrow(() -> new RegraNegocioException("Código de Docente não existe"));

        Disciplina disciplina = new Disciplina();
        disciplina.setNome(dto.getNome());
        disciplina.setCurso(curso);
        disciplina.setDocente(docente);

        repository.save(disciplina);
        
        return null;
    }
}
