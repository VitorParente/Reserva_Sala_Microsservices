package com.reservaservice.demo.application.service;


import com.reservaservice.demo.domain.Agendamento;
import com.reservaservice.demo.infrastructure.AgendamentoRepository;
import com.reservaservice.demo.messaging.AgendamentoPublisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoRepository agendamentoRepo;

    @Autowired
    private AgendamentoPublisher agendamentoPublisher;

    public List<Agendamento> buscarTodos() {
        return agendamentoRepo.findAll();
    }

    public Agendamento salvar(Agendamento agendamento) {
        Agendamento salvo = agendamentoRepo.save(agendamento);
        String aviso = "Novo agendamento criado, código: " + salvo.getId();
        agendamentoPublisher.publicarMensagem(aviso);
        return salvo;
    }
}


