package com.project.portfolio.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Mensajes {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private int id;
    @NotNull
    private String nombre;
    private String apellido;
    private String celular;
    private String email;
    private String mensaje;
    private Date fecha;
  
    public Mensajes() {
    }
    public Mensajes(String nombre, String apellido,String celular, String email,String mensaje,Date fecha){
        this.nombre=nombre;
        this.apellido=apellido;
        this.celular=celular;
        this.email=email;
        this.mensaje=mensaje;
        this.fecha=fecha;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getCelular() {
        return celular;
    }
    public void setCelular(String celular) {
        this.celular = celular;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getMensaje() {
        return mensaje;
    }
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    public Date getFecha() {
        return fecha;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}