package com.pilates.workflow.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pilates.workflow.model.EventoAgendado;

public interface EventoAgendadoRepository extends MongoRepository<EventoAgendado,String> {

}
