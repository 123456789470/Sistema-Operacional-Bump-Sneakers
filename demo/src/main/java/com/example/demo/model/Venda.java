package com.example.demo.model;

import com.example.demo.model.Cliente;
import com.example.demo.model.Sneaker;
import jakarta.persistence.Entity;

class Venda {
    public Cliente cliente;
    public Sneaker sneaker;
    public String dataVenda;
    public double valorVenda;

    public Venda(Cliente cliente, Sneaker sneaker, double valorVenda) {
        this.cliente = cliente;
        this.sneaker = sneaker;
        this.dataVenda = java.time.LocalDate.now().toString();
        this.valorVenda = valorVenda;
    }

    public double calcularValorVenda() {
        return valorVenda;
    }
}