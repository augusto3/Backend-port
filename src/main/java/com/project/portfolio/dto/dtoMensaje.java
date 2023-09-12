package com.project.portfolio.dto;

import jakarta.validation.constraints.NotBlank;
import java.util.Date;

public class dtoMensaje {
    @NotBlank
    private String nombre;
    @NotBlank
    private String apellido;
    @NotBlank
    private String celular;
    @NotBlank
    private String email;
    @NotBlank
    private String mensaje;
    @NotBlank
    private Date fecha;
  
    public dtoMensaje() {
    }
    public dtoMensaje(String nombre, String apellido,String celular, String email,String mensaje,Date fecha){
        this.nombre=nombre;
        this.apellido=apellido;
        this.celular=celular;
        this.email=email;
        this.mensaje=mensaje;
        this.fecha=fecha;
    }
    public String getNombre() {
        return this.nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return this.apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getCelular() {
        return this.celular;
    }
    public void setCelular(String celular) {
        this.celular = celular;
    }
    public String getEmail() {
        return this.email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getMensaje() {
        return this.mensaje;
    }
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    public Date getFecha() {
        return this.fecha;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}