package com.project.portfolio.repository;

import com.project.portfolio.model.Universidad;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniversidadRepository extends JpaRepository <Universidad, Integer>{
    public Optional<Universidad> findByNombreUniversidad(String nombre);
    public boolean existsByNombreUniversidad(String nombre);

}
