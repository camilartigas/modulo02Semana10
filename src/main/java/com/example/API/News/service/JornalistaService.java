package com.example.API.News.service;

import com.example.API.News.model.Jornalista;
import com.example.API.News.repository.JornalistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JornalistaService {

    private final JornalistaRepository jornalistaRepository;

    @Autowired
    public JornalistaService(JornalistaRepository jornalistaRepository) {
        this.jornalistaRepository = jornalistaRepository;
    }

    public Jornalista encontrarJornalistaPorId(Long id) {
        return jornalistaRepository.findById(id).orElse(null);
    }

    public void salvarJornalista(Jornalista jornalista) {
        jornalistaRepository.save(jornalista);
    }

    public void deletarJornalista(Long id) {
        jornalistaRepository.deleteById(id);
    }

}