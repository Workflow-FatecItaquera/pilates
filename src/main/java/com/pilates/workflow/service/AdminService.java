package com.pilates.workflow.service;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.pilates.workflow.model.Admin;
import com.pilates.workflow.repository.AdminRepository;

@Service
public class AdminService {

    @Autowired
    AdminRepository adminRepository;
    PasswordEncoder encoder = new BCryptPasswordEncoder();

    public Admin getById(String id) {
		return adminRepository.findById(id)
				.orElseThrow(()-> new EntityNotFoundException("Aluno com ID '"+id+"' não foi encontrado."));
	}

	public boolean existsByEmail(String email){
		if(adminRepository.findByEmail(email)!=null){
			return true;
		} else {
			return false;
		}
	}

	public Admin getByEmail(String email){
		return adminRepository.findByEmail(email);
	}

	public boolean login(String email, String senha){
		Admin admin = adminRepository.findByEmail(email);
		if(admin==null){
			return false;
		} else {
			return encoder.matches(senha, admin.getSenha());
		}
	}
	
	public Admin register(Admin admin) {
		if(admin.getSenha()!=null){
			admin.setSenha(encoder.encode(admin.getSenha()));
		}
		return adminRepository.save(admin);
	}
	
	public void delete(String id) {
		adminRepository.deleteById(id);
	}
    
}
