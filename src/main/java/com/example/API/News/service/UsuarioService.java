package com.example.API.News.service;

import com.example.API.News.model.Usuario;
import com.example.API.News.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository, BCryptPasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<Usuario> getAllUsers() {
        return usuarioRepository.findAll();
    }

    public Usuario getUserById(Long id) {
        Optional<Usuario> optionalUsuario = usuarioRepository.findById(id);
        return optionalUsuario.orElse(null);
    }

    public void createUser(Usuario usuario) {
        String senhaCriptografada = passwordEncoder.encode(usuario.getPassword());
        usuario.setPassword(senhaCriptografada);
        usuarioRepository.save(usuario);
    }

    public void updateUser(Long id, Usuario updatedUser) {
        Optional<Usuario> optionalUsuario = usuarioRepository.findById(id);
        if (optionalUsuario.isPresent()) {
            Usuario user = optionalUsuario.get();
            user.setUsername(updatedUser.getUsername());
            // Defina outros atributos conforme necessário
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

