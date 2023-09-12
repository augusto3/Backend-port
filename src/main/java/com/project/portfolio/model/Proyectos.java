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
public class Proyectos {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private int id;
    @NotNull
    private String nameProyectos;
    private String urlProyectos;
    private String descripcion;
    public Proyectos() {
    }
    public Proyectos(String nameProyectos, String descripcion,String urlProyectos){
        this.nameProyectos=nameProyectos;
        this.descripcion=descripcion;
        this.urlProyectos=urlProyectos;
    }
    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
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
