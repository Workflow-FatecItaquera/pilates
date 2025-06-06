package com.pilates.workflow.routes;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
//Informa ao Spring que se trata de uma classe @Controller com requisições HTTP.
public class HomeRoute {

	@GetMapping("/")
	public String index() {
		return "index"; //Essa rota aqui vai renderizar a home em templates/index.html
	}
	
	@GetMapping("/assinaturas")
	public String assinaturas() {
		return "redirect:/cadastrarAluno"; //Vai renderizar os planos disponíveis.
	}
}
