package com.pilates.workflow.routes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.security.core.Authentication;

import com.pilates.workflow.model.Aluno;
import com.pilates.workflow.service.AlunoService;
import com.pilates.workflow.service.AssinaturaService;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class editarAlunoRoute {

    @Autowired
    private AlunoService alunoService;
    @Autowired
    private AssinaturaService assinaturaService;

    @GetMapping("/editarAluno/{id}")
    public String editarAluno(@PathVariable String id, Model model, Authentication auth) {
        boolean isAluno = auth.getAuthorities().stream().anyMatch(a->a.getAuthority().equals("ROLE_ALUNO"));
        
		if(!isAluno){
            return "redirect:/dashboard";
		}
        model.addAttribute("assinaturas", assinaturaService.getAll());
        model.addAttribute("aluno", alunoService.getById(id));
        return "editarAluno";
    }

    @PostMapping("/update/aluno")
    public String postMethodName(@ModelAttribute("aluno") Aluno aluno) {
        alunoService.update(aluno);
        return "redirect:/perfil/"+aluno.getId();
    }
    

}
