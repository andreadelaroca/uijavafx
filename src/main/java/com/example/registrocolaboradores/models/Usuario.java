package com.example.registrocolaboradores.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data @AllArgsConstructor @NoArgsConstructor
public class Usuario {
    String nombres;
    String apellidos;
    String usuario;
    String password;
    LocalDate fechaNac;
    String departamento;
    Boolean aceptarNorma;
}
