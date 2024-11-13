package com.daza.m5_evalucion_final.service;

import com.daza.m5_evalucion_final.dto.*;
import com.daza.m5_evalucion_final.model.Usuario;
import com.daza.m5_evalucion_final.repository.HoroscopoRepository;
import com.daza.m5_evalucion_final.repository.HoroscopoRepositoryImpl;
import com.daza.m5_evalucion_final.repository.UsuarioRepository;
import com.daza.m5_evalucion_final.repository.UsuarioRepositoryImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final HoroscopoRepository horoscopoRepository;

    public UsuarioServiceImpl() {
        this.usuarioRepository = new UsuarioRepositoryImpl();
        this.horoscopoRepository = new HoroscopoRepositoryImpl();
    }

    @Override
    public List<UsuarioDTO> listarUsuarios() {
        List<Usuario> usuarios = usuarioRepository.listarUsuarios();

        return usuarios.stream()
                .map(UsuarioMapper::convertirDTO)
                .collect(Collectors.toList());
    }


    @Override
    public Optional<UsuarioDTO> buscarUsuario(String username) {
        return usuarioRepository.buscarUsuario(username)
                .map(UsuarioMapper::convertirDTO);
    }

    @Override
    public Optional<UsuarioDTO> buscarUsuarioId(int id) {
        return usuarioRepository.buscarUsuarioId(id)
                .map(UsuarioMapper::convertirDTO);
    }

    @Override
    public void crearUsuario(UsuarioCreateDTO usuarioCreateDTO) {
        Usuario usuario = new Usuario(
                usuarioCreateDTO.getNombre(),
                usuarioCreateDTO.getUsername(),
                usuarioCreateDTO.getEmail(),
                usuarioCreateDTO.getFechaNacimiento(),
                usuarioCreateDTO.getPassword(),
                usuarioCreateDTO.getHoroscopoAnimal());
        usuarioRepository.insertarUsuario(usuario);
    }


    @Override
    public void actualizarUsuario(UsuarioUpdateDTO usuarioUpdateDTO) {
        Optional<Usuario> usuarioOptional = usuarioRepository.buscarUsuario(usuarioUpdateDTO.getUsername());

        if (usuarioOptional.isPresent()) {
            Usuario usuarioExistente = usuarioOptional.get();
            // Actualizar los campos del usuario existente
            usuarioExistente.setNombre(usuarioUpdateDTO.getNombre());
            usuarioExistente.setUsername(usuarioUpdateDTO.getUsername());
            usuarioExistente.setEmail(usuarioUpdateDTO.getEmail());
            usuarioExistente.setFechaNacimiento(usuarioUpdateDTO.getFechaNacimiento());
            usuarioExistente.setPassword(usuarioUpdateDTO.getPassword());
            usuarioExistente.setHoroscopoAnimal(usuarioUpdateDTO.getHoroscopoAnimal());
            // Llamar al repositorio para actualizar
            usuarioRepository.actualizarUsuario(usuarioExistente);
        } else {
            // Manejar el caso en que el usuario no existe
            throw new RuntimeException("No se encontró el usuario con ID: " + usuarioUpdateDTO.getId());
        }
    }

    @Override
    public void actualizarUsuarioId(UsuarioUpdateDTO usuarioUpdateDTO) {
        Optional<Usuario> usuarioOptional = usuarioRepository.buscarUsuarioId(usuarioUpdateDTO.getId());
        if (usuarioOptional.isPresent()) {
            Usuario usuarioExistente = usuarioOptional.get();
            // Actualizar los campos del usuario existente
            usuarioExistente.setNombre(usuarioUpdateDTO.getNombre());
            usuarioExistente.setUsername(usuarioUpdateDTO.getUsername());
            usuarioExistente.setEmail(usuarioUpdateDTO.getEmail());
            usuarioExistente.setFechaNacimiento(usuarioUpdateDTO.getFechaNacimiento());
            usuarioExistente.setPassword(usuarioUpdateDTO.getPassword());
            usuarioExistente.setHoroscopoAnimal(usuarioUpdateDTO.getHoroscopoAnimal());

            // Llamar al repositorio para actualizar
            usuarioRepository.actualizarUsuario(usuarioExistente);
        } else {
            // Manejar el caso en que el usuario no existe
            throw new RuntimeException("No se encontró el usuario con ID: " + usuarioUpdateDTO.getId());
        }
    }

    @Override
    public void eliminarUsuario(int id) {
        usuarioRepository.eliminarUsuario(id);
    }
}

