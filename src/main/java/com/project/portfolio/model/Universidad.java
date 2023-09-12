package com.project.portfolio.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Universidad {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private int id;
    @NotNull
    private String nombreUniversidad;
    private String nombreCarrera;
    private String fechaInicio;
    private String fechaFin;
    private String historialAcademico;

    public Universidad() {}
    public Universidad(String nombreUniversidad, String nombreCarrera, String fechaInicio, String fechaFin, String historialAcademico) {
        this.nombreUniversidad=nombreUniversidad;
        this.nombreCarrera = nombreCarrera;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.historialAcademico = historialAcademico;
    }
    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombreUniversidad() {
        return this.nombreUniversidad;
    }
    public void setNombreUniversidad(String nombreUniversidad) {
        this.nombreUniversidad = nombreUniversidad;
    }
    public String getNombreCarrera() {
        return this.nombreCarrera;
    }
    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }
    public String getFechaInicio() {
        return this.fechaInicio;
    }
    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    public String getFechaFin() {
        return this.fechaFin;
    }
    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }
    public String getHistorialAcademico() {
        return this.historialAcademico;
    }
    public void setHistorialAcademico(String historialAcademico) {
        this.historialAcademico = historialAcademico;
    }
}