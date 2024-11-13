package com.daza.m5_evalucion_final.dto;

import java.util.Date;

public class UsuarioDTO {
    private int id;
    private String nombre;
    private String username;
    private String email;
    private Date fechaNacimiento;
    private String password;
    private String horoscopoAnimal;

    public UsuarioDTO() {}

    public UsuarioDTO(int id, String nombre, String username, String email, Date fechaNacimiento, String password, String horoscopoAnimal) {
        this.id = id;
        this.nombre = nombre;
        this.username = username;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.password = password;
        this.horoscopoAnimal = horoscopoAnimal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getHoroscopoAnimal() {
        return horoscopoAnimal;
    }

    public void setHoroscopoAnimal(String horoscopoAnimal) {
        this.horoscopoAnimal = horoscopoAnimal;
    }

    @Override
    public String toString() {
        return "UsuarioDTO{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", horoscopoAnimal='" + horoscopoAnimal + '\'' +
                '}';
    }
}
