package com.pilates.workflow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pilates.workflow.details.AdminDetails;
import com.pilates.workflow.details.AlunoDetails;
import com.pilates.workflow.details.InstrutorDetails;

@Service
public class LoginService implements UserDetailsService {

    @Autowired
    private AdminService adminService;

    @Autowired
    private AlunoService alunoService;

    @Autowired
    private InstrutorService instrutorService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // Exemplo simplificado
        if (alunoService.existsByEmail(email)) {
            return new AlunoDetails(alunoService.getByEmail(email));
        } else if (instrutorService.existsByEmail(email)) {
            return new InstrutorDetails(instrutorService.getByEmail(email));
        } else if(adminService.existsByEmail(email)){
            return new AdminDetails(adminService.getByEmail(email));
        }

        throw new UsernameNotFoundException("Usuário não encontrado: " + email);
    }
}
