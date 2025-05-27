package com.pilates.workflow.routes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pilates.workflow.service.AlunoService;
import com.pilates.workflow.service.InstrutorService;

@Controller
public class LoginRoute {

	@Autowired
	private AlunoService alunoService;
	@Autowired
	private InstrutorService instrutorService;

	@GetMapping("/login")
	public String Login() {
		return "login";
	}

	@PostMapping("/logar")
	public String login(@RequestParam("email") String email, @RequestParam("senha") String senha){
		boolean alunoValid = alunoService.login(email,senha);
		boolean instrutorValid = instrutorService.login(email,senha);

		if(alunoValid){
			return "redirect:/dashboard";
		} else if(instrutorValid){
			return "redirect:/dashboard";
		}

		return "redirect:/login";
	}

}
