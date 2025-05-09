package com.pilates.workflow.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pilates.workflow.model.EventoAgendado;
import com.pilates.workflow.repository.EventoAgendadoRepository;

@Service
public class EventoAgendadoService {
	
	@Autowired
	EventoAgendadoRepository eventoAgendadoRepository;
	
	public List<EventoAgendado> getAll(){
		return eventoAgendadoRepository.findAll();
	}
	
	public EventoAgendado getById(String id) {
		return eventoAgendadoRepository.findById(id)
		.orElseThrow(() -> new EntityNotFoundException("Evento com ID " + id + " não encontrado"));
	}
	
	public EventoAgendado register(EventoAgendado eventoAgendado) {
		return eventoAgendadoRepository.save(eventoAgendado);
	}
	
	public void delete(String id) {
		eventoAgendadoRepository.deleteById(id);
	}

}
