package com.example.API.News.controller;

import com.example.API.News.model.Noticia;
import com.example.API.News.service.NoticiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/noticias")
public class NoticiaController {
    private final NoticiaService noticiaService;

    @Autowired
    public NoticiaController(NoticiaService noticiaService) {
        this.noticiaService = noticiaService;
    }

    @GetMapping
    public List<Noticia> getAllNoticias() {
        return noticiaService.getAllNoticias();
    }

    @GetMapping("/{id}")
    public Noticia getNoticiaById(@PathVariable Long id) {
        return noticiaService.getNoticiaById(id);
    }

    @PostMapping
    public Noticia createNoticia(@RequestBody Noticia noticia) {
        return noticiaService.createNoticia(noticia);
    }

    @PutMapping("/{id}")
    public Noticia updateNoticia(@PathVariable Long id, @RequestBody Noticia updatedNoticia) {
        return noticiaService.updateNoticia(id, updatedNoticia);
    }

    @DeleteMapping("/{id}")
    public void deleteNoticia(@PathVariable Long id) {
        noticiaService.deleteNoticia(id);
    }
}

