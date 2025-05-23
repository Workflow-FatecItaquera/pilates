package com.pilates.workflow.routes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.pilates.workflow.service.AssinaturaService;
import com.pilates.workflow.model.Aluno;

@Controller
public class AlunoRoute {

	@Autowired
	private AssinaturaService assinaturaService;

	@GetMapping("/cadastrarAluno")
	public String cadastrarAluno(Model model) {
		model.addAttribute("aluno", new Aluno());
		model.addAttribute("assinaturas", assinaturaService.getAll());
		return "cadastrarAluno";
	}
	
}