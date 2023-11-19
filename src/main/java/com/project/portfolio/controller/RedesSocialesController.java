package com.project.portfolio.controller;

import com.project.portfolio.dto.Mensaje;
import com.project.portfolio.dto.dtoRedes;
import com.project.portfolio.model.RedesSociales;
import com.project.portfolio.interfaz.IRedesSocialesService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/redes")
public class RedesSocialesController {
    @Autowired
    private IRedesSocialesService redes;
    
    @GetMapping("/datos")
    @ResponseBody
    @CrossOrigin(origins={"https://portafolio-angular-543.web.app","https://portafolio-angular-543.firebaseapp.com","http://localhost:4200"})
    public ResponseEntity<List<RedesSociales>> getRedes(){
        List<RedesSociales> list = redes.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    @PostMapping("/crear")
    @CrossOrigin(origins={"https://portafolio-angular-543.web.app","https://portafolio-angular-543.firebaseapp.com","http://localhost:4200"})
    public ResponseEntity<?> Create(@RequestBody dtoRedes dtoredes){
        if(StringUtils.isBlank(dtoredes.getFacebook())){
            return new ResponseEntity(new Mensaje("El titulo es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(redes.existsByFacebook(dtoredes.getFacebook())){
            return new ResponseEntity(new Mensaje("Ese titulo ya existe"), HttpStatus.BAD_REQUEST);
        }
        RedesSociales rede = new RedesSociales(dtoredes.getFacebook(),dtoredes.getInstagram() ,dtoredes.getLinkedin());
        redes.save(rede);
        return new ResponseEntity(new Mensaje("proyecto creado"), HttpStatus.OK);
    }
    @DeleteMapping("/borrar/{id}")
    @CrossOrigin(origins={"https://portafolio-angular-543.web.app","https://portafolio-angular-543.firebaseapp.com","http://localhost:4200"})
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!redes.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        redes.delete(id);
        return new ResponseEntity(new Mensaje("proyecto eliminado"), HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    @CrossOrigin(origins={"https://portafolio-angular-543.web.app","https://portafolio-angular-543.firebaseapp.com","http://localhost:4200"})
    public ResponseEntity<?> edit(@PathVariable("id") int id, @RequestBody dtoRedes dtoredes){
        if(!redes.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        if(redes.existsByFacebook(dtoredes.getFacebook()) && redes.getByFacebook(dtoredes.getFacebook()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Ese titulo ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoredes.getFacebook())){
            return new ResponseEntity(new Mensaje("El titulo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        RedesSociales rede=redes.getOne(id).get();
        rede.setFacebook(dtoredes.getFacebook());
        rede.setInstagram(dtoredes.getInstagram());
        rede.setLinkedin(dtoredes.getLinkedin());
        redes.save(rede);
        return new ResponseEntity(new Mensaje("Proyecto actualizado"), HttpStatus.OK);
    }
}