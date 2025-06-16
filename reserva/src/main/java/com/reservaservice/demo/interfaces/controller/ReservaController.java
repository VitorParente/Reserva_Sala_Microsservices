package com.reservaservice.demo.interfaces.controller;

import com.reservaservice.demo.application.service.AgendamentoService;
import com.reservaservice.demo.domain.Agendamento;
import com.reservaservice.demo.messaging.AgendamentoPublisher;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agendamentos")
public class ReservaController {

    private final AgendamentoService agendamentoService;
    private final AgendamentoPublisher agendamentoPublisher;

    public ReservaController(AgendamentoService agendamentoService, AgendamentoPublisher agendamentoPublisher) {
        this.agendamentoService = agendamentoService;
        this.agendamentoPublisher = agendamentoPublisher;
    }

    @GetMapping
    public List<Agendamento> buscarTodos() {
        return agendamentoService.buscarTodos();
    }

    @PostMapping
    public ResponseEntity<Agendamento> novo(@RequestBody Agendamento agendamento) {
        Agendamento novoAgendamento = agendamentoService.salvar(agendamento);

        try {
            String aviso = "Novo agendamento criado, código: " + novoAgendamento.getId();
            agendamentoPublisher.publicarMensagem(aviso);
        } catch (Exception ex) {
            System.err.println("Falha ao publicar mensagem no RabbitMQ: " + ex.getMessage());
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(novoAgendamento);
    }
}
