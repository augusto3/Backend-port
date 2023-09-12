package com.project.portfolio.interfaz;

import com.project.portfolio.model.MisHabilidades;
import java.util.List;
import java.util.Optional;

public interface IMisHabilidadesService {
    public List<MisHabilidades> list();
    public Optional<MisHabilidades> getOne(int id);
    public Optional<MisHabilidades> getByLenguaje(String nombre);
    public void save(MisHabilidades misHabilidades);
    public void delete(int id);
    public boolean existsById(int id);
    public boolean existsByLenguaje(String nombre);
}
