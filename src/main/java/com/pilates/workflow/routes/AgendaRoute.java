package com.pilates.workflow.routes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.pilates.workflow.details.AlunoDetails;
import com.pilates.workflow.details.InstrutorDetails;
import com.pilates.workflow.model.Aluno;
import com.pilates.workflow.model.EventoAgendado;
import com.pilates.workflow.model.Instrutor;
import com.pilates.workflow.service.EventoAgendadoService;
import com.pilates.workflow.service.InstrutorService;
import org.springframework.web.bind.annotation.PostMapping;


//import com.pilates.workflow.model.Aluno;

@Controller
public class AgendaRoute {

	@Autowired
	InstrutorService instrutorService;
	@Autowired
	EventoAgendadoService eventoService;

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

	@PostMapping("/create/aula")
	public String registrarAula(@ModelAttribute("evento") EventoAgendado evento) {
		eventoService.register(evento);
		return "redirect:/cadastrarAula";
	}

	@GetMapping("/verAulas")
	public String verAulas(Model model, Authentication auth){

		boolean isAluno = auth.getAuthorities().stream().anyMatch(a->a.getAuthority().equals("ROLE_ALUNO"));
		if(!isAluno){
			return "redirect:/dashboard";
		}
		AlunoDetails details = (AlunoDetails) auth.getPrincipal();
		Aluno aluno = details.getAluno();

		List<EventoAgendado> aulas = eventoService.getAll();
		for (EventoAgendado eventoAgendado : aulas) {
			eventoAgendado.setInstrutor(instrutorService.getById(eventoAgendado.getInstrutor().getId()));
		}
		List<EventoAgendado> suas = eventoService.getByAluno(aluno.getId());
		model.addAttribute("aulas", aulas);
		model.addAttribute("suas",suas);
		model.addAttribute("aluno", aluno);
		return "verAulas";
	}

	@GetMapping("/entrar/aula/{id}")
	public String entrarAula(@PathVariable("id") String id, Authentication auth){
		EventoAgendado evento = eventoService.getById(id);
		AlunoDetails details = (AlunoDetails) auth.getPrincipal();
		Aluno aluno = details.getAluno();
		if (evento.getAlunos() == null) {
			evento.setAlunos(new ArrayList<>());
		}

		// Verifica se o aluno já não está na lista (para evitar duplicação)
		if (!evento.getAlunos().contains(aluno)) {
			evento.getAlunos().add(aluno);
			eventoService.register(evento); // Salva de volta no banco
		}
		
		return "redirect:/verAulas";
	}

	@GetMapping("/sair/aula/{id}")
	public String sairAula(@PathVariable("id") String id, Authentication auth) {
		EventoAgendado evento = eventoService.getById(id);
		AlunoDetails details = (AlunoDetails) auth.getPrincipal();
		Aluno aluno = details.getAluno();

		if (evento.getAlunos() != null) {
			// Remove o aluno com base no ID
			evento.getAlunos().removeIf(a -> a.getId().equals(aluno.getId()));
			eventoService.register(evento);
		}

		return "redirect:/verAulas";
	}

	
}