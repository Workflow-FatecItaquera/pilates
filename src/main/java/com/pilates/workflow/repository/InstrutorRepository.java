package com.pilates.workflow.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pilates.workflow.model.Instrutor;

public interface InstrutorRepository extends MongoRepository<Instrutor,String> {

}
