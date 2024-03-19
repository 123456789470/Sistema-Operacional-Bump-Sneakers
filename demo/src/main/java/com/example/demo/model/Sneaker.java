package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Sneaker { public String marca;
    public String modelo;
    public int tamanho;
    public double preco;
    public boolean disponibilidade;
    @Id
    private Long id;

    public Sneaker(String marca, String modelo, int tamanho, double preco) {
        this.marca = marca;
        this.modelo = modelo;
        this.tamanho = tamanho;
        this.preco = preco;
        this.disponibilidade = true;
    }

    public Sneaker() {

    }

    public boolean  verificarDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getTamanho() {
        return tamanho;
    }

    public double getPreco() {
        return preco;
    }

    public void exibirInformacoes() {
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Tamanho: " + tamanho);
        System.out.println("Preço: $" + preco);
        System.out.println("Disponibilidade: " + (disponibilidade ? "Disponível" : "Indisponível"));
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setMarca(String marca) {
    }

    public void setModelo(String modelo) {
    }

    public void setTamanho(int tamanho) {
    }

    public void setPreco(double preco) {
    }
}
