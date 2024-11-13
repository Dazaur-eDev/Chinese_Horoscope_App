package com.daza.m5_evalucion_final.service;

import com.daza.m5_evalucion_final.dto.HoroscopoCreateDTO;
import com.daza.m5_evalucion_final.dto.HoroscopoDTO;
import com.daza.m5_evalucion_final.dto.HoroscopoUpdateDTO;

import java.util.List;
import java.util.Optional;

public interface HoroscopoService {
    List<HoroscopoDTO> listarHoroscopos();
    Optional<HoroscopoDTO> buscarHoroscopoPorId(int id);
    void crearHoroscopo(HoroscopoCreateDTO horoscopoCreateDTO);
    void actualizarHoroscopo(HoroscopoUpdateDTO horoscopoUpdateDTO);
    void eliminarHoroscopo(int id);
}
