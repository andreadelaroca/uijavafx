package com.example.registrocolaboradores.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data @AllArgsConstructor @NoArgsConstructor
public class Matricula {
    private String nombres;
    private String apellidos;
    private String departamento;
    private String curso;
    private String modalidad;
    private String horario;
    private String fechaNacimiento;
}