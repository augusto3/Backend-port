package com.project.portfolio.interfaz;

import com.project.portfolio.model.Cursos;
import java.util.List;
import java.util.Optional;

public interface ICursosService {    
    public List<Cursos> list();
    public Optional<Cursos> getOne(int id);
    public Optional<Cursos> getByNombre(String nombre);
    public void save(Cursos cursos);
    public void delete(int id);
    public boolean existsById(int id);
    public boolean existsByNombre(String nombre);
}
