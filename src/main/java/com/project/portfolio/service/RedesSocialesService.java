package com.project.portfolio.service;

import com.project.portfolio.interfaz.IRedesSocialesService;
import com.project.portfolio.model.RedesSociales;
import com.project.portfolio.repository.RedesSocialesRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RedesSocialesService implements IRedesSocialesService{
    @Autowired
    private RedesSocialesRepository redes;
    @Override
    public List<RedesSociales> list() {
        return redes.findAll();
    }
    @Override
    public void save(RedesSociales redesSociales) {
        redes.save(redesSociales);
    }
    @Override
    public void delete(int id) {
        redes.deleteById(id);
    }
    @Override
    public Optional<RedesSociales> getByFacebook(String nombre){
        return redes.findByFacebook(nombre);
    }
    @Override
    public Optional<RedesSociales> getOne(int id){
        return redes.findById(id);
    }
    @Override
    public boolean existsById(int id){
        return redes.existsById(id);
    }
    @Override
    public boolean existsByFacebook(String nombre){
        return redes.existsByFacebook(nombre);
    }
}