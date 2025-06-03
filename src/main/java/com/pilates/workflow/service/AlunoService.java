package com.pilates.workflow.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.pilates.workflow.model.Aluno;
import com.pilates.workflow.repository.AlunoRepository;

@Service
public class AlunoService {
	
	@Autowired
	AlunoRepository alunoRepository;
	PasswordEncoder encoder = new BCryptPasswordEncoder();
	
	public List<Aluno> getAll(){
		return alunoRepository.findAll();
	}
	
	public Aluno getById(String id) {
		return alunoRepository.findById(id)
				.orElseThrow(()-> new EntityNotFoundException("Aluno com ID '"+id+"' não foi encontrado."));
	}

	public Aluno getByEmail(String email){
		return alunoRepository.findByEmail(email);
	}

	public boolean login(String email, String senha){
		Aluno aluno = alunoRepository.findByEmail(email);
		if(aluno==null){
			return false;
		} else {
			return encoder.matches(senha, aluno.getSenha());
		}
	}
	
	public Aluno register(Aluno aluno) {
		if(aluno.getSenha()!=null){
			aluno.setSenha(encoder.encode(aluno.getSenha()));
		}
		return alunoRepository.save(aluno);
	}
	
	public void delete(String id) {
		alunoRepository.deleteById(id);
	}

}
