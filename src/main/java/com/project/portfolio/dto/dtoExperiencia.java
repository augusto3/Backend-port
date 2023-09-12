package com.project.portfolio.dto;

import jakarta.validation.constraints.NotBlank;

public class dtoExperiencia {
    @NotBlank
    private String nombreEmpresa;
    @NotBlank
    private String puestoTrabajo;
    @NotBlank
    private String fechaInicio;
    @NotBlank
    private String fechaFin;
    @NotBlank
    private String descripcion;

    public dtoExperiencia() {
    }

    public dtoExperiencia(String nombreEmpresa, String puestoTrabajo,String fechaInicio,String fechaFin,String descripcion){
        this.nombreEmpresa=nombreEmpresa;
        this.puestoTrabajo=puestoTrabajo;
        this.fechaInicio=fechaInicio;
        this.fechaFin=fechaFin;
        this.descripcion=descripcion;
    }
    public String getNombreEmpresa() {
        return this.nombreEmpresa;
    }
    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }
    public String getPuestoTrabajo() {
        return this.puestoTrabajo;
    }
    public void setPuestoTrabajo(String puestoTrabajo) {
        this.puestoTrabajo = puestoTrabajo;
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
    public String getDescripcion() {
        return this.descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}