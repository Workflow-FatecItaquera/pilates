package com.pilates.workflow.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pilates.workflow.model.Instrutor;
import com.pilates.workflow.repository.InstrutorRepository;

@Service
public class InstrutorService {
	
	@Autowired
	InstrutorRepository instrutorRepository;
	
	public List<Instrutor> getAll(){
		return instrutorRepository.findAll();
	}
	
	public Instrutor getById(String id) {
	    return instrutorRepository.findById(id)
	        .orElseThrow(() -> new EntityNotFoundException("Instrutor com ID " + id + " não encontrado"));
	}
	
	public Instrutor register(Instrutor instrutor) {
		return instrutorRepository.save(instrutor);
	}
	
	public void delete(String id) {
		instrutorRepository.deleteById(id);
	}

}
