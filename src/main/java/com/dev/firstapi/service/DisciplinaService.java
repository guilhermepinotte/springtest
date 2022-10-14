package com.dev.firstapi.service;

import com.dev.firstapi.domain.Disciplina;
import com.dev.firstapi.dto.DisciplinaDTO;

public interface DisciplinaService {
    Disciplina salvar (DisciplinaDTO dto);
}
