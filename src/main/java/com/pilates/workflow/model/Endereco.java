package com.pilates.workflow.model;

public class Endereco {
	
	private String logradouro;
	private String cep;
	private int numero;
	private String estado;
	private String complemento;
	
	public Endereco() {}
	
	public Endereco(String logradouro, String cep, int numero, String estado, String complemento) {
		this.logradouro = logradouro;
		this.cep = cep;
		this.numero = numero;
		this.estado = estado;
		this.complemento = complemento;
	}
	
	public Endereco(String logradouro, String cep, int numero, String estado) {
		this.logradouro = logradouro;
		this.cep = cep;
		this.numero = numero;
		this.estado = estado;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

}
