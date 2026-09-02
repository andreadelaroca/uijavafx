package com.example.registrocolaboradores.utils;

import com.example.registrocolaboradores.models.Usuario;

import java.util.List;

public class UsuarioCRUD implements CRUD<Usuario> {
    List<Usuario> usuarios;

    @Override
    public void agregar(Usuario usuario) {
        usuarios.add(usuario);
    }

    @Override
    public List<Usuario> obtenerRegistros() {
        return usuarios;
    }
}