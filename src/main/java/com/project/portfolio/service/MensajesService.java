package com.project.portfolio.service;

import com.project.portfolio.interfaz.IMensajesService;
import com.project.portfolio.model.Mensajes;
import com.project.portfolio.repository.MensajesRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MensajesService implements IMensajesService{
    @Autowired
    private MensajesRepository mensajesRepo;
    @Override
    public List<Mensajes> list(){
        return mensajesRepo.findAll();
    }
    @Override
    public Optional<Mensajes> getOne(int id){
        return mensajesRepo.findById(id);
    }
    @Override
    public Optional<Mensajes> getByNombre(String nombre){
        return mensajesRepo.findByNombre(nombre);
    }
    @Override
    public void save(Mensajes mensajes){
        mensajesRepo.save(mensajes);
    }
    @Override
    public void delete(int id){
        mensajesRepo.deleteById(id);
    }
    @Override
    public boolean existsById(int id){
        return mensajesRepo.existsById(id);
    }
    @Override
    public boolean existsByNombre(String nombre){
        return mensajesRepo.existsByNombre(nombre);
    }
}