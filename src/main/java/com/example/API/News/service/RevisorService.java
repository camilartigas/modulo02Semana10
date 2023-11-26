package com.example.API.News.service;

import com.example.API.News.model.Revisor;
import com.example.API.News.repository.RevisorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RevisorService {

    private final RevisorRepository revisorRepository;

    @Autowired
    public RevisorService(RevisorRepository revisorRepository) {
        this.revisorRepository = revisorRepository;
    }

    public Revisor encontrarRevisorPorId(Long id) {
        return revisorRepository.findById(id).orElse(null);
    }

    public void salvarRevisor(Revisor revisor) {
        revisorRepository.save(revisor);
    }

    public void deletarRevisor(Long id) {
        revisorRepository.deleteById(id);
    }

    // Outros métodos relacionados a operações com revisores, se necessário
}
