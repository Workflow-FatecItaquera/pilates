package com.pilates.workflow.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pilates.workflow.model.EventoAgendado;

public interface EventoAgendadoRepository extends MongoRepository<EventoAgendado,String> {

    List<EventoAgendado> findByAlunosContaining(String alunoId);
    List<EventoAgendado> findByAlunos_Id(String alunoId);

}
