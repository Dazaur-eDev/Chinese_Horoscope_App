package com.daza.m5_evalucion_final.repository;

import com.daza.m5_evalucion_final.configuration.DatabaseConnection;
import com.daza.m5_evalucion_final.model.Horoscopo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class HoroscopoRepositoryImpl implements HoroscopoRepository {

    @Override
    public List<Horoscopo> listarHoroscopos() {
        List<Horoscopo> listaHoroscopos = new ArrayList<>();
        String sql = "SELECT id, animal, fecha_inicio, fecha_fin FROM horoscopo ORDER BY id";

        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement pstm = conn.prepareStatement(sql);
             ResultSet rs = pstm.executeQuery()
        ) {
            while (rs.next()) {
                Horoscopo horoscopo = new Horoscopo();
                horoscopo.setId(rs.getInt("id"));
                horoscopo.setAnimal(rs.getString("animal"));
                horoscopo.setFechaInicio(rs.getDate("fecha_inicio"));
                horoscopo.setFechaFin(rs.getDate("fecha_fin"));
                listaHoroscopos.add(horoscopo);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al listar el horóscopo", e);
        }
        return listaHoroscopos;
    }

    @Override
    public void insertarHoroscopo(Horoscopo horoscopo) {
        String sql = "INSERT INTO horoscopo (animal, fecha_inicio, fecha_fin) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement pstm = conn.prepareStatement(sql)
        ) {
            pstm.setString(1, horoscopo.getAnimal());
            pstm.setDate(2, (Date) horoscopo.getFechaInicio());
            pstm.setDate(3, (Date) horoscopo.getFechaFin());
            pstm.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al guardar en horóscopo", e);
        }
    }

    @Override
    public Optional<Horoscopo> buscarHoroscopo(int id) {
        String sql = "SELECT id, animal, fecha_inicio, fecha_fin FROM horoscopo WHERE id = ?";

        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement pstm = conn.prepareStatement(sql)
        ) {

            pstm.setInt(1, id);
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    Horoscopo horoscopo = new Horoscopo();
                    horoscopo.setId(rs.getInt("id"));
                    horoscopo.setAnimal(rs.getString("animal"));
                    horoscopo.setFechaInicio(rs.getDate("fecha_inicio"));
                    horoscopo.setFechaFin(rs.getDate("fecha_fin"));
                    return Optional.of(horoscopo);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error al buscar el horóscopo por ID", e);
        }
        return Optional.empty();
    }

    @Override
    public void actualizarHoroscopo(Horoscopo horoscopo) {
        String sql = "UPDATE horoscopo SET animal = ?, fecha_inicio = ?, fecha_fin = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement pstm = conn.prepareStatement(sql))
        {
            pstm.setString(1, horoscopo.getAnimal());
            pstm.setDate(2, (Date) horoscopo.getFechaInicio());
            pstm.setDate(3, (Date) horoscopo.getFechaFin());
            pstm.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Error al actualizar el horóscopo", e);
        }
    }

    @Override
    public void eliminarHoroscopo(int id) {
        String sql = "DELETE FROM horoscopo WHERE id = ?";

        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement pstm = conn.prepareStatement(sql)
        ) {
            pstm.setInt(1, id);
            pstm.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("No es posible eliminar el horóscopo", e);
        }
    }
}
