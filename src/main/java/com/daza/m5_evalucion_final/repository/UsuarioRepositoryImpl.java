package com.daza.m5_evalucion_final.repository;

import com.daza.m5_evalucion_final.configuration.DatabaseConnection;
import com.daza.m5_evalucion_final.model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsuarioRepositoryImpl implements UsuarioRepository {

    @Override
    public List<Usuario> listarUsuarios() {
        List<Usuario> listaUsuarios = new ArrayList<>();
        String sql = "SELECT id, nombre, username, email, fecha_nacimiento, horoscopo_animal FROM usuarios ORDER BY id";

        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement pstm = conn.prepareStatement(sql);
             ResultSet rs = pstm.executeQuery())
        {
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setUsername(rs.getString("username"));
                usuario.setEmail(rs.getString("email"));
                usuario.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
                usuario.setHoroscopoAnimal(rs.getString("horoscopo_animal"));
                listaUsuarios.add(usuario);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al listar los usuarios", e);
        }
        return listaUsuarios;
    }

    @Override
    public void insertarUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuarios (nombre, username, email, fecha_nacimiento, password, horoscopo_animal) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement pstm = conn.prepareStatement(sql))
        {
            pstm.setString(1, usuario.getNombre());
            pstm.setString(2, usuario.getUsername());
            pstm.setString(3, usuario.getEmail());
            pstm.setDate(4, new java.sql.Date(usuario.getFechaNacimiento().getTime()));
            pstm.setString(5, usuario.getPassword());
            pstm.setString(6, usuario.getHoroscopoAnimal());
            pstm.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al guardar el usuario", e);
        }
    }

    @Override
    public Optional<Usuario> buscarUsuario(String username) {
        String sql = "SELECT id, nombre, username, email, fecha_nacimiento, password, horoscopo_animal FROM usuarios WHERE username = ?";

        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement pstm = conn.prepareStatement(sql))
        {
            pstm.setString(1, username);
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    Usuario usuario = new Usuario();
                    usuario.setId(rs.getInt("id"));
                    usuario.setNombre(rs.getString("nombre"));
                    usuario.setUsername(rs.getString("username"));
                    usuario.setEmail(rs.getString("email"));
                    usuario.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
                    usuario.setPassword(rs.getString("password"));
                    usuario.setHoroscopoAnimal(rs.getString("horoscopo_animal"));
                    return Optional.of(usuario);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error al buscar el usuario por Username", e);
        }
        return Optional.empty();
    }

    @Override
    public Optional<Usuario> buscarUsuarioId(int id) {
        String sql = "SELECT id, nombre, username, email, fecha_nacimiento, password, horoscopo_animal FROM usuarios WHERE id = ?";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement pstm = conn.prepareStatement(sql))
        {
            pstm.setInt(1, id);
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    Usuario usuario = new Usuario();
                    usuario.setId(rs.getInt("id"));
                    usuario.setNombre(rs.getString("nombre"));
                    usuario.setUsername(rs.getString("username"));
                    usuario.setEmail(rs.getString("email"));
                    usuario.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
                    usuario.setPassword(rs.getString("password"));
                    usuario.setHoroscopoAnimal(rs.getString("horoscopo_animal"));
                    return Optional.of(usuario);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al buscar el usuario por Username", e);
        }
        return Optional.empty();
    }

    @Override
    public void actualizarUsuario(Usuario usuario) {
        String sql = "UPDATE usuarios SET nombre = ?, username = ?, email = ?, fecha_nacimiento = ?, password = ?, horoscopo_animal = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement pstm = conn.prepareStatement(sql))
        {
            pstm.setString(1, usuario.getNombre());
            pstm.setString(2, usuario.getUsername());
            pstm.setString(3, usuario.getEmail());
            pstm.setDate(4, new java.sql.Date(usuario.getFechaNacimiento().getTime()));
            pstm.setString(5, usuario.getPassword());
            pstm.setString(6, usuario.getHoroscopoAnimal());
            pstm.setInt(7, usuario.getId());
            pstm.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Error al actualizar el usuario", e);
        }
    }

    @Override
    public void eliminarUsuario(int id) {
        String sql = "DELETE FROM usuarios WHERE id = ?";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement pstm = conn.prepareStatement(sql))
        {
            pstm.setInt(1, id);
            pstm.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("No es posible eliminar el usuario", e);
        }
    }
}
