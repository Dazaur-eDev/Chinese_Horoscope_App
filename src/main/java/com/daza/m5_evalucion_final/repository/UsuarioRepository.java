package com.daza.m5_evalucion_final.repository;

import com.daza.m5_evalucion_final.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository {
    List<Usuario> listarUsuarios();
    void insertarUsuario(Usuario usuario);
    Optional<Usuario> buscarUsuario(String username);
    Optional<Usuario> buscarUsuarioId(int id);
    void actualizarUsuario(Usuario usuario);
    void eliminarUsuario(int id);
}
