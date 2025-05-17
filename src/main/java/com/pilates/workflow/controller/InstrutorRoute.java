package com.pilates.workflow.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InstrutorRoute {

	@GetMapping("/cadastrarInstrutor")
	public String cadastrarInstrutor() {
		return "cadastrarInstrutor";
	}
	
}
