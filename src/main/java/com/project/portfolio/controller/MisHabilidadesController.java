package com.project.portfolio.controller;

import com.project.portfolio.dto.Mensaje;
import com.project.portfolio.dto.dtoMisHabilidades;
import com.project.portfolio.interfaz.IMisHabilidadesService;
import com.project.portfolio.model.MisHabilidades;
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
@RequestMapping("/habilidades")
public class MisHabilidadesController {
    @Autowired
    private IMisHabilidadesService habil;

    @GetMapping("/datos")
    @ResponseBody
    @CrossOrigin(origins={"https://portafolio-angular-543.web.app","https://portafolio-angular-543.firebaseapp.com","http://localhost:4200"})
    public ResponseEntity<List<MisHabilidades>> get(){
        List<MisHabilidades> list = habil.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    @PostMapping("/crear")
    @CrossOrigin(origins={"https://portafolio-angular-543.web.app","https://portafolio-angular-543.firebaseapp.com","http://localhost:4200"})
    public ResponseEntity<?> Create(@RequestBody dtoMisHabilidades dtohabil){
        if(StringUtils.isBlank(dtohabil.getLenguaje())){
            return new ResponseEntity(new Mensaje("El lenguaje es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(habil.existsByLenguaje(dtohabil.getLenguaje())){
            return new ResponseEntity(new Mensaje("Ese lenguaje ya existe"), HttpStatus.BAD_REQUEST);
        }
        MisHabilidades mishabilidades = new MisHabilidades(dtohabil.getLenguaje(), dtohabil.getPorcentaje());
        habil.save(mishabilidades);
        return new ResponseEntity(new Mensaje("habilidad creada"), HttpStatus.OK);
    }

    @DeleteMapping("/borrar/{id}")
    @CrossOrigin(origins={"https://portafolio-angular-543.web.app","https://portafolio-angular-543.firebaseapp.com","http://localhost:4200"})
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!habil.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        habil.delete(id);
        return new ResponseEntity(new Mensaje("habilidad eliminada"), HttpStatus.OK);
    }
    @PutMapping("/edit/{id}")
    @CrossOrigin(origins={"https://portafolio-angular-543.web.app","https://portafolio-angular-543.firebaseapp.com","http://localhost:4200"})
    public ResponseEntity<?> edit(@PathVariable("id") int id, @RequestBody dtoMisHabilidades dtohabil){
        if(!habil.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        if(habil.existsByLenguaje(dtohabil.getLenguaje()) && habil.getByLenguaje(dtohabil.getLenguaje()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Ese lenguaje ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtohabil.getLenguaje())){
            return new ResponseEntity(new Mensaje("El lenguaje no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        MisHabilidades habi=habil.getOne(id).get();
        habi.setLenguaje(dtohabil.getLenguaje());
        habi.setPorcentaje(dtohabil.getPorcentaje());
        habil.save(habi);
        return new ResponseEntity(new Mensaje("habilidad actualizada"), HttpStatus.OK);
    }
}
