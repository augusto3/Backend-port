package com.project.portfolio.controller;

import com.project.portfolio.model.RedesSociales;
import com.project.portfolio.interfaz.IRedesSocialesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redes")
@CrossOrigin(origins={"https://portafolio-angular-543.web.app","https://portafolio-angular-543.firebaseapp.com"})
public class RedesSocialesController {
    @Autowired
    private IRedesSocialesService redes;
    
    @GetMapping("/datos")
    @ResponseBody
    @CrossOrigin(origins={"https://portafolio-angular-543.web.app","https://portafolio-angular-543.firebaseapp.com"})
    public ResponseEntity<List<RedesSociales>> getRedes(){
        List<RedesSociales> list = redes.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
}