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
public class Experiencia {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private int id;
    @NotNull
    private String nombreEmpresa;
    private String puestoTrabajo;
    private String fechaInicio;
    private String fechaFin;
    private String descripcion;
    public Experiencia() {
    }
    public Experiencia(String nombreEmpresa, String puestoTrabajo,String fechaInicio,String fechaFin,String descripcion){
        this.nombreEmpresa=nombreEmpresa;
        this.puestoTrabajo=puestoTrabajo;
        this.fechaInicio=fechaInicio;
        this.fechaFin=fechaFin;
        this.descripcion=descripcion;
    }
    public int getId() {
	return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombreEmpresa() {
        return nombreEmpresa;
    }
    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }
    public String getPuestoTrabajo() {
        return puestoTrabajo;
    }
    public void setPuestoTrabajo(String puestoTrabajo) {
        this.puestoTrabajo = puestoTrabajo;
    }
    public String getFechaInicio() {
        return fechaInicio;
    }
    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    public String getFechaFin() {
        return fechaFin;
    }
    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}