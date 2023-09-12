package com.project.portfolio.controller;

import com.project.portfolio.model.Universidad;
import com.project.portfolio.dto.Mensaje;
import com.project.portfolio.dto.dtoUniversidad;
import com.project.portfolio.interfaz.IUniversidadService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/universidad")
@CrossOrigin(origins={"https://portafolio-angular-543.web.app","https://portafolio-angular-543.firebaseapp.com","http://localhost:4200"})
public class UniversidadController {
    @Autowired
    private IUniversidadService implUniversidad;

    @GetMapping("/datos")
    @ResponseBody
    @CrossOrigin(origins={"https://portafolio-angular-543.web.app","https://portafolio-angular-543.firebaseapp.com","http://localhost:4200"})
    public ResponseEntity<List<Universidad>> getUniversidad(){
        List<Universidad> list = implUniversidad.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crear")
    @CrossOrigin(origins={"https://portafolio-angular-543.web.app","https://portafolio-angular-543.firebaseapp.com","http://localhost:4200"})
    public ResponseEntity<?> CreateUniversidad(@RequestBody dtoUniversidad uni){
        if(StringUtils.isBlank(uni.getNombreUniversidad())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(implUniversidad.existsByNameUniversidad(uni.getNombreUniversidad())){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        Universidad universidad = new Universidad(uni.getNombreUniversidad(), uni.getNombreCarrera(), uni.getFechaInicio(),uni.getFechaFin(),uni.getHistorialAcademico());
        implUniversidad.save(universidad);
        return new ResponseEntity(new Mensaje("estudios universitarios creados"), HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/borrar/{id}")
    @CrossOrigin(origins={"https://portafolio-angular-543.web.app","https://portafolio-angular-543.firebaseapp.com","http://localhost:4200"})
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!implUniversidad.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        implUniversidad.delete(id);
        return new ResponseEntity(new Mensaje("estudios universitarios eliminados"), HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/edit/{id}")
    @CrossOrigin(origins={"https://portafolio-angular-543.web.app","https://portafolio-angular-543.firebaseapp.com","http://localhost:4200"})
    public ResponseEntity<?> editSobreMi(@PathVariable("id") int id, @RequestBody dtoUniversidad dtoUni){
        if(!implUniversidad.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        if(implUniversidad.existsByNameUniversidad(dtoUni.getNombreUniversidad()) && implUniversidad.getByNombre(dtoUni.getNombreUniversidad()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Ese estudio universitario ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoUni.getNombreUniversidad())){
            return new ResponseEntity(new Mensaje("El nombre de la universidad no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        Universidad uni=implUniversidad.getOne(id).get();
        uni.setNombreCarrera(dtoUni.getNombreCarrera());
        uni.setNombreUniversidad(dtoUni.getNombreUniversidad());
        uni.setFechaInicio(dtoUni.getFechaInicio());
        uni.setFechaFin(dtoUni.getFechaFin());
        uni.setHistorialAcademico(dtoUni.getHistorialAcademico());
        implUniversidad.save(uni);
        return new ResponseEntity(new Mensaje("estudios universitarios actualizados"), HttpStatus.OK);
    }
}