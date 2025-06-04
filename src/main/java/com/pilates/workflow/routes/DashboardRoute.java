package com.pilates.workflow.routes;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardRoute {
	
	@GetMapping("/dashboard")
	public String dashboard(Model model, Authentication auth) {

		boolean isAluno = auth.getAuthorities().stream().anyMatch(a->a.getAuthority().equals("ROLE_ALUNO"));
		boolean isInstrutor = auth.getAuthorities().stream().anyMatch(a->a.getAuthority().equals("ROLE_INSTRUTOR"));

		model.addAttribute("isAluno", isAluno);
		model.addAttribute("isInstrutor", isInstrutor);

		return "dashboard";
	}

}
