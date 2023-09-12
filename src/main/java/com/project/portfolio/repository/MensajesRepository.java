package com.project.portfolio.repository;

import com.project.portfolio.model.Mensajes;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MensajesRepository extends JpaRepository <Mensajes,Integer>{
    public Optional<Mensajes> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
}
