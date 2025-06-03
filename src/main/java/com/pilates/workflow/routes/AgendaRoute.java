package com.pilates.workflow.routes;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//import com.pilates.workflow.model.Aluno;

@Controller
public class AgendaRoute {

	@GetMapping("/cadastrarAula")
	public String cadastrarAula(Model model) {

		return "cadastrarAula";
	}
}