package com.pilates.workflow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pilates.workflow.model.Instrutor;
import com.pilates.workflow.service.InstrutorService;

@RestController
public class InstrutorController {
	
	@Autowired
	private InstrutorService instrutorService;
	
	@GetMapping("/backend/instrutores")
	public List<Instrutor> getAllInstrutores(){
		return instrutorService.getAll();
	}
	
	@GetMapping("/backend/instrutor/{id}")
	public Instrutor getById(@PathVariable String id) {
		return instrutorService.getById(id);
	}
	
	@PostMapping("/backend/instrutor")
	public Instrutor createInstrutor(@RequestBody Instrutor instrutor) {
		return instrutorService.register(instrutor);
	}
	
	@PutMapping("/backend/instrutor")
	public Instrutor updateInstrutor(@RequestBody Instrutor instrutor) {
		return instrutorService.register(instrutor);
	}
	
	@DeleteMapping("/backend/instrutor/{id}")
	public String deleteInstrutor(@PathVariable String id) {
		instrutorService.delete(id);
		return "Instrutor removido com sucesso.";
	}

}
