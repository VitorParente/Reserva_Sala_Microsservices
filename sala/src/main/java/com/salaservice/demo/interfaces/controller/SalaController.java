package com.salaservice.demo.interfaces.controller;

import com.salaservice.demo.application.service.SalaService;
import com.salaservice.demo.domain.model.Sala;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/salas")
public class SalaController {

    private final SalaService servicoSala;

    public SalaController(SalaService servicoSala) {
        this.servicoSala = servicoSala;
    }

    @PostMapping
    public Sala adicionarSala(@RequestBody Sala novaSala) {
        return servicoSala.registrarSala(novaSala);
    }

    @GetMapping
    public List<Sala> exibirSalas() {
        return servicoSala.listarSalas();
    }
}
