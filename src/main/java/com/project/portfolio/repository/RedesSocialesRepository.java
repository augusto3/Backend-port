package com.project.portfolio.repository;

import com.project.portfolio.model.RedesSociales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RedesSocialesRepository extends JpaRepository <RedesSociales, Long>{
}
