package com.example.API.News.service;

import com.example.API.News.model.Usuario;
import com.example.API.News.repository.UsuarioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private static final Logger logger = LoggerFactory.getLogger(UsuarioService.class);


    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository, BCryptPasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<Usuario> getAllUsers() {
        logger.debug("Método 'getAllUsers' foi chamado.");
        return usuarioRepository.findAll();
    }

    public Usuario getUserById(Long id) {
        logger.debug("Método 'getUserById' foi chamado com o ID: {}", id);
        Optional<Usuario> optionalUsuario = usuarioRepository.findById(id);
        return optionalUsuario.orElse(null);
    }

    public void createUser(Usuario usuario) {
        logger.info("Criando um novo usuário: {}", usuario.getUsername());
        String senhaCriptografada = passwordEncoder.encode(usuario.getPassword());
        usuario.setPassword(senhaCriptografada);
        usuarioRepository.save(usuario);
        logger.info("Usuário criado com sucesso: {}", usuario.getId());
    }

    public void updateUser(Long id, Usuario updatedUser) {
        Optional<Usuario> optionalUsuario = usuarioRepository.findById(id);
        if (optionalUsuario.isPresent()) {
            Usuario user = optionalUsuario.get();
            user.setUsername(updatedUser.getUsername());
            usuarioRepository.save(user);
        }
    }

    public void deleteUser(Long id) {
        usuarioRepository.deleteById(id);
    }

    public Usuario encontrarUsuarioPorUsername(String username) {
        return usuarioRepository.findByUsername(username);
    }

    public boolean validarCredenciais(String username, String password) {
        Usuario usuario = encontrarUsuarioPorUsername(username);
        return usuario != null && passwordEncoder.matches(password, usuario.getPassword());
    }


}

