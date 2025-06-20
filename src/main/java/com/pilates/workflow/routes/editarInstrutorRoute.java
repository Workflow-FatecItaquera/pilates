package com.pilates.workflow.routes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.pilates.workflow.service.InstrutorService;

@Controller

public class editarInstrutorRoute {

    @Autowired
    private InstrutorService instrutorService;

    @GetMapping("/editarInstrutor/{id}")
    public String editarInstrutor(@PathVariable String id, Model model) {
        model.addAttribute("instrutor", instrutorService.getById(id));
        return "editarInstrutor";
    }
}
