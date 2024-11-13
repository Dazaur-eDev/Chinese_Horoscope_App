package com.daza.m5_evalucion_final.repository;

import com.daza.m5_evalucion_final.model.Horoscopo;

import java.util.List;
import java.util.Optional;

public interface HoroscopoRepository {
    List<Horoscopo> listarHoroscopos();
    void insertarHoroscopo(Horoscopo horoscopo);
    Optional<Horoscopo> buscarHoroscopo(int id);
    void actualizarHoroscopo(Horoscopo horoscopo);
    void eliminarHoroscopo(int id);
}
