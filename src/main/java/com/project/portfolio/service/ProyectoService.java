package com.project.portfolio.service;

import com.project.portfolio.interfaz.IProyectosService;
import com.project.portfolio.model.Proyectos;
import com.project.portfolio.repository.ProyectosRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProyectoService implements IProyectosService{
    @Autowired
    private ProyectosRepository proyectoRepo;
    @Override
    public List<Proyectos> list(){
        return proyectoRepo.findAll();
    }
    @Override
    public Optional<Proyectos> getOne(int id){
        return proyectoRepo.findById(id);
    }
    @Override
    public Optional<Proyectos> getByNombre(String nombre){
        return proyectoRepo.findByNameProyectos(nombre);
    }
    @Override
    public void save(Proyectos proyecto){
        proyectoRepo.save(proyecto);
    }
    @Override
    public void delete(int id){
        proyectoRepo.deleteById(id);
    }
    @Override
    public boolean existsById(int id){
        return proyectoRepo.existsById(id);
    }
    @Override
    public boolean existsByNombre(String nombre){
        return proyectoRepo.existsByNameProyectos(nombre);
    }
}