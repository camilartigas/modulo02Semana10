package com.example.API.News.service;

import com.example.API.News.model.Revisor;
import com.example.API.News.repository.RevisorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RevisorService {

    private final RevisorRepository revisorRepository;

    @Autowired
    public RevisorService(RevisorRepository revisorRepository) {
        this.revisorRepository = revisorRepository;
    }

    public List<Revisor> getAllRevisores() {

        return revisorRepository.findAll();
    }

    public Revisor getRevisorById(Long id) {
        Optional<Revisor> optionalRevisor = revisorRepository.findById(id);
        return optionalRevisor.orElse(null);
    }

    public Revisor createRevisor(Revisor revisor) {
        return revisorRepository.save(revisor);
    }

    public Revisor updateRevisor(Long id, Revisor revisor) {
        Optional<Revisor> optionalRevisor = revisorRepository.findById(id);
        if (optionalRevisor.isPresent()) {
            Revisor existingRevisor = optionalRevisor.get();
            // Atualize os campos relevantes do revisor existente com base nos valores do revisor recebido
            // Exemplo: existingRevisor.setNome(revisor.getNome());
            // Atualize outros campos conforme necessário
            return revisorRepository.save(existingRevisor);
        }
        return null; // Ou lance uma exceção informando que o revisor não foi encontrado
    }

    public void deleteRevisor(Long id) {
        revisorRepository.deleteById(id);
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
}
