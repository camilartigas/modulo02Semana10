package com.example.API.News.service;

import com.example.API.News.model.Noticia;
import com.example.API.News.model.Revisor;
import com.example.API.News.repository.NoticiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoticiaService {

    private final NoticiaRepository noticiaRepository;

    @Autowired
    public NoticiaService(NoticiaRepository noticiaRepository) {
        this.noticiaRepository = noticiaRepository;
    }

    public List<Noticia> getAllNoticias() {
        return noticiaRepository.findAll();
    }

    public Noticia getNoticiaById(Long id) {
        Optional<Noticia> optionalNoticia = noticiaRepository.findById(id);
        return optionalNoticia.orElse(null);
    }

    public Noticia createNoticia(Noticia noticia) {
        return noticiaRepository.save(noticia);
    }

    public Noticia updateNoticia(Long id, Noticia updatedNoticia) {
        Optional<Noticia> optionalNoticia = noticiaRepository.findById(id);
        if (optionalNoticia.isPresent()) {
            Noticia noticia = optionalNoticia.get();
            // Atualize os campos relevantes da notícia existente com base nos valores da notícia recebida
            noticia.setTitulo(updatedNoticia.getTitulo());
            noticia.setTextoNoticia(updatedNoticia.getTextoNoticia());
            noticia.setRevisor(updatedNoticia.getRevisor());
            noticia.setJornalista(updatedNoticia.getJornalista());
            noticia.setDataAtualizacao(updatedNoticia.getDataAtualizacao());
            // Atualize outros campos conforme necessário
            return noticiaRepository.save(noticia);
        }
        return null; // Ou lance uma exceção informando que a notícia não foi encontrada
    }

    public void deleteNoticia(Long id) {
        noticiaRepository.deleteById(id);
    }
}
