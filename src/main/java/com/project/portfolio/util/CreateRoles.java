package com.project.portfolio.util;

/**import com.project.portfolio.security.entity.Rol;
import com.project.portfolio.security.enums.RolNombre;
import com.project.portfolio.security.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CreateRoles implements CommandLineRunner {

    @Autowired
    RolService rolService;

    @Override
    public void run(String... args) throws Exception {
        Rol rolAdmin = new Rol(1,RolNombre.ROLE_ADMIN);
        Rol rolUser = new Rol(2,RolNombre.ROLE_USER);
        rolService.save(rolAdmin);
        rolService.save(rolUser);
    }
}**/