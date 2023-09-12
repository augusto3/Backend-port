package com.project.portfolio.dto;

import jakarta.validation.constraints.NotBlank;

public class dtoUniversidad {
    @NotBlank
    private String nombreUniversidad;
    @NotBlank
    private String nombreCarrera;
    @NotBlank
    private String fechaInicio;
    @NotBlank
    private String fechaFin;
    @NotBlank
    private String historialAcademico;

    public dtoUniversidad() {}
    public dtoUniversidad(String nombreUniversidad, String nombreCarrera, String fechaInicio, String fechaFin, String historialAcademico) {
        this.nombreUniversidad=nombreUniversidad;
        this.nombreCarrera = nombreCarrera;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.historialAcademico = historialAcademico;
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
