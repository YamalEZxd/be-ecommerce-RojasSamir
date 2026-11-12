package com.example.ecommerce.controller;

import java.util.Map;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce.entity.Usuario;
import com.example.ecommerce.repository.UsuarioRepository;
import com.example.ecommerce.security.JwtUtil;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    public record AuthRequest(String username, String password) {}

    private final UsuarioRepository repo;
    private final PasswordEncoder encoder;
    private final AuthenticationManager authManager;
    private final JwtUtil jwtUtil;

    @PostMapping("/register")
    public Map<String, String> register(@RequestBody AuthRequest r) {
        Usuario u = new Usuario();
        u.setUsername(r.username());
        u.setPassword(encoder.encode(r.password()));
        repo.save(u);
        return Map.of("mensaje", "Usuario creado");
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody AuthRequest r) {
        authManager.authenticate(
            new UsernamePasswordAuthenticationToken(r.username(), r.password()));
        return Map.of("token", jwtUtil.generar(r.username()));
    }
}
