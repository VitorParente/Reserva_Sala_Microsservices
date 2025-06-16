package com.reservaservice.demo.messaging;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.reservaservice.demo.config.RabbitConfig;

@Component
public class AgendamentoListener {

    @RabbitListener(queues = RabbitConfig.FILA_AGENDAMENTO)
    public void receberMensagem(String aviso) {
        System.out.println("Aviso recebido: " + aviso);
    }
}

