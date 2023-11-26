package com.example.API.News.repository;

import com.example.API.News.model.Revisor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RevisorRepository extends JpaRepository<Revisor, Long> {

}
