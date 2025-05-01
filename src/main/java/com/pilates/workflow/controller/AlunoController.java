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

import com.pilates.workflow.model.Aluno;
import com.pilates.workflow.service.AlunoService;

@RestController
public class AlunoController {
	
	@Autowired
	private AlunoService alunoService;
	
	@GetMapping("/alunos")
	public List<Aluno> getAllAlunos(){
		return alunoService.getAll();
	}
	
	@PostMapping("/aluno")
	public Aluno createAluno(@RequestBody Aluno aluno) {
		return alunoService.register(aluno);
	}
	
	@PutMapping("/aluno")
	public Aluno updateAluno(@RequestBody Aluno aluno) {
		return alunoService.register(aluno);
	}
	
	@DeleteMapping("/aluno/{id}")
	public String deleteAluno(@PathVariable String id) {
		alunoService.delete(id);
		return "Aluno removido com sucesso.";
	}

}
