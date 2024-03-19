package com.example.demo.model;


import com.example.demo.model.Sneaker;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.ArrayList;

@Entity
public class Cliente {
    public String nome;
    @Id
    public int id;
    public ArrayList<Sneaker> sneakersComprados;

    public Cliente(String nome, int id) {
        this.nome = nome;
        this.id = id;
        this.sneakersComprados = new ArrayList<>();
    }

    public Cliente() {

    }

    public void comprarSneaker(Sneaker sneaker) {
        if (sneaker.verificarDisponibilidade()) {
            sneakersComprados.add(sneaker);
            sneaker.exibirInformacoes();
            sneaker.setDisponibilidade(false);
            System.out.println("Sneaker comprado com sucesso!");
        } else {
            System.out.println("Sneaker indisponível.");
        }
    }

    public void verificarCompras() {
        System.out.println("Sneakers comprados por " + nome + ":");
        for (Sneaker sneaker : sneakersComprados) {
            sneaker.exibirInformacoes();
        }
    }

    public void exibirInformacoes() {
        System.out.println("Nome: " + nome);
        System.out.println("ID: " + id);
    }

    public void setId(Long id) {
        this.id = Math.toIntExact(id);
    }

    public Long getId() {
        return (long) id;
    }
}