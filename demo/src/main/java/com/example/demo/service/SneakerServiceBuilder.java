package com.example.demo.service;

import com.example.demo.repository.SneakerRepository;

public class SneakerServiceBuilder {
    private SneakerRepository sneakerRepository;

    public SneakerServiceBuilder setSneakerRepository(SneakerRepository sneakerRepository) {
        this.sneakerRepository = sneakerRepository;
        return this;
    }

    public SneakerService createSneakerService() {
        return SneakerService.createSneakerService(sneakerRepository);
    }
}