package com.reservaservice.demo.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import com.reservaservice.demo.domain.Agendamento;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {}