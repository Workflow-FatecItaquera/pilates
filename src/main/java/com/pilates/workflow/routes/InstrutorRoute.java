package com.pilates.workflow.routes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.pilates.workflow.model.Instrutor;
import com.pilates.workflow.service.EmailService;
import com.pilates.workflow.service.InstrutorService;
import com.pilates.workflow.service.TokenService;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class InstrutorRoute {

	@Autowired
	private TokenService tokenService;
	@Autowired
	private EmailService emailService;
	@Autowired
	private InstrutorService instrutorService;

	@GetMapping("/cadastrarInstrutor")
	public String cadastrarInstrutor(Model model, Authentication auth) {
		boolean isAdmin = auth.getAuthorities().stream().anyMatch(a->a.getAuthority().equals("ROLE_ADMIN"));
		if(!isAdmin){
			return "redirect:/dashboard";
		}
		model.addAttribute("instrutor", new Instrutor());
		return "cadastrarInstrutor";
	}

	@PostMapping("/create/instrutor")
	public String createInstrutor(@ModelAttribute("instrutor") Instrutor instrutor, RedirectAttributes redirectAttributes) {

		try {
			String token = tokenService.generatePasswordToken(instrutor.getEmail());
			Instrutor cadastrado = instrutorService.register(instrutor);
			emailService.criacaoSenha(cadastrado, token);
			
			redirectAttributes.addFlashAttribute("cadastroFeito",true);
			return "redirect:/login";
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("cadastroErrado",true);
			return "redirect:/cadastrarAluno";
		}

	}
	
	
}
