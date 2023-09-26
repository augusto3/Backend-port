package com.project.portfolio.controller;

import com.project.portfolio.dto.Mensaje;
import com.project.portfolio.dto.dtoSobreMi;
import com.project.portfolio.interfaz.ISobreMiService;
import com.project.portfolio.model.SobreMi;
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
@RequestMapping("/sobremi")
public class SobreMiController {
    @Autowired
    private ISobreMiService implSobreMi;

    @GetMapping("/datos")
    @ResponseBody
//    @CrossOrigin(origins={"https://portafolio-angular-543.web.app","https://portafolio-angular-543.firebaseapp.com","http://localhost:4200"})
    public ResponseEntity<List<SobreMi>> get(){
        List<SobreMi> list = implSobreMi.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crear")
//    @CrossOrigin(origins={"https://portafolio-angular-543.web.app","https://portafolio-angular-543.firebaseapp.com","http://localhost:4200"})
    public ResponseEntity<?> Create(@RequestBody dtoSobreMi sobre){
        if(StringUtils.isBlank(sobre.getNombre())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(implSobreMi.existsByNombre(sobre.getNombre())){
            return new ResponseEntity(new Mensaje("Esta persona ya existe"), HttpStatus.BAD_REQUEST);
        }
        SobreMi sobremi = new SobreMi(sobre.getNombre(), sobre.getEdad(), sobre.getDescripcion(),sobre.getUrlFoto());
        implSobreMi.save(sobremi);
        return new ResponseEntity(new Mensaje("la persona ha sido creada"), HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/borrar/{id}")
//    @CrossOrigin(origins={"https://portafolio-angular-543.web.app","https://portafolio-angular-543.firebaseapp.com","http://localhost:4200"})
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!implSobreMi.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        implSobreMi.delete(id);
        return new ResponseEntity(new Mensaje("la persona ha sido eliminada"), HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/edit/{id}")
//    @CrossOrigin(origins={"https://portafolio-angular-543.web.app","https://portafolio-angular-543.firebaseapp.com","http://localhost:4200"})
    public ResponseEntity<?> edit(@PathVariable("id") int id, @RequestBody dtoSobreMi dtosobre){
        if(!implSobreMi.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        if(implSobreMi.existsByNombre(dtosobre.getNombre()) && implSobreMi.getByNombre(dtosobre.getNombre()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtosobre.getNombre())){
            return new ResponseEntity(new Mensaje("El nombre no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        SobreMi sobre=implSobreMi.getOne(id).get();
        sobre.setNombre(dtosobre.getNombre());
        sobre.setEdad(dtosobre.getEdad());
        sobre.setDescripcion(dtosobre.getDescripcion());
        sobre.setUrlFoto(dtosobre.getUrlFoto());
        implSobreMi.save(sobre);
        return new ResponseEntity(new Mensaje("Persona actualizada"), HttpStatus.OK);
    }
}