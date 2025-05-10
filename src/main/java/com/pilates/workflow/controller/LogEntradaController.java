package com.pilates.workflow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pilates.workflow.model.LogEntrada;
import com.pilates.workflow.service.LogEntradaService;

@RestController
public class LogEntradaController {
	
	@Autowired
	private LogEntradaService logEntradaService;
	
	@GetMapping("/backend/logs")
	public List<LogEntrada> getAllLogs(){
		return logEntradaService.getAll();
	}
	
	@GetMapping("/backend/log/{id}")
	public LogEntrada getById(@PathVariable String id) {
		return logEntradaService.getById(id);
	}
	
	@PostMapping("/backend/log")
	public LogEntrada createAssinatura(@RequestBody LogEntrada log) {
		return logEntradaService.register(log);
	}
	
	@PutMapping("/backend/log")
	public LogEntrada updateAssinatura(@RequestBody LogEntrada log) {
		return logEntradaService.register(log);
	}
	
	@DeleteMapping("/backend/log/{id}")
	public String deleteAssinatura(@PathVariable String id) {
		logEntradaService.delete(id);
		return "Log removido com sucesso.";
	}

}
