package com.project.portfolio.repository;

import com.project.portfolio.model.RedesSociales;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RedesSocialesRepository extends JpaRepository <RedesSociales, Integer>{
    public Optional<RedesSociales> findByFacebook(String nombre);
    public boolean existsByFacebook(String nombre);

}
