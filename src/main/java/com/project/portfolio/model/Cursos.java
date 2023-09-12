package com.project.portfolio.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Cursos {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private int id;
    @NotNull
    private String nombreCurso;
    private String urlCurso;
    private String urlCertificado;

    public Cursos() {
    }
    public Cursos(String nombreCurso,String urlCurso,String urlCertificado) {
        this.nombreCurso=nombreCurso;
        this.urlCertificado=urlCertificado;
        this.urlCurso=urlCurso;
    }
    public int getId() {
	return id;
    }
    public void setId(int id) {
	this.id = id;
    }
    public String getNombreCurso() {
	return nombreCurso;
    }
    public void setNombreCurso(String nameCurso) {
	this.nombreCurso = nameCurso;
    }
    public String getUrlCurso() {
	return urlCurso;
    }
    public void setUrlCurso(String urlCurso) {
    	this.urlCurso = urlCurso;
    }
    public String getUrlCertificado() {
    	return urlCertificado;
    }
    public void setUrlCertificado(String urlCertificado) {
    	this.urlCertificado = urlCertificado;
    }
}
