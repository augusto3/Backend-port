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
public class MisHabilidades {
   @Id
   @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private int id;
    @NotNull
    private String lenguaje;
    private int porcentaje;
    public MisHabilidades() {}

    public MisHabilidades(String lenguaje,int porcentaje){
        this.lenguaje=lenguaje;
        this.porcentaje=porcentaje;
    }
    public int getId() {
            return id;
    }
    public void setId(int id) {
            this.id = id;
    }
    public String getLenguaje() {
            return lenguaje;
    }
    public void setLenguaje(String lenguaje) {
            this.lenguaje = lenguaje;
    }
    public int getPorcentaje() {
            return porcentaje;
    }
    public void setPorcentaje(int porcentaje) {
            this.porcentaje = porcentaje;
    }
}