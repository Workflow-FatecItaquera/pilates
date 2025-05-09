package com.pilates.workflow.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pilates.workflow.model.Assinatura;
import com.pilates.workflow.repository.AssinaturaRepository;

@Service
public class AssinaturaService {
	
	@Autowired
	AssinaturaRepository assinaturaRepository;
	
	public List<Assinatura> getAll(){
		return assinaturaRepository.findAll();
	}
	
	public Assinatura getById(String id) {
		return assinaturaRepository.findById(id)
				.orElseThrow(()-> new EntityNotFoundException("Assinatura com ID '"+id+"' não foi encontrada.s"));
	}
	
	public Assinatura register(Assinatura assinatura) {
		return assinaturaRepository.save(assinatura);
	}
	
	public void delete(String id) {
		assinaturaRepository.deleteById(id);
	}

}
