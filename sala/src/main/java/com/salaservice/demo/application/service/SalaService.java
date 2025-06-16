package com.salaservice.demo.application.service;

import com.salaservice.demo.domain.model.Sala;
import com.salaservice.demo.infrastructure.repository.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaService {

    @Autowired
    private SalaRepository repositorioSala;

    public Sala registrarSala(Sala salaParaSalvar) {
        return repositorioSala.save(salaParaSalvar);
    }

    public List<Sala> listarSalas() {
        return repositorioSala.findAll();
    }
}
