package com.project.portfolio.dto;

import jakarta.validation.constraints.NotBlank;

public class dtoMisHabilidades {
    @NotBlank
    private String lenguaje;
    @NotBlank
    private int porcentaje;

    public dtoMisHabilidades() {}

    public dtoMisHabilidades(String lenguaje,int porcentaje){
        this.lenguaje=lenguaje;
        this.porcentaje=porcentaje;
    }
    public String getLenguaje() {
            return this.lenguaje;
    }
    public void setLenguaje(String lenguaje) {
            this.lenguaje = lenguaje;
    }
    public int getPorcentaje() {
            return this.porcentaje;
    }
    public void setPorcentaje(int porcentaje) {
            this.porcentaje = porcentaje;
    }
}