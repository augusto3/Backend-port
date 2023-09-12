package com.project.portfolio.interfaz;

import com.project.portfolio.model.Mensajes;
import java.util.List;
import java.util.Optional;

public interface IMensajesService {
    public List<Mensajes> list();
    public Optional<Mensajes> getOne(int id);
    public Optional<Mensajes> getByNombre(String nombre);
    public void save(Mensajes mensajes);
    public void delete(int id);
    public boolean existsById(int id);
    public boolean existsByNombre(String nombre);
}
