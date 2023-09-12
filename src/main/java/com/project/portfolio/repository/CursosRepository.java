package com.project.portfolio.repository;

import com.project.portfolio.model.Cursos;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursosRepository extends JpaRepository <Cursos,Integer>{
    public Optional<Cursos> findByNombreCurso(String nombre);
    public boolean existsByNombreCurso(String nombre);

}
