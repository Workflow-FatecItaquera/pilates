package com.pilates.workflow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.pilates.workflow.model.Aluno;

@Service
public class EmailService {

    private String local_url = "http://localhost:8080";
    private String site_url = "https://pilates-s9q6.onrender.com";

    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String remetente;

    public boolean criacaoSenhaAluno(Aluno aluno, String token){
        try {

            SimpleMailMessage smm = new SimpleMailMessage();
            smm.setFrom(remetente);
            smm.setTo(aluno.getEmail());
            smm.setSubject("Crie a sua senha para completar seu cadastro!");
            smm.setText("Crie sua senha acessando "+site_url+"/alunoSenha?token="+token);
            mailSender.send(smm);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
}
