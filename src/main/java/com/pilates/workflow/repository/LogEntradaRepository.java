package com.pilates.workflow.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pilates.workflow.model.LogEntrada;

public interface LogEntradaRepository extends MongoRepository<LogEntrada,String> {

}
