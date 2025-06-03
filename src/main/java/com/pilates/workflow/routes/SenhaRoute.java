package com.pilates.workflow.routes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pilates.workflow.model.Aluno;
import com.pilates.workflow.service.AlunoService;
import com.pilates.workflow.service.TokenService;

@Controller
public class SenhaRoute {

    @Autowired
    private TokenService tokenService;
    @Autowired
    private AlunoService alunoService;

    @GetMapping("/alunoSenha")
    public String alunoSenha(@RequestParam("token") String token) {
        if(!tokenService.isTokenValid(token)){
            return "redirect:/";
        } else {
            return "alunoSenha";
        }
    }

    @PostMapping("/aluno/senha")
    public String criarSenha(@RequestParam("token") String token, @RequestParam("senha") String senha, RedirectAttributes redirectAttributes) {
        if(!tokenService.isTokenValid(token)){
            return "redirect:/";
        } else {
            String email = tokenService.extractEmail(token);
            Aluno aluno = alunoService.getByEmail(email);
            aluno.setSenha(senha);
            alunoService.register(aluno);

            redirectAttributes.addFlashAttribute("senhaCriada",true);
            return "redirect:/login";
        }
    }
    
    
}
