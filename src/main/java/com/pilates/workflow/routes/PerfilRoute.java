package com.pilates.workflow.routes;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PerfilRoute {
	@GetMapping("/perfil")
	public String cadastrarAluno() {
		return "perfil";
	}
	
}