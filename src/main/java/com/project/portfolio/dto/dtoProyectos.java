package com.project.portfolio.dto;

import jakarta.validation.constraints.NotBlank;

public class dtoProyectos {
    @NotBlank
    private String nameProyectos;
    @NotBlank
    private String urlProyectos;
    @NotBlank
    private String descripcion;

    public dtoProyectos() {
    }

    public dtoProyectos(String nameProyectos, String descripcion,String urlProyectos){
        this.nameProyectos=nameProyectos;
        this.descripcion=descripcion;
        this.urlProyectos=urlProyectos;
    }
    public String getNameProyectos() {
            return this.nameProyectos;
    }
    public void setNameProyectos(String nameProyectos) {
            this.nameProyectos = nameProyectos;
    }
    public String getUrlProyectos() {
            return this.urlProyectos;
    }
    public void setUrlProyectos(String urlProyectos) {
            this.urlProyectos = urlProyectos;
    }
    public String getDescripcion() {
            return this.descripcion;
    }
    public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
    }
}