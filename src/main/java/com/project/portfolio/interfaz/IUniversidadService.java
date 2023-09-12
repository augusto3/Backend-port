package com.project.portfolio.interfaz;

import com.project.portfolio.model.Universidad;
import java.util.List;
import java.util.Optional;

public interface IUniversidadService {
    public List<Universidad> list();
    public Optional<Universidad> getOne(int id);
    public void save(Universidad universidad);
    public void delete(int id);
    public Optional<Universidad> getByNombre(String nombre);
    public boolean existsById(int id);
    public boolean existsByNameUniversidad(String nombre);
}
