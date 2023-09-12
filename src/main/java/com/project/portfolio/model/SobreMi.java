package com.project.portfolio.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class SobreMi {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private int id;
    @NotNull
    private String nombre;
    private int edad;
    private String descripcion; 
    private String urlFoto;
    public SobreMi() {
    }

    public SobreMi(String nombre, int edad, String descripcion, String img) {
        this.nombre = nombre;
        this.edad = edad;
        this.descripcion = descripcion;
        this.urlFoto = img;
    }    
    public int getId() {
        return this.id;
    }
    public void setId(int id) {
	this.id = id;
    }
    public String getNombre() {
    	return this.nombre;
    }
    public void setNombre(String nombre) {
	this.nombre = nombre;
    }
    public int getEdad() {
	return this.edad;
    }
    public void edad(int edad) {
        this.edad=edad;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getUrlFoto() {
        return this.urlFoto;
    }
    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }
}