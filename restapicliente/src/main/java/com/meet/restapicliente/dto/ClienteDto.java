package com.meet.restapicliente.dto;

public class ClienteDto {

    private int dni;
    private String nombre;
    private String apellido;
    private int edad;

    //********************
    //** CONSTRUCTORES  **
    //********************

    public ClienteDto(int dni, String nombre, String apellido, int edad) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    public ClienteDto() {
    }

    //**********************
    //** GETTERS SETTERS  **
    //**********************

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
