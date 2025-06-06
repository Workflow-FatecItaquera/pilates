package com.pilates.workflow.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pilates.workflow.model.EventoAgendado;
import com.pilates.workflow.service.EventoAgendadoService;

@RestController
@RequestMapping("/api")
public class EventoAgendadoController {
	
	@Autowired
	private EventoAgendadoService eventoAgendadoService;
	
	@GetMapping("/eventos")
	public List<EventoAgendado> getAllEventos(){
		return eventoAgendadoService.getAll();
	}
	
	@GetMapping("/evento/{id}")
	public EventoAgendado getById(@PathVariable String id) {
		return eventoAgendadoService.getById(id);
	}
	
	@PostMapping("/evento")
	public EventoAgendado createEvento(@RequestBody EventoAgendado evento) {
		return eventoAgendadoService.register(evento);
	}
	
	@PutMapping("/evento")
	public EventoAgendado updateEvento(@RequestBody EventoAgendado evento) {
		return eventoAgendadoService.register(evento);
	}
	
	@DeleteMapping("/evento/{id}")
	public String deleteEvento(@PathVariable String id) {
		eventoAgendadoService.delete(id);
		return "Evento removido com sucesso.";
	}

}
