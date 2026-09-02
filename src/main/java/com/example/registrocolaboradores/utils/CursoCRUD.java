package com.example.registrocolaboradores.utils;

import com.example.registrocolaboradores.models.Curso;

import java.util.List;

public class CursoCRUD implements CRUD<Curso> {
    List<Curso> cursos;

    @Override
    public void agregar(Curso curso) {
        cursos.add(curso);
    }

    @Override
    public List<Curso> obtenerRegistros() {
        return cursos;
    }
}
