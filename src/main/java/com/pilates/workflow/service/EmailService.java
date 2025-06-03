package com.pilates.workflow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String remetente;

    public boolean criacaoSenha(String destinatario){
        try {
            SimpleMailMessage smm = new SimpleMailMessage();
            smm.setFrom(remetente);
            smm.setTo(destinatario);
            smm.setSubject("Crie a sua senha para completar seu cadastro!");
            smm.setText("Crie sua senha acessando https://pilates-s9q6.onrender.com/criarSenha");
            mailSender.send(smm);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
}
