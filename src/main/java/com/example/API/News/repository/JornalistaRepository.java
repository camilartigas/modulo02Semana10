package com.example.API.News.repository;

import com.example.API.News.model.Jornalista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JornalistaRepository extends JpaRepository<Jornalista, Long> {

}
