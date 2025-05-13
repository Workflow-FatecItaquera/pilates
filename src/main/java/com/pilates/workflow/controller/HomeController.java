package com.pilates.workflow.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
//Informa ao Spring que se trata de uma classe @Controller com requisições HTTP.
public class HomeController {
	@GetMapping("/")
	public String index() {
		return "index"; //Essa rota aqui vai renderizar a home em templates/index.html
	}
	
	public String assinaturas() {
		return "assinaturas"; //Vai renderizar os planos disponíveis.
	}
}
