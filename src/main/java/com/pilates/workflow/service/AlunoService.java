package com.pilates.workflow.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pilates.workflow.model.Aluno;
import com.pilates.workflow.repository.AlunoRepository;

@Service
public class AlunoService {
	
	@Autowired
	AlunoRepository alunoRepository;
	
	public List<Aluno> getAll(){
		return alunoRepository.findAll();
	}
	
	public Aluno getById(String id) {
		return alunoRepository.findById(id)
				.orElseThrow(()-> new EntityNotFoundException("Aluno com ID '"+id+"' não foi encontrado."));
	}
	
	public Aluno register(Aluno aluno) {
		return alunoRepository.save(aluno);
	}
	
	public void delete(String id) {
		alunoRepository.deleteById(id);
	}

}
