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

import com.pilates.workflow.model.Aluno;
import com.pilates.workflow.service.AlunoService;

@RestController
@RequestMapping("/api")
public class AlunoController {
	
	@Autowired
	private AlunoService alunoService;

	@GetMapping("/alunos")
	public List<Aluno> getAllAlunos(){
		return alunoService.getAll();
	}
	
	@GetMapping("/aluno/{id}")
	public Aluno getById(@PathVariable String id) {
		return alunoService.getById(id);
	}

	@PostMapping("/aluno")
	public Aluno insertAluno(@RequestBody Aluno aluno){
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
