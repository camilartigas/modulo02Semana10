package com.example.API.News.service;

import com.example.API.News.model.Usuario;
import com.example.API.News.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository, BCryptPasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Usuario encontrarUsuarioPorUsername(String username) {
        return usuarioRepository.findByUsername(username);
    }

    public void salvarUsuario(Usuario usuario) {
        String senhaCriptografada = passwordEncoder.encode(usuario.getPassword());
        usuario.setPassword(senhaCriptografada);

        usuarioRepository.save(usuario);
    }

    public boolean validarCredenciais(String username, String password) {
        Usuario usuario = encontrarUsuarioPorUsername(username);
        if (usuario != null && passwordEncoder.matches(password, usuario.getPassword())) {
            // Senha correta, faça o login
            return true;
        } else {
            // Senha incorreta
            return false;
        }
    }
}

