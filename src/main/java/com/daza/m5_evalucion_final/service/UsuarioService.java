package com.daza.m5_evalucion_final.service;

import com.daza.m5_evalucion_final.dto.UsuarioCreateDTO;
import com.daza.m5_evalucion_final.dto.UsuarioDTO;
import com.daza.m5_evalucion_final.dto.UsuarioUpdateDTO;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    List<UsuarioDTO> listarUsuarios();
    Optional<UsuarioDTO> buscarUsuario(String username);
    Optional<UsuarioDTO> buscarUsuarioId(int id);
    void crearUsuario(UsuarioCreateDTO usuarioCreateDTO);
    void actualizarUsuario(UsuarioUpdateDTO usuarioUpdateDTO);
    void actualizarUsuarioId(UsuarioUpdateDTO usuarioUpdateDTO);
    void eliminarUsuario(int id);
}
