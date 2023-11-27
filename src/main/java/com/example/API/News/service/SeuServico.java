package com.example.API.News.service;

import com.example.API.News.client.JornalistasClient;
import com.example.API.News.dto.JornalistaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SeuServico {

    private final JornalistasClient jornalistasClient;

    @Autowired
    public SeuServico(JornalistasClient jornalistasClient) {
        this.jornalistasClient = jornalistasClient;
    }

    public List<JornalistaDTO> obterJornalistasFreelancers() {
        return jornalistasClient.getJornalistasFreelancers();
    }
}
