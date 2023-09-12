package com.project.portfolio.interfaz;

import com.project.portfolio.model.SobreMi;
import java.util.List;
import java.util.Optional;

public interface ISobreMiService{
    public List<SobreMi> list();
    public Optional<SobreMi> getOne(int id);
    public Optional<SobreMi> getByNombre(String nombre);
    public void save(SobreMi sobre);
    public void delete(int id);
    public boolean existsById(int id);
    public boolean existsByNombre(String nombre);
}