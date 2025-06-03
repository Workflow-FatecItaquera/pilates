package com.pilates.workflow.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.pilates.workflow.model.Instrutor;
import com.pilates.workflow.repository.InstrutorRepository;

@Service
public class InstrutorService {
	
	@Autowired
	InstrutorRepository instrutorRepository;
	PasswordEncoder encoder = new BCryptPasswordEncoder();
	
	public List<Instrutor> getAll(){
		return instrutorRepository.findAll();
	}
	
	public Instrutor getById(String id) {
	    return instrutorRepository.findById(id)
	        .orElseThrow(() -> new EntityNotFoundException("Instrutor com ID " + id + " não encontrado"));
	}

	public Instrutor getByEmail(String email){
		return instrutorRepository.findByEmail(email);
	}
	
	public Instrutor register(Instrutor instrutor) {
		if(instrutor.getSenha()!=null){
			instrutor.setSenha(encoder.encode(instrutor.getSenha()));
		}
		return instrutorRepository.save(instrutor);
	}
	
	public void delete(String id) {
		instrutorRepository.deleteById(id);
	}

	public boolean existsByEmail(String email){
		if(instrutorRepository.findByEmail(email)!=null){
			return true;
		} else {
			return false;
		}
	}

	public boolean login(String email, String senha){
		Instrutor instrutor = instrutorRepository.findByEmail(email);
		if(instrutor==null){
			return false;
		} else {
			return encoder.matches(senha, instrutor.getSenha());
		}
	}

}
