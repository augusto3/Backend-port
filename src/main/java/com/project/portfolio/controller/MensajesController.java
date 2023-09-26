package com.project.portfolio.controller;

import com.project.portfolio.dto.Mensaje;
import com.project.portfolio.dto.dtoMensaje;
import com.project.portfolio.interfaz.IMensajesService;
import com.project.portfolio.model.Mensajes;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mensajes")
public class MensajesController {
    @Autowired
    private IMensajesService msj;

    @PreAuthorize("hasRole('ADMIN')")    
    @GetMapping("/datos")
    @ResponseBody
//    @CrossOrigin(origins={"https://portafolio-angular-543.web.app","https://portafolio-angular-543.firebaseapp.com","http://localhost:4200"})
    public ResponseEntity<List<Mensajes>> get(){
        List<Mensajes> list = msj.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    @PostMapping("/crear")
//    @CrossOrigin(origins={"https://portafolio-angular-543.web.app","https://portafolio-angular-543.firebaseapp.com","http://localhost:4200"})
    public ResponseEntity<?> Create(@RequestBody dtoMensaje dtomensaje){
        Mensajes mensaje = new Mensajes (dtomensaje.getNombre(), dtomensaje.getApellido(),dtomensaje.getCelular(), dtomensaje.getEmail(),dtomensaje.getMensaje(),dtomensaje.getFecha());
        msj.save(mensaje);
        return new ResponseEntity(new Mensaje("mensaje enviado"), HttpStatus.OK);    
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/borrar/{id}")
//    @CrossOrigin(origins={"https://portafolio-angular-543.web.app","https://portafolio-angular-543.firebaseapp.com","http://localhost:4200"})
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!msj.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        msj.delete(id);
        return new ResponseEntity(new Mensaje("mensaje eliminada"), HttpStatus.OK);
    }
}