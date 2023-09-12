package com.project.portfolio.controller;

import com.project.portfolio.dto.Mensaje;
import com.project.portfolio.dto.dtoCursos;
import com.project.portfolio.model.Cursos;
import com.project.portfolio.interfaz.ICursosService;
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
@RequestMapping("/cursos")
@CrossOrigin(origins={"https://portafolio-angular-543.web.app","https://portafolio-angular-543.firebaseapp.com"})
public class CursosController {
    @Autowired
    private ICursosService curso;

    @GetMapping("/datos")
    @ResponseBody
    @CrossOrigin(origins={"https://portafolio-angular-543.web.app","https://portafolio-angular-543.firebaseapp.com"})
    public ResponseEntity<List<Cursos>> list(){
        List<Cursos> list = curso.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crear")
    @CrossOrigin(origins={"https://portafolio-angular-543.web.app","https://portafolio-angular-543.firebaseapp.com"})
    public ResponseEntity<?> Create(@RequestBody dtoCursos dtocurso){
        if(StringUtils.isBlank(dtocurso.getNombreCurso())){
            return new ResponseEntity(new Mensaje("El nombre del curso es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(curso.existsByNombre(dtocurso.getNombreCurso())){
            return new ResponseEntity(new Mensaje("el nombre del curso ya existe"), HttpStatus.BAD_REQUEST);
        }
        Cursos Cursossave = new Cursos(dtocurso.getNombreCurso(), dtocurso.getUrlCurso(),dtocurso.getUrlCertificado());
        curso.save(Cursossave);
        return new ResponseEntity(new Mensaje("curso ha sido creada"), HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/borrar/{id}")
    @CrossOrigin(origins={"https://portafolio-angular-543.web.app","https://portafolio-angular-543.firebaseapp.com"})
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!curso.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        curso.delete(id);
        return new ResponseEntity(new Mensaje("el curso ha sido eliminada"), HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/edit/{id}")
    @CrossOrigin(origins={"https://portafolio-angular-543.web.app","https://portafolio-angular-543.firebaseapp.com"})
    public ResponseEntity<?> edit(@PathVariable("id") int id, @RequestBody dtoCursos dtocurso){
        if(!curso.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        if(curso.existsByNombre(dtocurso.getNombreCurso()) && curso.getByNombre(dtocurso.getNombreCurso()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Ese titulo de curso ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtocurso.getNombreCurso())){
            return new ResponseEntity(new Mensaje("El titulo del curso no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        Cursos cursos=curso.getOne(id).get();
        cursos.setNombreCurso(dtocurso.getNombreCurso());
        cursos.setUrlCurso(dtocurso.getUrlCurso());
        cursos.setUrlCertificado(dtocurso.getUrlCertificado());
        curso.save (cursos);
        return new ResponseEntity(new Mensaje("curso actualizado"), HttpStatus.OK);
    }
}