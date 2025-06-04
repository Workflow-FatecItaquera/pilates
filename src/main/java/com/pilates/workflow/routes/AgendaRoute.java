package com.pilates.workflow.routes;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//import com.pilates.workflow.model.Aluno;

@Controller
public class AgendaRoute {

	@GetMapping("/cadastrarAula")
	public String cadastrarAula(Model model, Authentication auth) {
		boolean isInstrutor = auth.getAuthorities().stream().anyMatch(a->a.getAuthority().equals("ROLE_INSTRUTOR"));

		if(!isInstrutor){
			return "redirect:/dashboard";
		}

		return "cadastrarAula";
	}
}