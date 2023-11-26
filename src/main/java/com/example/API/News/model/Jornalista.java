package com.example.API.News.model;


import jakarta.persistence.*;

@Entity
public class Jornalista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Usuario usuario;

    private String nome;
    private double salario;
    private String nivelCargo;
    private int numeroPublicacoes;


    public Jornalista() {
    }

    public Jornalista(Long id, Usuario usuario, String nome, double salario, String nivelCargo, int numeroPublicacoes) {
        this.id = id;
        this.usuario = usuario;
        this.nome = nome;
        this.salario = salario;
        this.nivelCargo = nivelCargo;
        this.numeroPublicacoes = numeroPublicacoes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getNivelCargo() {
        return nivelCargo;
    }

    public void setNivelCargo(String nivelCargo) {
        this.nivelCargo = nivelCargo;
    }

    public int getNumeroPublicacoes() {
        return numeroPublicacoes;
    }

    public void setNumeroPublicacoes(int numeroPublicacoes) {
        this.numeroPublicacoes = numeroPublicacoes;
    }
}
