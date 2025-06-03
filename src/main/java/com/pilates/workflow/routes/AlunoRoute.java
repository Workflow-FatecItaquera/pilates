package com.pilates.workflow.routes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pilates.workflow.service.AssinaturaService;
import com.pilates.workflow.service.EmailService;
import com.pilates.workflow.service.AlunoService;
import com.pilates.workflow.service.TokenService;
import com.pilates.workflow.model.Aluno;

@Controller
public class AlunoRoute {

	@Autowired
	private AssinaturaService assinaturaService;
	@Autowired
	private AlunoService alunoService;
	@Autowired
	private EmailService emailService;
	@Autowired
	private TokenService tokenService;

	@GetMapping("/cadastrarAluno")
	public String cadastrarAluno(Model model) {
		model.addAttribute("aluno", new Aluno());
		model.addAttribute("assinaturas", assinaturaService.getAll());
		return "cadastrarAluno";
	}

	@PostMapping("/create/aluno")
	public String createAluno(@ModelAttribute("aluno") Aluno aluno, RedirectAttributes redirectAttributes) {
		try {
			String token = tokenService.generatePasswordToken(aluno.getEmail());
			Aluno cadastrado = alunoService.register(aluno);
			emailService.criacaoSenha(cadastrado, token);
			
			redirectAttributes.addFlashAttribute("cadastroFeito",true);
			return "redirect:/login";
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("cadastroErrado",true);
			return "redirect:/cadastrarAluno";
		}
	}
	
}