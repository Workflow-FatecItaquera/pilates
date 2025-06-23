package com.pilates.workflow.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pilates.workflow.model.Admin;
import com.pilates.workflow.service.AdminService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;
    PasswordEncoder encoder = new BCryptPasswordEncoder();

    @GetMapping("/list")
    public List<Admin> listar() {
        return adminService.getAll();
    }

    @PostMapping("/register")
    public Admin criar(@RequestBody Admin admin) {
        return adminService.register(admin);
    }

    @DeleteMapping("/delete/{id}")
    public String deletar(@PathVariable String id){
        adminService.delete(id);
        return "Admin deletado";
    }
    
    
}
