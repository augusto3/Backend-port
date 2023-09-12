package com.project.portfolio.interfaz;

import com.project.portfolio.model.Proyectos;
import java.util.List;
import java.util.Optional;

public interface IProyectosService {
    public List<Proyectos> list();
    public Optional<Proyectos> getOne(int id);
    public Optional<Proyectos> getByNombre(String nombre);
    public void save(Proyectos proyecto);
    public void delete(int id);
    public boolean existsById(int id);
    public boolean existsByNombre(String nombre);
}
