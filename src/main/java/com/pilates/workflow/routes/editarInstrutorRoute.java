package com.pilates.workflow.routes;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.pilates.workflow.service.InstrutorService;

@Controller
public class editarInstrutorRoute {

    private final InstrutorService instrutorService;

    public editarInstrutorRoute(InstrutorService instrutorService) {
        this.instrutorService = instrutorService;
    }

    @GetMapping("/editarInstrutor/{id}")
    public String editarInstrutor(@PathVariable String id, Model model) {
        var instrutor = instrutorService.getById(id); 
        model.addAttribute("instrutor", instrutor);
        return "editarInstrutor"; 
    }
}
