package com.pilates.workflow.routes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.pilates.workflow.service.AssinaturaService;
import com.pilates.workflow.service.AlunoService;
import com.pilates.workflow.model.Aluno;

@Controller
public class AlunoRoute {

	@Autowired
	private AssinaturaService assinaturaService;
	private AlunoService alunoService;

	@GetMapping("/cadastrarAluno")
	public String cadastrarAluno(Model model) {
		model.addAttribute("aluno", new Aluno());
		model.addAttribute("assinaturas", assinaturaService.getAll());
		return "cadastrarAluno";
	}

	@PostMapping("/backend/aluno")
	public String createAluno(@ModelAttribute("aluno") Aluno aluno) {
		alunoService.register(aluno);
		return "redirect:/";
	}
	
}