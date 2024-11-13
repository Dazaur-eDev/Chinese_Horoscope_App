package com.daza.m5_evalucion_final.model;

import java.util.Date;

public class Usuario {

    private int id;
    private String nombre;
    private String username;
    private String email;
    private Date fechaNacimiento;
    private String password;
    private String horoscopoAnimal;

    public Usuario() {}

    public Usuario(int id, String nombre, String username, String email, Date fechaNacimiento, String password, String horoscopoAnimal) {
        this.id = id;
        this.nombre = nombre;
        this.username = username;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.password = password;
        this.horoscopoAnimal = horoscopoAnimal;
    }

    public Usuario(String nombre, String username, String email, Date fechaNacimiento, String password) {
        this.nombre = nombre;
        this.username = username;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.password = password;
    }

    public Usuario(String nombre, String username, String email, Date fechaNacimiento, String password, String horoscopoAnimal) {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHoroscopoAnimal() {
        return horoscopoAnimal;
    }

    public void setHoroscopoAnimal(String horoscopoAnimal) {
        this.horoscopoAnimal = horoscopoAnimal;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", password='" + password + '\'' +
                ", horoscopoAnimal=" + horoscopoAnimal +
                '}';
    }
}
