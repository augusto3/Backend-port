package com.project.portfolio.repository;

import com.project.portfolio.model.SobreMi;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SobreMiRepository extends JpaRepository <SobreMi, Integer>{
    public Optional<SobreMi> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
}