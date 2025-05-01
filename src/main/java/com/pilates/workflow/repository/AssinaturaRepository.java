package com.pilates.workflow.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pilates.workflow.model.Assinatura;

public interface AssinaturaRepository extends MongoRepository<Assinatura,String> {

}
