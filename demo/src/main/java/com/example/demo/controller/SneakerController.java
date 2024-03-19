package com.example.demo.controller;

import com.example.demo.model.Sneaker;
import com.example.demo.service.SneakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sneakers")
public class SneakerController {

    private final SneakerService sneakerService;

    @Autowired
    public SneakerController(SneakerService sneakerService) {
        this.sneakerService = sneakerService;
    }

    @GetMapping
    public List<Sneaker> listarTodos() {
        return sneakerService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sneaker> buscarPorId(@PathVariable Long id) {
        return sneakerService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Sneaker adicionarSneaker(@RequestBody Sneaker sneaker) {
        return sneakerService.adicionarSneaker(sneaker);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sneaker> atualizarSneaker(@PathVariable Long id, @RequestBody Sneaker sneaker) {
        try {
            Sneaker sneakerAtualizado = sneakerService.atualizarSneaker(id, sneaker);
            return ResponseEntity.ok(sneakerAtualizado);
        } catch (IllegalStateException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removerSneaker(@PathVariable Long id) {
        try {
            sneakerService.removerSneaker(id);
            return ResponseEntity.ok().build();
        } catch (IllegalStateException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
