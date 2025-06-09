package com.pilates.workflow.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import com.pilates.workflow.service.LoginService;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AccessConfig {

    @Autowired
    private LoginService loginService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(
                    "/", // Homepage
                    // "/admin/**", 
                    "/assinaturas", // Assinaturas
                    "/api/**", // Rotas da API REST
                    "/cadastrarAluno", // Form de cadastro dos alunos
                    "/create/aluno", // Ação de cadastro do aluno
                    "/alunoSenha", // Para criar a senha de um aluno
                    "/aluno/senha",// Ação de criar a senha de um aluno
                    "/cadastrarInstrutor", // Form do cadastro de instrutores
                    "/create/instrutor", // Ação de cadastro do instrutor
                    "/instrutorSenha", // Para criar a senha de um instrutor
                    "/instrutor/senha",// Ação de criar a senha de um instrutor
                    "/login", // Tela de login
                    "/logar", // Ação do login
                    "/css/**", // Pasta do CSS
                    "/js/**", // Pasta do JS
                    "/images/**" // Pasta de imagens
                    ).permitAll()

                    .anyRequest().authenticated()
            )
            .formLogin(form -> form
                .loginPage("/login")
                .defaultSuccessUrl("/dashboard", true)
                .permitAll()
            )
            .logout(logout -> logout
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login?logout")
            )
            .sessionManagement(session -> session
                .maximumSessions(1)
                .maxSessionsPreventsLogin(false)
            );

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
            .userDetailsService(loginService)
            .passwordEncoder(passwordEncoder())
            .and()
            .build();
    }
}