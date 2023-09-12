 package com.project.portfolio.controller;

import com.project.portfolio.dto.Mensaje;
import com.project.portfolio.dto.dtoProyectos;
import com.project.portfolio.model.Proyectos;
import com.project.portfolio.interfaz.IProyectosService;
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
@RequestMapping("/proyectos")
@CrossOrigin(origins={"https://portafolio-angular-543.web.app","https://portafolio-angular-543.firebaseapp.com","http://localhost:4200"})
public class ProyectosController {
    @Autowired
    private IProyectosService proyec;
    
    @GetMapping("/datos")
    @ResponseBody
    @CrossOrigin(origins={"https://portafolio-angular-543.web.app","https://portafolio-angular-543.firebaseapp.com","http://localhost:4200"})
    public ResponseEntity<List<Proyectos>> get(){
        List<Proyectos> list = proyec.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crear")
    @CrossOrigin(origins={"https://portafolio-angular-543.web.app","https://portafolio-angular-543.firebaseapp.com","http://localhost:4200"})
    public ResponseEntity<?> Create(@RequestBody dtoProyectos proy){
        if(StringUtils.isBlank(proy.getNameProyectos())){
            return new ResponseEntity(new Mensaje("El titulo es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(proyec.existsByNombre(proy.getNameProyectos())){
            return new ResponseEntity(new Mensaje("Ese titulo ya existe"), HttpStatus.BAD_REQUEST);
        }
        Proyectos proyecto = new Proyectos(proy.getNameProyectos(),proy.getDescripcion(),proy.getUrlProyectos());
        proyec.save(proyecto);
        return new ResponseEntity(new Mensaje("proyecto creado"), HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/borrar/{id}")
    @CrossOrigin(origins={"https://portafolio-angular-543.web.app","https://portafolio-angular-543.firebaseapp.com","http://localhost:4200"})
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!proyec.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        proyec.delete(id);
        return new ResponseEntity(new Mensaje("proyecto eliminado"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/edit/{id}")
    @CrossOrigin(origins={"https://portafolio-angular-543.web.app","https://portafolio-angular-543.firebaseapp.com","http://localhost:4200"})
    public ResponseEntity<?> edit(@PathVariable("id") int id, @RequestBody dtoProyectos dtoproyec){
        if(!proyec.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        if(proyec.existsByNombre(dtoproyec.getNameProyectos()) && proyec.getByNombre(dtoproyec.getNameProyectos()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Ese titulo ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoproyec.getNameProyectos())){
            return new ResponseEntity(new Mensaje("El titulo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        Proyectos proye=proyec.getOne(id).get();
        proye.setNameProyectos(dtoproyec.getNameProyectos());
        proye.setUrlProyectos(dtoproyec.getUrlProyectos());
        proye.setDescripcion(dtoproyec.getDescripcion());
        proyec.save(proye);
        return new ResponseEntity(new Mensaje("Proyecto actualizado"), HttpStatus.OK);
    }
}