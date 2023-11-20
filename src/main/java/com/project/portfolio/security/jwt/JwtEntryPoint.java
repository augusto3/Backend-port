package com.project.portfolio.security.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.portfolio.dto.Mensaje;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Value;

@Component
public class JwtEntryPoint implements AuthenticationEntryPoint {

    @Value("${jwt.secret}")
    private String secret;

    private final static Logger logger = LoggerFactory.getLogger(JwtEntryPoint.class);
    @Override
    public void commence(HttpServletRequest req, HttpServletResponse res, AuthenticationException e) throws IOException, ServletException {
        res.sendError(HttpServletResponse.SC_UNAUTHORIZED, "no autorizado");
        Mensaje mensaje = new Mensaje("error:"+this.errorToken(req.getHeader("Authorization")));
        res.setContentType("application/json");
        res.setStatus(HttpStatus.UNAUTHORIZED.value());
        res.getWriter().write(new ObjectMapper().writeValueAsString(mensaje));
        res.getWriter().flush();
        res.getWriter().close();
    }
    public Mensaje errorToken(String token) {
    Mensaje mensaje;
    try {
        Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
        mensaje = new Mensaje("true");
    } catch (MalformedJwtException e) {
        mensaje=new Mensaje("token mal formado");
    } catch (UnsupportedJwtException e) {
        mensaje=new Mensaje("token no soportado");
    } catch (ExpiredJwtException e) {
        mensaje=new Mensaje("token expirado");
    } catch (IllegalArgumentException e) {
        mensaje=new Mensaje("token vacío");
    } catch (SignatureException e) {
        mensaje=new Mensaje("fail en la firma");
    }
    return mensaje;
    }
}
