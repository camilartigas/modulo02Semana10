package com.example.API.News.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Noticia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String textoNoticia;

    @ManyToOne
    private Revisor revisor;

    @ManyToOne
    private Jornalista jornalista;

    private Date dataCriacao;
    private Date dataAtualizacao;



    public Noticia() {
    }

    public Noticia(Long id, String titulo, String textoNoticia, Revisor revisor, Jornalista jornalista, Date dataCriacao, Date dataAtualizacao) {
        this.id = id;
        this.titulo = titulo;
        this.textoNoticia = textoNoticia;
        this.revisor = revisor;
        this.jornalista = jornalista;
        this.dataCriacao = dataCriacao;
        this.dataAtualizacao = dataAtualizacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTextoNoticia() {
        return textoNoticia;
    }

    public void setTextoNoticia(String textoNoticia) {
        this.textoNoticia = textoNoticia;
    }

    public Revisor getRevisor() {
        return revisor;
    }

    public void setRevisor(Revisor revisor) {
        this.revisor = revisor;
    }

    public Jornalista getJornalista() {
        return jornalista;
    }

    public void setJornalista(Jornalista jornalista) {
        this.jornalista = jornalista;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Date getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Date dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }
}
