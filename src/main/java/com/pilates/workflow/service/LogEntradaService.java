package com.pilates.workflow.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pilates.workflow.model.LogEntrada;
import com.pilates.workflow.repository.LogEntradaRepository;

@Service
public class LogEntradaService {
	
	@Autowired
	LogEntradaRepository logEntradaRepository;
	
	public List<LogEntrada> getAll(){
		return logEntradaRepository.findAll();
	}
	
	public LogEntrada getById(String id) {
		return logEntradaRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Log com ID " + id + " não encontrado"));
	}
	
	public LogEntrada register(LogEntrada logEntrada) {
		return logEntradaRepository.save(logEntrada);
	}
	
	public void delete(String id) {
		logEntradaRepository.deleteById(id);
	}

}
