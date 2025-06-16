package com.reservaservice.demo.messaging;


import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import com.reservaservice.demo.config.RabbitConfig;

@Component
public class AgendamentoPublisher {

    private final RabbitTemplate rabbitTemplate;

    public AgendamentoPublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void publicarMensagem(String aviso) {
        rabbitTemplate.convertAndSend(RabbitConfig.TROCA_AGENDAMENTO, RabbitConfig.CHAVE_ROTEAMENTO, aviso);
        System.out.println("Mensagem publicada: " + aviso);
    }
}
