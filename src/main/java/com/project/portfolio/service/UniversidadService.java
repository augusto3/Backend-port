package com.project.portfolio.service;

import com.project.portfolio.interfaz.IUniversidadService;
import com.project.portfolio.model.Universidad;
import com.project.portfolio.repository.UniversidadRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UniversidadService implements IUniversidadService{
    @Autowired
    private UniversidadRepository universidadRepository;
    @Override
    public List<Universidad> list() {
        return universidadRepository.findAll();
    }    
    @Override
    public Optional<Universidad> getOne(int id){
        return universidadRepository.findById(id);
    }   
    @Override
    public void save(Universidad universidad) {
        universidadRepository.save(universidad);
    }
    @Override
    public void delete(int id) {
        universidadRepository.deleteById(id);
    }
    @Override
    public Optional<Universidad> getByNombre(String nombre){
        return universidadRepository.findByNombreUniversidad(nombre);
    }
    @Override
    public boolean existsById(int id){
        return universidadRepository.existsById(id);
    }
    @Override
    public boolean existsByNameUniversidad(String nombre){
        return universidadRepository.existsByNombreUniversidad(nombre);
    }
}