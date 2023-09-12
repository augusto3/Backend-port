package com.project.portfolio.dto;

import jakarta.validation.constraints.NotBlank;

public class dtoCursos {
    @NotBlank
    private String nombreCurso;
    @NotBlank
    private String urlCurso;
    @NotBlank
    private String urlCertificado;

    public dtoCursos() {
    }
    public dtoCursos(String nombreCurso,String urlCurso,String urlCertificado) {
        this.nombreCurso=nombreCurso;
        this.urlCertificado=urlCertificado;
        this.urlCurso=urlCurso;
    }
    public String getNombreCurso() {
	return this.nombreCurso;
    }
    public void setNombreCurso(String nombreCurso) {
	this.nombreCurso = nombreCurso;
    }
    public String getUrlCurso() {
	return this.urlCurso;
    }
    public void setUrlCurso(String urlCurso) {
    	this.urlCurso = urlCurso;
    }
    public String getUrlCertificado() {
    	return this.urlCertificado;
    }
    public void setUrlCertificado(String urlCertificado) {
    	this.urlCertificado = urlCertificado;
    }
}