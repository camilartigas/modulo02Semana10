package com.example.API.News.service;

import com.example.API.News.model.Noticia;
import com.example.API.News.repository.NoticiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoticiaService {

    private final NoticiaRepository noticiaRepository;

    @Autowired
    public NoticiaService(NoticiaRepository noticiaRepository) {
        this.noticiaRepository = noticiaRepository;
    }

    public Noticia encontrarNoticiaPorId(Long id) {
        return noticiaRepository.findById(id).orElse(null);
    }

    public void salvarNoticia(Noticia noticia) {
        noticiaRepository.save(noticia);
    }

    public void deletarNoticia(Long id) {
        noticiaRepository.deleteById(id);
    }


}
