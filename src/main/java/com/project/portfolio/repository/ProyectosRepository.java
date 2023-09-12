package com.project.portfolio.repository;

import com.project.portfolio.model.Proyectos;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyectosRepository extends JpaRepository <Proyectos,Integer> {
    public Optional<Proyectos> findByNameProyectos(String nombre);
    public boolean existsByNameProyectos(String nombre);

}
