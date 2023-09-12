package com.project.portfolio.service;

import com.project.portfolio.interfaz.ICursosService;
import com.project.portfolio.model.Cursos;
import com.project.portfolio.repository.CursosRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursosService implements ICursosService{
    @Autowired
    private CursosRepository cursoRepo;

    @Override
    public List<Cursos> list(){
        return cursoRepo.findAll();
    }
    @Override
    public Optional<Cursos> getOne(int id){
        return cursoRepo.findById(id);
    }
    @Override
    public Optional<Cursos> getByNombre(String nombre){
        return cursoRepo.findByNombreCurso(nombre);
    }
    @Override
    public void save(Cursos cursos){
        cursoRepo.save(cursos);
    }
    @Override
    public void delete(int id){
        cursoRepo.deleteById(id);
    }
    @Override
    public boolean existsById(int id){
        return cursoRepo.existsById(id);
    }
    @Override
    public boolean existsByNombre(String nombre){
        return cursoRepo.existsByNombreCurso(nombre);
    }
}