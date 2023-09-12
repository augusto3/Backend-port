package com.project.portfolio.dto;

public class Mensaje {
    private String mensaje;
    
    public Mensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    public Mensaje() {}

    public String getMensaje() {
        return this.mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
