package com.pilates.workflow.model;

public class PresencaEvento {

    private String data;
    private String descricao;

    // Construtor vazio (obrigatório para Jackson)
    public PresencaEvento() {}

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}