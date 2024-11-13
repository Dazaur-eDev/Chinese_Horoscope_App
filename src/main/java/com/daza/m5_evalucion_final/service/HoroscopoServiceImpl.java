package com.daza.m5_evalucion_final.service;

import com.daza.m5_evalucion_final.dto.HoroscopoCreateDTO;
import com.daza.m5_evalucion_final.dto.HoroscopoDTO;
import com.daza.m5_evalucion_final.dto.HoroscopoMapper;
import com.daza.m5_evalucion_final.dto.HoroscopoUpdateDTO;
import com.daza.m5_evalucion_final.model.Horoscopo;
import com.daza.m5_evalucion_final.repository.HoroscopoRepository;
import com.daza.m5_evalucion_final.repository.HoroscopoRepositoryImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class HoroscopoServiceImpl implements HoroscopoService {

    private final HoroscopoRepository horoscopoRepository;

    public HoroscopoServiceImpl(){
        this.horoscopoRepository = new HoroscopoRepositoryImpl();
    }

    @Override
    public List<HoroscopoDTO> listarHoroscopos() {
        List<Horoscopo> listaHoroscopos = horoscopoRepository.listarHoroscopos();
        return listaHoroscopos.stream()
                .map(HoroscopoMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<HoroscopoDTO> buscarHoroscopoPorId(int id) {
        return horoscopoRepository.buscarHoroscopo(id)
                .map(HoroscopoMapper::toDTO);
    }

    @Override
    public void crearHoroscopo(HoroscopoCreateDTO horoscopoCreateDTO) {
        Horoscopo horoscopo = HoroscopoMapper.toEntity(horoscopoCreateDTO);
        horoscopoRepository.insertarHoroscopo(horoscopo);
    }

    @Override
    public void actualizarHoroscopo(HoroscopoUpdateDTO horoscopoUpdateDTO) {
        Optional<Horoscopo> horoscopoUpdate = horoscopoRepository.buscarHoroscopo(horoscopoUpdateDTO.getId());
        if (horoscopoUpdate.isPresent()) {
            Horoscopo horoscopo = HoroscopoMapper.toEntity(horoscopoUpdateDTO);
            horoscopoRepository.actualizarHoroscopo(horoscopo);
        } else {
            throw new RuntimeException("Horoscopo no encontrado");
        }
    }

    @Override
    public void eliminarHoroscopo(int id) {
        Optional<Horoscopo> horoscopo = horoscopoRepository.buscarHoroscopo(id);
        if (horoscopo.isPresent()) {
            horoscopoRepository.eliminarHoroscopo(horoscopo.get().getId());
        }
    }
}
