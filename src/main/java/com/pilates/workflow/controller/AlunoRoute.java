package com.pilates.workflow.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AlunoRoute {
	@GetMapping("/cadastrarAluno")
	public String cadastrarAluno() {
		return "cadastrarAluno";
	}
	
}
