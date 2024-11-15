package com.kanban.controller;

import com.kanban.model.Usuario;
import com.kanban.repository.UsuarioRepository;

import java.util.List;

public class UserController {
    private final UsuarioRepository usuarioRepository = new UsuarioRepository();

    // Adiciona um novo usuário
    public void addUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    // Obtém todos os usuários
    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }
}
