package com.daza.m5_evalucion_final.dto;

import java.util.Date;

public class HoroscopoDTO {
    private int id;
    private String animal;
    private Date fechaInicio;
    private Date fechaFin;

    public HoroscopoDTO() {
    }

    public HoroscopoDTO(int id, String animal, Date fechaInicio, Date fechaFin) {
        this.id = id;
        this.animal = animal;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
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

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    @Override
    public String toString() {
        return "HoroscopoDTO{" +
                "id=" + id +
                ", animal='" + animal + '\'' +
                ", fechaInicio=" + fechaInicio +
                ", fechaFinal=" + fechaFin +
                '}';
    }
}
