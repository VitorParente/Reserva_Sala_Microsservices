package com.reservaservice.demo.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    public static final String FILA_AGENDAMENTO = "filaAgendamento";
    public static final String TROCA_AGENDAMENTO = "trocaAgendamento";
    public static final String CHAVE_ROTEAMENTO = "agendamento.chave";

    @Bean
    public Queue filaAgendamento() {
        return new Queue(FILA_AGENDAMENTO);
    }

    @Bean
    public TopicExchange trocaAgendamento() {
        return new TopicExchange(TROCA_AGENDAMENTO);
    }

    @Bean
    public Binding bindingAgendamento(Queue filaAgendamento, TopicExchange trocaAgendamento) {
        return BindingBuilder.bind(filaAgendamento).to(trocaAgendamento).with(CHAVE_ROTEAMENTO);
    }
}

