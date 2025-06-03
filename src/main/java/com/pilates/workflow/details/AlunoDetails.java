package com.pilates.workflow.details;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.Collections;

import com.pilates.workflow.model.Aluno;

public class AlunoDetails implements UserDetails {

    private final Aluno aluno;

    public AlunoDetails(Aluno aluno) {
        this.aluno = aluno;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Aqui você pode retornar roles se precisar (ex: ROLE_ALUNO)
        return Collections.emptyList();
    }

    @Override
    public String getPassword() {
        return aluno.getSenha(); // senha criptografada
    }

    @Override
    public String getUsername() {
        return aluno.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Aluno getAluno() {
        return aluno;
    }
}