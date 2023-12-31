package com.example.API.News.service;

import com.example.API.News.model.Jornalista;
import com.example.API.News.repository.JornalistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class JornalistaService {

    private final JornalistaRepository jornalistaRepository;
    private static final Logger LOGGER = Logger.getLogger(JornalistaService.class.getName());


    @Autowired
    public JornalistaService(JornalistaRepository jornalistaRepository) {
        this.jornalistaRepository = jornalistaRepository;
    }

    public List<Jornalista> getAllJornalistas() {
        LOGGER.log(Level.INFO, "Obtendo todos os jornalistas");
        return jornalistaRepository.findAll();
    }

    public Jornalista getJornalistaById(Long id) {
        Optional<Jornalista> optionalJornalista = jornalistaRepository.findById(id);
        return optionalJornalista.orElse(null);
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
