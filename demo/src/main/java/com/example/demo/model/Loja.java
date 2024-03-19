package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Loja {
    private List<Sneaker> sneakersDisponiveis;
    private List<Cliente> clientes;
    private List<Venda> vendas;
    @Id
    private Long id;

    public Loja() {
        this.sneakersDisponiveis = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.vendas = new ArrayList<>();
    }

    public void adicionarSneaker(Sneaker sneaker) {
        sneakersDisponiveis.add(sneaker);
    }

    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void realizarVenda(Cliente cliente, Sneaker sneaker) {
        if (sneakersDisponiveis.contains(sneaker)) {
            double valorVenda = sneaker.getPreco();
            Venda venda = new Venda(cliente, sneaker, valorVenda);
            vendas.add(venda);
            cliente.comprarSneaker(sneaker);
            sneakersDisponiveis.remove(sneaker);
            System.out.println("Venda realizada com sucesso!");
        } else {
            System.out.println("Sneaker indisponível para venda.");
        }
    }

    public List<Sneaker> getSneakersDisponiveis() {
        return sneakersDisponiveis;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}