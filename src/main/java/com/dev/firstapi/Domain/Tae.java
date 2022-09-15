package com.dev.firstapi.domain;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Tae extends Servidor {
    
    @ManyToOne
    @JoinColumn(name = "idDepartamento")
    private Departamento departamento;
}
