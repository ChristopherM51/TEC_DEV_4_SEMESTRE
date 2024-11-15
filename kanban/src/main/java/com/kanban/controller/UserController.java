package com.kanban.controller;

import com.kanban.model.Usuario;
import java.util.ArrayList;
import java.util.List;

public class UserController {
    private final List<Usuario> usuarios = new ArrayList<>();

    // Adiciona um novo usuário à lista
    public void addUsuario(Usuario usuario) {
        usuarios.add(usuario);
        System.out.println("Usuário adicionado: " + usuario.getNome());
    }

    // Obtém todos os usuários
    public List<Usuario> getUsuarios() {
        return new ArrayList<>(usuarios);
    }
}
