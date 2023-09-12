package com.project.portfolio.service;

import com.project.portfolio.interfaz.ISobreMiService;
import com.project.portfolio.model.SobreMi;
import com.project.portfolio.repository.SobreMiRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class SobreMiService implements ISobreMiService{
    @Autowired
    SobreMiRepository SobreMiRepository;

    @Override
    public List<SobreMi> list(){
        return SobreMiRepository.findAll();
    }
    @Override
    public Optional<SobreMi> getOne(int id){
        return SobreMiRepository.findById(id);
    }
    @Override
    public Optional<SobreMi> getByNombre(String nombre){
        return SobreMiRepository.findByNombre(nombre);
    }
    @Override
    public void save(SobreMi sobre){
        SobreMiRepository.save(sobre);
    }
    @Override
    public void delete(int id){
        SobreMiRepository.deleteById(id);
    }
    @Override
    public boolean existsById(int id){
        return SobreMiRepository.existsById(id);
    }
    @Override
    public boolean existsByNombre(String nombre){
        return SobreMiRepository.existsByNombre(nombre);
    }
}