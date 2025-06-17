package com.pilates.workflow.routes;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.pilates.workflow.details.AlunoDetails;
import com.pilates.workflow.details.InstrutorDetails;
import com.pilates.workflow.model.Aluno;
import com.pilates.workflow.model.Instrutor;

@Controller
public class DashboardRoute {
	
	@GetMapping("/dashboard")
	public String dashboard(Model model, Authentication auth) {

		boolean isAluno = auth.getAuthorities().stream().anyMatch(a->a.getAuthority().equals("ROLE_ALUNO"));
		boolean isInstrutor = auth.getAuthorities().stream().anyMatch(a->a.getAuthority().equals("ROLE_INSTRUTOR"));

		model.addAttribute("isAluno", isAluno);
		if(isAluno){
			AlunoDetails details = (AlunoDetails) auth.getPrincipal();
			Aluno aluno = details.getAluno();
			model.addAttribute("aluno", aluno);
		}
		model.addAttribute("isInstrutor", isInstrutor);
		if(isInstrutor){
			InstrutorDetails details = (InstrutorDetails) auth.getPrincipal();
			Instrutor instrutor = details.getInstrutor();
			model.addAttribute("instrutor", instrutor);
		}

		return "dashboard";
	}

}
