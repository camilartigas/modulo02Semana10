package com.example.API.News.controller;

import com.example.API.News.model.Jornalista;
import com.example.API.News.service.JornalistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jornalistas")
public class JornalistaController {
    private final JornalistaService jornalistaService;

    @Autowired
    public JornalistaController(JornalistaService jornalistaService) {
        this.jornalistaService = jornalistaService;
    }

    @GetMapping
    public List<Jornalista> getAllJornalistas() {
        return jornalistaService.getAllJornalistas();
    }

    @GetMapping("/{id}")
    public Jornalista getJornalistaById(@PathVariable Long id) {
        return jornalistaService.getJornalistaById(id);
    }

    @PostMapping
    public void createJornalista(@RequestBody Jornalista jornalista) {
        jornalistaService.salvarJornalista(jornalista);
    }

    @PutMapping("/{id}")
    public void updateJornalista(@PathVariable Long id, @RequestBody Jornalista jornalista) {
        jornalista.setId(id); // Define o ID no objeto Jornalista
        jornalistaService.salvarJornalista(jornalista);
    }

    @DeleteMapping("/{id}")
    public void deleteJornalista(@PathVariable Long id) {
        jornalistaService.deletarJornalista(id);
    }
}

