package com.pilates.workflow.routes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.pilates.workflow.service.AlunoService;
import com.pilates.workflow.service.AssinaturaService;

@Controller
public class editarAlunoRoute {

    @Autowired
    private AlunoService alunoService;
    @Autowired
    private AssinaturaService assinaturaService;

    @GetMapping("/editarAluno/{id}")
    public String editarAluno(@PathVariable String id, Model model) {
        model.addAttribute("assinaturas", assinaturaService.getAll());
        model.addAttribute("aluno", alunoService.getById(id));
        return "editarAluno";
    }
}
