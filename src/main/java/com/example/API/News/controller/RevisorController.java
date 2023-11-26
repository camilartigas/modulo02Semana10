package com.example.API.News.controller;

import com.example.API.News.model.Revisor;
import com.example.API.News.service.RevisorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/revisores")
public class RevisorController {
    private final RevisorService revisorService;

    @Autowired
    public RevisorController(RevisorService revisorService) {
        this.revisorService = revisorService;
    }

    @GetMapping
    public List<Revisor> getAllRevisores() {
        return revisorService.getAllRevisores();
    }

    @GetMapping("/{id}")
    public Revisor getRevisorById(@PathVariable Long id) {
        return revisorService.getRevisorById(id);
    }

    @PostMapping
    public void createRevisor(@RequestBody Revisor revisor) {
        revisorService.createRevisor(revisor);
    }

    @PutMapping("/{id}")
    public void updateRevisor(@PathVariable Long id, @RequestBody Revisor revisor) {
        revisorService.updateRevisor(id, revisor);
    }

    @DeleteMapping("/{id}")
    public void deleteRevisor(@PathVariable Long id) {
        revisorService.deleteRevisor(id);
    }
}
