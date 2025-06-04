package com.pilates.workflow.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Admin")
public class Admin {

    @Id
    private String id;
    private String email;
    private String senha;

    public Admin(String id){
        this.id = id;
    }

    public Admin(String email, String senha){
        this.email = email;
        this.senha = senha;
    }

    public Admin(String id,String email, String senha){
        this.id = id;
        this.email = email;
        this.senha = senha;
    }

    public String getId(){
        return id;
    }

    public String getEmail(){
        return email;
    }

    public String getSenha(){
        return senha;
    }

    public void setId(String id){
        this.id = id;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setSenha(String senha){
        this.senha = senha;
    }
    
}
