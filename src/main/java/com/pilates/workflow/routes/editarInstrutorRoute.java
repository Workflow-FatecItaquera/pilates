package com.pilates.workflow.routes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.security.core.Authentication;

import com.pilates.workflow.model.Instrutor;
import com.pilates.workflow.service.InstrutorService;

@Controller

public class editarInstrutorRoute {

    @Autowired
    private InstrutorService instrutorService;

    @GetMapping("/editarInstrutor/{id}")
    public String editarInstrutor(@PathVariable String id, Model model, Authentication auth) {
        boolean isInstrutor = auth.getAuthorities().stream().anyMatch(a->a.getAuthority().equals("ROLE_INSTRUTOR"));
        
		if(!isInstrutor){
            return "redirect:/dashboard";
		}
        model.addAttribute("instrutor", instrutorService.getById(id));
        return "editarInstrutor";
    }

    @PostMapping("/update/instrutor")
    public String postMethodName(@ModelAttribute("instrutor") Instrutor instrutor) {
        instrutorService.update(instrutor);
        return "redirect:/perfil/"+instrutor.getId();
    }
}
