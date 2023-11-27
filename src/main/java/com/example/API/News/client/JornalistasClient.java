package com.example.API.News.client;

import com.example.API.News.dto.JornalistaDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "JornalistasClient", url = "https://api.externa.com")
public interface JornalistasClient {

    @GetMapping("/jornalistas/freelancers")
    List<JornalistaDTO> getJornalistasFreelancers();
}
