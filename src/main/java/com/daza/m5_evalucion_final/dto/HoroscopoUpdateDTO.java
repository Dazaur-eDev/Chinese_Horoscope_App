package com.daza.m5_evalucion_final.dto;

import java.util.Date;

public class HoroscopoUpdateDTO {

    private int id;
    private String animal;
    private Date fechaInicio;
    private Date fechaFinal;

    public HoroscopoUpdateDTO() {
    }

    public HoroscopoUpdateDTO(int id, String animal, Date fechaInicio, Date fechaFinal) {
        this.id = id;
        this.animal = animal;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnimal() {
        return animal;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    @Override
    public String toString() {
        return "HoroscopoUpdateDTO{" +
                "id=" + id +
                ", animal='" + animal + '\'' +
                ", fechaInicio=" + fechaInicio +
                ", fechaFinal=" + fechaFinal +
                '}';
    }
}
