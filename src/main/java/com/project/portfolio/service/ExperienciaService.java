package com.project.portfolio.service;

import com.project.portfolio.interfaz.IExperienciaService;
import com.project.portfolio.model.Experiencia;
import com.project.portfolio.repository.ExperienciaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienciaService implements IExperienciaService{
    @Autowired
    private ExperienciaRepository experienciaRepo;
    @Override
    public List<Experiencia> list(){
        return experienciaRepo.findAll();
    }
    @Override
    public Optional<Experiencia> getOne(int id){
        return experienciaRepo.findById(id);
    }
    @Override
    public Optional<Experiencia> getByNombre(String nombre){
        return experienciaRepo.findByNombreEmpresa(nombre);
    }
    @Override
    public void save(Experiencia experiencia){
        experienciaRepo.save(experiencia);
    }
    @Override
    public void delete(int id){
        experienciaRepo.deleteById(id);
    }
    @Override
    public boolean existsById(int id){
        return experienciaRepo.existsById(id);
    }
    @Override
    public boolean existsByNombre(String nombre){
        return experienciaRepo.existsByNombreEmpresa(nombre);
    }
}