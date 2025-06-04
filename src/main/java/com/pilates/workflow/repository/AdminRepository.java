package com.pilates.workflow.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pilates.workflow.model.Admin;

public interface AdminRepository extends MongoRepository<Admin,String> {

    Admin findByEmail(String email);

}
