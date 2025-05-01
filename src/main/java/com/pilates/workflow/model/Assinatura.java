package com.pilates.workflow.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Assinatura")
public class Assinatura {

	@Id
	private String id;
	private String nome;
	private double valor;
	private int duracao;
	private String descricao;
	private List<String> beneficios;
	
	public Assinatura() {}
	
	public Assinatura(String id, String nome, double valor, int duracao, String descricao, List<String> beneficios) {
		super();
		this.id = id;
		this.nome = nome;
		this.valor = valor;
		this.duracao = duracao;
		this.descricao = descricao;
		this.beneficios = beneficios;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<String> getBeneficios() {
		return beneficios;
	}

	public void setBeneficios(List<String> beneficios) {
		this.beneficios = beneficios;
	}
	
	
	
	
	
}
