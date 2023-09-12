package com.project.portfolio.repository;

import com.project.portfolio.model.MisHabilidades;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MisHabilidadesRepository extends JpaRepository <MisHabilidades, Integer> {
    public Optional<MisHabilidades> findByLenguaje(String lenguaje);
    public boolean existsByLenguaje(String lenguaje);
}
