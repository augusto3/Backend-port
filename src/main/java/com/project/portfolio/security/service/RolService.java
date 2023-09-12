package com.project.portfolio.security.service;

import com.project.portfolio.security.entity.Rol;
import com.project.portfolio.security.enums.RolNombre;
import com.project.portfolio.security.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class RolService {

    @Autowired
    RolRepository rolRepository;

    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        return rolRepository.findByRolNombre(rolNombre);
    }

    public void save(Rol rol){
        rolRepository.save(rol);
    }
    public boolean existsById(int id){
        return rolRepository.existsById(id); 
    }
    public void saveAuto(){
        Rol rol=new Rol();
        rol.RolById(1,RolNombre.ROLE_ADMIN);
        rolRepository.save(rol);
        rol.RolById(2,RolNombre.ROLE_USER);
        rolRepository.save(rol);
    }
}
