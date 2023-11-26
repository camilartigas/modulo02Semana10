package com.example.API.News.repository;

import com.example.API.News.model.Noticia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NoticiaRepository extends JpaRepository<Noticia, Long> {
    Optional<Noticia> findById(Long id);
}

