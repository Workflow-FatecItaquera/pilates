package com.pilates.workflow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.pilates.workflow.model.Aluno;
import com.pilates.workflow.model.Instrutor;

@Service
public class EmailService {

    // private String url = "http://localhost:8080";
    private String url = "https://pilates-s9q6.onrender.com";

    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String remetente;

    public boolean criacaoSenha(Aluno aluno, String token){
        try {

            SimpleMailMessage smm = new SimpleMailMessage();
            smm.setFrom(remetente);
            smm.setTo(aluno.getEmail());
            smm.setSubject("Crie a sua senha para completar seu cadastro!");
            smm.setText("Crie sua senha acessando "+url+"/alunoSenha?token="+token);
            mailSender.send(smm);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean criacaoSenha(Instrutor instrutor, String token){
        try {

            SimpleMailMessage smm = new SimpleMailMessage();
            smm.setFrom(remetente);
            smm.setTo(instrutor.getEmail());
            smm.setSubject("Crie a sua senha para completar seu cadastro!");
            smm.setText("Crie sua senha acessando "+url+"/instrutorSenha?token="+token);
            mailSender.send(smm);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
}
