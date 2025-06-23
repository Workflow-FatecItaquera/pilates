package com.pilates.workflow.routes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.pilates.workflow.details.InstrutorDetails;
import com.pilates.workflow.model.EventoAgendado;
import com.pilates.workflow.model.Instrutor;
import com.pilates.workflow.service.InstrutorService;

//import com.pilates.workflow.model.Aluno;

@Controller
public class AgendaRoute {

	@Autowired
	InstrutorService instrutorService;

	@GetMapping("/cadastrarAula")
	public String cadastrarAula(Model model, Authentication auth) {
		boolean isInstrutor = auth.getAuthorities().stream().anyMatch(a->a.getAuthority().equals("ROLE_INSTRUTOR"));

		if(!isInstrutor){
			return "redirect:/dashboard";
		}
		InstrutorDetails details = (InstrutorDetails) auth.getPrincipal();
		Instrutor instrutor = details.getInstrutor();
		model.addAttribute("evento", new EventoAgendado());
		model.addAttribute("instrutores", instrutorService.getAll());
		model.addAttribute("instrutor", instrutor);
		return "cadastrarAula";
	}
}