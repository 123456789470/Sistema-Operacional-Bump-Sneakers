package com.example.demo.repository;

import com.example.demo.model.Sneaker;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SneakerRepository {
    List<Sneaker> findAll();

    Optional<Sneaker> findById(Long id);

    Sneaker save(Sneaker sneaker);

    boolean existsById(Long id);

    void deleteById(Long id);
}
