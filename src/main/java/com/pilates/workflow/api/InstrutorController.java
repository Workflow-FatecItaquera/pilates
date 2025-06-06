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

import com.pilates.workflow.model.Instrutor;
import com.pilates.workflow.service.InstrutorService;

@RestController
@RequestMapping("/api")
public class InstrutorController {
	
	@Autowired
	private InstrutorService instrutorService;
	
	@GetMapping("/instrutores")
	public List<Instrutor> getAllInstrutores(){
		return instrutorService.getAll();
	}
	
	@GetMapping("/instrutor/{id}")
	public Instrutor getById(@PathVariable String id) {
		return instrutorService.getById(id);
	}
	
	@PostMapping("/instrutor")
	public Instrutor createInstrutor(@RequestBody Instrutor instrutor) {
		return instrutorService.register(instrutor);
	}
	
	@PutMapping("/instrutor")
	public Instrutor updateInstrutor(@RequestBody Instrutor instrutor) {
		return instrutorService.register(instrutor);
	}
	
	@DeleteMapping("/instrutor/{id}")
	public String deleteInstrutor(@PathVariable String id) {
		instrutorService.delete(id);
		return "Instrutor removido com sucesso.";
	}

}
