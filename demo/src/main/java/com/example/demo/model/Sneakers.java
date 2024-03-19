package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Scanner;

@Entity
public class Sneakers {
    @Id
    private Long id;

    public static void main(String[] args) {
        Loja loja = new Loja();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Adicionar Sneaker");
            System.out.println("2. Adicionar Cliente");
            System.out.println("3. Realizar Venda");
            System.out.println("4. Verificar Compras de Cliente");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1:
                    System.out.print("Informe a marca do sneaker: ");
                    String marca = scanner.nextLine();
                    System.out.print("Informe o modelo do sneaker: ");
                    String modelo = scanner.nextLine();
                    System.out.print("Informe o tamanho do sneaker: ");
                    int tamanho = scanner.nextInt();
                    System.out.print("Informe o preço do sneaker: ");
                    double preco = scanner.nextDouble();
                    Sneaker sneaker = new Sneaker(marca, modelo, tamanho, preco);
                    loja.adicionarSneaker(sneaker);
                    break;
                case 2:
                    System.out.print("Informe o nome do cliente: ");
                    String nomeCliente = scanner.nextLine();
                    System.out.print("Informe o ID do cliente: ");
                    int idCliente = scanner.nextInt();
                    Cliente cliente = new Cliente(nomeCliente, idCliente);
                    loja.adicionarCliente(cliente);
                    break;
                case 3:
                    System.out.print("Informe o ID do cliente: ");
                    int idVenda = scanner.nextInt();
                    System.out.print("Informe o modelo do sneaker para venda: ");
                    scanner.nextLine(); // Consumir a quebra de linha
                    String modeloVenda = scanner.nextLine();

                    Cliente clienteVenda = null;
                    for (Cliente c : loja.getClientes()) {
                        if (c.getId() == idVenda) {
                            clienteVenda = c;
                            break;
                        }
                    }

                    Sneaker sneakerVenda = null;
                    for (Sneaker s : loja.getSneakersDisponiveis()) {
                        if (s.getModelo().equalsIgnoreCase(modeloVenda)) {
                            sneakerVenda = s;
                            break;
                        }
                    }

                    if (clienteVenda != null && sneakerVenda != null) {
                        loja.realizarVenda(clienteVenda, sneakerVenda);
                    } else {
                        System.out.println("Cliente ou sneaker não encontrado.");
                    }
                    break;
                case 4:
                    System.out.print("Informe o ID do cliente: ");
                    int idClienteVerificar = scanner.nextInt();
                    Cliente clienteVerificar = null;
                    for (Cliente c : loja.getClientes()) {
                        if (c.getId() == idClienteVerificar) {
                            clienteVerificar = c;
                            break;
                        }
                    }
                    if (clienteVerificar != null) {
                        clienteVerificar.verificarCompras();
                    } else {
                        System.out.println("Cliente não encontrado.");
                    }
                    break;
                case 5:
                    System.out.println("Saindo do programa.");
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
