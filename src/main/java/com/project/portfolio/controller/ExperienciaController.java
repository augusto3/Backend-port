package com.project.portfolio.controller;

import com.project.portfolio.dto.Mensaje;
import com.project.portfolio.dto.dtoExperiencia;
import com.project.portfolio.model.Experiencia;
import com.project.portfolio.interfaz.IExperienciaService;
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
@RequestMapping("/experiencia")
@CrossOrigin(origins={"https://portafolio-angular-543.web.app","https://portafolio-angular-543.firebaseapp.com"})
public class ExperienciaController {
    @Autowired
    private IExperienciaService expe;
    
    @GetMapping("/datos")
    @ResponseBody
    @CrossOrigin(origins={"https://portafolio-angular-543.web.app","https://portafolio-angular-543.firebaseapp.com"})
    public ResponseEntity<List<Experiencia>> get(){
        List<Experiencia> list = expe.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crear")
    @CrossOrigin(origins={"https://portafolio-angular-543.web.app","https://portafolio-angular-543.firebaseapp.com"})
    public ResponseEntity<?> Create(@RequestBody dtoExperiencia dtoexperiencia){
        if(StringUtils.isBlank(dtoexperiencia.getNombreEmpresa())){
            return new ResponseEntity(new Mensaje("El nombre de la empresa es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(expe.existsByNombre(dtoexperiencia.getNombreEmpresa())){
            return new ResponseEntity(new Mensaje("ya has trabajado en esta empresa actualiza el puesto de trabajo"), HttpStatus.BAD_REQUEST);
        }
        Experiencia experiencia = new Experiencia(dtoexperiencia.getNombreEmpresa(), dtoexperiencia.getPuestoTrabajo(),dtoexperiencia.getFechaInicio(),dtoexperiencia.getFechaFin(), dtoexperiencia.getDescripcion());
        expe.save(experiencia);
        return new ResponseEntity(new Mensaje("experiencia ha sido creada"), HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/borrar/{id}")
    @CrossOrigin(origins={"https://portafolio-angular-543.web.app","https://portafolio-angular-543.firebaseapp.com"})
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!expe.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        expe.delete(id);
        return new ResponseEntity(new Mensaje("la experiencia ha sido eliminada"), HttpStatus.OK);
    } 
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/edit/{id}")
    @CrossOrigin(origins={"https://portafolio-angular-543.web.app","https://portafolio-angular-543.firebaseapp.com"})
    public ResponseEntity<?> edit(@PathVariable("id") int id, @RequestBody dtoExperiencia dtoexperiencia){
        if(!expe.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        if(expe.existsByNombre(dtoexperiencia.getNombreEmpresa()) && expe.getByNombre(dtoexperiencia.getNombreEmpresa()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoexperiencia.getNombreEmpresa())){
            return new ResponseEntity(new Mensaje("El nombre no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        Experiencia exp=expe.getOne(id).get();
        exp.setNombreEmpresa(dtoexperiencia.getNombreEmpresa());
        exp.setPuestoTrabajo(dtoexperiencia.getPuestoTrabajo());
        exp.setFechaInicio(dtoexperiencia.getFechaInicio());
        exp.setFechaFin(dtoexperiencia.getFechaFin());
        exp.setDescripcion(dtoexperiencia.getDescripcion());
        expe.save(exp);
        return new ResponseEntity(new Mensaje("experiencia actualizada"), HttpStatus.OK);
    }   
}
