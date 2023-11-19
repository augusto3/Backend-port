package com.project.portfolio.interfaz;

import com.project.portfolio.model.RedesSociales;
import java.util.List;
import java.util.Optional;

public interface IRedesSocialesService {
    public List<RedesSociales> list();
    public Optional<RedesSociales> getOne(int id);
    public Optional<RedesSociales> getByFacebook(String nombre);
    public void save(RedesSociales redes);
    public void delete(int id);
    public boolean existsById(int id);
    public boolean existsByFacebook(String nombre);
}
