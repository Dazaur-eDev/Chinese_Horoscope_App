package com.daza.m5_evalucion_final.dto;

import com.daza.m5_evalucion_final.model.Horoscopo;

public class HoroscopoMapper {
    public static HoroscopoDTO toDTO(Horoscopo horoscopo) {
        return new HoroscopoDTO(
                horoscopo.getId(),
                horoscopo.getAnimal(),
                horoscopo.getFechaInicio(),
                horoscopo.getFechaFin()
        );
    }

    public static Horoscopo toEntity(HoroscopoCreateDTO dto) {
        return new Horoscopo(dto.getAnimal(), dto.getFechaInicio(), dto.getFechaFinal());
    }

    public static Horoscopo toEntity(HoroscopoUpdateDTO dto) {
        return new Horoscopo(dto.getId(), dto.getAnimal(), dto.getFechaInicio(), dto.getFechaFinal());
    }
}
