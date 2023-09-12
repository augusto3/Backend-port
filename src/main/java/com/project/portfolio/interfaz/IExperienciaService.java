package com.project.portfolio.interfaz;

import com.project.portfolio.model.Experiencia;
import java.util.List;
import java.util.Optional;

public interface IExperienciaService {
    public List<Experiencia> list();
    public Optional<Experiencia> getOne(int id);
    public Optional<Experiencia> getByNombre(String nombre);
    public void save(Experiencia experiencia);
    public void delete(int id);
    public boolean existsById(int id);
    public boolean existsByNombre(String nombre);

}
