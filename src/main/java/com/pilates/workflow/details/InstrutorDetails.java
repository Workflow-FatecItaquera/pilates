package com.pilates.workflow.details;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

import com.pilates.workflow.model.Instrutor;

public class InstrutorDetails implements UserDetails {

    private final Instrutor instrutor;

    public InstrutorDetails(Instrutor instrutor) {
        this.instrutor = instrutor;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Se você quiser adicionar uma role, como ROLE_INSTRUTOR:
        // return List.of(new SimpleGrantedAuthority("ROLE_INSTRUTOR"));
        return Collections.emptyList();
    }

    @Override
    public String getPassword() {
        return instrutor.getSenha(); // Senha criptografada (BCrypt)
    }

    @Override
    public String getUsername() {
        return instrutor.getEmail();
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

    public Instrutor getInstrutor() {
        return instrutor;
    }
}