package com.pilates.workflow.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pilates.workflow.model.Aluno;

public interface AlunoRepository extends MongoRepository<Aluno, String> {

}
