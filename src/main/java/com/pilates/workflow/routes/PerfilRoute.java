package com.pilates.workflow.routes;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.pilates.workflow.service.AlunoService;
import com.pilates.workflow.service.AssinaturaService;
import com.pilates.workflow.service.InstrutorService;

@Controller
public class PerfilRoute {

	@Autowired
	private AlunoService alunoService;

	@Autowired
	private InstrutorService instrutorService;
	@Autowired
	private AssinaturaService assinaturaService;

	@GetMapping("/perfil/{id}")
	public String perfil(@PathVariable String id, Model model) {
		Object perfil = null;
		String tipo = null;

		try {
			perfil = alunoService.getById(id);
			tipo = "Aluno";
		} catch (EntityNotFoundException e) {
			// Não achou aluno, beleza, tenta instrutor
			try {
				perfil = instrutorService.getById(id);
				tipo = "Instrutor";
			} catch (EntityNotFoundException ex) {
				// Não achou nada mesmo
				System.err.println("Perfil não encontrado: " + ex.getMessage());
				return "perfilNaoEncontrado";
			}
		}

		model.addAttribute("perfil", perfil);
		model.addAttribute("tipo", tipo);
		model.addAttribute("assinaturas", assinaturaService.getAll());

		return "perfil";
	}

}