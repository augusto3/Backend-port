package com.project.portfolio.repository;

import com.project.portfolio.model.Experiencia;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienciaRepository extends JpaRepository <Experiencia,Integer>{
    public Optional<Experiencia> findByNombreEmpresa(String nombre);
    public boolean existsByNombreEmpresa(String nombre);
    
}
