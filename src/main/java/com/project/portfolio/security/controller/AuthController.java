package com.project.portfolio.security.controller;

import com.project.portfolio.security.dto.JwtDto;
import com.project.portfolio.security.dto.LoginUsuario;
import com.project.portfolio.security.dto.NuevoUsuario;
import com.project.portfolio.security.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    UsuarioService usuarioService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/nuevo")
//    @CrossOrigin(origins={"https://portafolio-angular-543.web.app","https://portafolio-angular-543.firebaseapp.com","http://localhost:4200"})
    public ResponseEntity<?> nuevo(@Valid @RequestBody NuevoUsuario nuevoUsuario){
        return usuarioService.save(nuevoUsuario);
    }    
    
    @PostMapping("/login")
//    @CrossOrigin(origins={"https://portafolio-angular-543.web.app","https://portafolio-angular-543.firebaseapp.com","http://localhost:4200"})
    public ResponseEntity<?> login(@Valid @RequestBody LoginUsuario loginUsuario){
        return usuarioService.login(loginUsuario);
    }
}
