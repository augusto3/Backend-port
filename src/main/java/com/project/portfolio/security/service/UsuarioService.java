package com.project.portfolio.security.service;

import com.project.portfolio.dto.Mensaje;
import com.project.portfolio.security.dto.JwtDto;
import com.project.portfolio.security.dto.LoginUsuario;
import com.project.portfolio.security.dto.NuevoUsuario;
import com.project.portfolio.security.entity.Rol;
import com.project.portfolio.security.entity.Usuario;
import com.project.portfolio.security.enums.RolNombre;
import com.project.portfolio.security.jwt.JwtProvider;
import com.project.portfolio.security.repository.UsuarioRepository;
import com.project.portfolio.security.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;

@Service
@Transactional
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    RolService rolService;

    @Autowired
    JwtProvider jwtProvider;

    public Optional<Usuario> getByNombreUsuario(String nombreUsuario){
        return usuarioRepository.findByNombreUsuario(nombreUsuario);
    }

    public Optional<Usuario> getByNombreUsuarioOrEmail(String nombreOrEmail){
        return usuarioRepository.findByNombreUsuarioOrEmail(nombreOrEmail, nombreOrEmail);
    }

    public Optional<Usuario> getByTokenPassword(String tokenPassword){
        return usuarioRepository.findByTokenPassword(tokenPassword);
    }

    public boolean existsByNombreUsuario(String nombreUsuario){
        return usuarioRepository.existsByNombreUsuario(nombreUsuario);
    }

    public boolean existsByEmail(String email){
        return usuarioRepository.existsByEmail(email);
    }

    public ResponseEntity<?> login(LoginUsuario loginUsuario){
        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUsuario.getNombreUsuario(), loginUsuario.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateToken(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());
        return new ResponseEntity(jwtDto, HttpStatus.OK);
    }
    public ResponseEntity<?> save(NuevoUsuario nuevoUsuario){
        if(usuarioRepository.existsByNombreUsuario(nuevoUsuario.getNombreUsuario())){
            return new ResponseEntity(new Mensaje("ese nombre de usuario ya existe"), HttpStatus.BAD_REQUEST);}
        if(usuarioRepository.existsByEmail(nuevoUsuario.getEmail())){
            return new ResponseEntity(new Mensaje( "ese email de usuario ya existe"),HttpStatus.BAD_REQUEST);}
        Usuario usuario = new Usuario(
            nuevoUsuario.getNombre(), nuevoUsuario.getNombreUsuario(), nuevoUsuario.getEmail(),
            passwordEncoder.encode(nuevoUsuario.getPassword()));
        if(!rolService.existsById(1)){
            rolService.saveAuto();}
        Set<Rol> roles = new HashSet<>();
        roles.add(rolService.getByRolNombre(RolNombre.ROLE_USER).get());
        if(nuevoUsuario.getRoles().contains("admin")){
            roles.add(rolService.getByRolNombre(RolNombre.ROLE_ADMIN).get());}
        usuario.setRoles(roles);
        usuarioRepository.save(usuario);
        return new ResponseEntity(new Mensaje(usuario.getNombreUsuario() + " ha sido creado"),HttpStatus.CREATED);
    }
}
