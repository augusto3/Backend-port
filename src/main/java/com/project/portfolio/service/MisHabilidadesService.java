package com.project.portfolio.service;

import com.project.portfolio.interfaz.IMisHabilidadesService;
import com.project.portfolio.model.MisHabilidades;
import com.project.portfolio.repository.MisHabilidadesRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MisHabilidadesService implements IMisHabilidadesService{
    @Autowired
    private MisHabilidadesRepository habilidadesRepo;
    @Override
    public List<MisHabilidades> list(){
        return habilidadesRepo.findAll();
    }
    @Override
    public Optional<MisHabilidades> getOne(int id){
        return habilidadesRepo.findById(id);
    }
    @Override
    public Optional<MisHabilidades> getByLenguaje(String nombre){
        return habilidadesRepo.findByLenguaje(nombre);
    }
    @Override
    public void save(MisHabilidades misHabilidades){
        habilidadesRepo.save(misHabilidades);
    }
    @Override
    public void delete(int id){
        habilidadesRepo.deleteById(id);
    }
    @Override
    public boolean existsById(int id){
        return habilidadesRepo.existsById(id);
    }
    @Override
    public boolean existsByLenguaje(String nombre){
        return habilidadesRepo.existsByLenguaje(nombre);
    }
}