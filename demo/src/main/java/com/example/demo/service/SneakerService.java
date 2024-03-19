package com.example.demo.service;

import com.example.demo.model.Sneaker;
import com.example.demo.repository.SneakerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SneakerService {

    private final SneakerRepository sneakerRepository;

    @Autowired
    private SneakerService(SneakerRepository sneakerRepository) {
        this.sneakerRepository = sneakerRepository;
    }

    public static SneakerService createSneakerService(SneakerRepository sneakerRepository) {
        return new SneakerService(sneakerRepository);
    }

    public List<Sneaker> listarTodos() {
        return sneakerRepository.findAll();
    }

    public Optional<Sneaker> buscarPorId(Long id) {
        return sneakerRepository.findById(id);
    }

    public Sneaker adicionarSneaker(Sneaker sneaker) {

        if (!sneaker.verificarDisponibilidade()) {
            throw new IllegalStateException("Sneaker não está disponível para adição.");
        }
        return sneakerRepository.save(sneaker);
    }

    public Sneaker atualizarSneaker(Long id, Sneaker sneakerAtualizado) {
        Sneaker sneaker = sneakerRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Sneaker com ID " + id + " não existe."));
        sneaker.setMarca(sneakerAtualizado.getMarca());
        sneaker.setModelo(sneakerAtualizado.getModelo());
        sneaker.setTamanho(sneakerAtualizado.getTamanho());
        sneaker.setPreco(sneakerAtualizado.getPreco());
        sneaker.setDisponibilidade(sneakerAtualizado.verificarDisponibilidade());
        return sneakerRepository.save(sneaker);
    }

    public void removerSneaker(Long id) {
        boolean existe = sneakerRepository.existsById(id);
        if (!existe) {
            throw new IllegalStateException("Sneaker com ID " + id + " não existe.");
        }
        sneakerRepository.deleteById(id);
    }


    public void realizarVenda(Long sneakerId, Long clienteId) {
        //  lógica de venda
    }


}
