package com.dev.firstapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DisciplinaDTO {
    private String nome;
    private Long idDocente;
    private Long idCurso;
}
