package com.daza.m5_evalucion_final.dto;

import com.daza.m5_evalucion_final.model.Usuario;

public class UsuarioMapper {

    public static UsuarioDTO convertirDTO(Usuario usuario) {
        return new UsuarioDTO(
                usuario.getId(),
                usuario.getNombre(),
                usuario.getUsername(),
                usuario.getEmail(),
                usuario.getFechaNacimiento(),
                usuario.getPassword(),
                usuario.getHoroscopoAnimal()
        );
    }
    public static Usuario toEntity(UsuarioCreateDTO dto) {
        return new Usuario(dto.getNombre(), dto.getUsername(), dto.getEmail(), dto.getFechaNacimiento(), dto.getPassword(), dto.getHoroscopoAnimal());
    }

    public static Usuario toEntity(UsuarioUpdateDTO dto) {
        return new Usuario(dto.getId(), dto.getNombre(), dto.getUsername(), dto.getEmail(), dto.getFechaNacimiento(), dto.getPassword(), dto.getHoroscopoAnimal());
    }
}
