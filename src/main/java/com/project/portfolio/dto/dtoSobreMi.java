package com.project.portfolio.dto;

import jakarta.validation.constraints.NotBlank;
import java.util.Date;

public class dtoSobreMi {
    @NotBlank
    private String nombre;
    @NotBlank
    private int edad;
    @NotBlank
    private String descripcion; 
    @NotBlank
    private String urlFoto;

    public dtoSobreMi() {
    }
    public dtoSobreMi(String nombre, int edad, String descripcion, String urlFoto) {
        this.nombre = nombre;
        this.edad = edad;
        this.descripcion = descripcion;
        this.urlFoto = urlFoto;
    }
    public String getNombre() {
        return this.nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public int getEdad() {
	return this.edad;
    }
    public void setFechaDeNacimiento(int edad) {
        this.edad=edad;
    }
    public String getUrlFoto() {
        return this.urlFoto;
    }
    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }
}