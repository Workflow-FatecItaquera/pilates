package com.pilates.workflow.model;

import java.util.List;

public class MetodoPagamento {
	
	private String tipo;
	private List<String> dados;
	
	public MetodoPagamento() {}
	
	public MetodoPagamento(String tipo, List<String> dados) {
		super();
		this.tipo = tipo;
		this.dados = dados;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<String> getDados() {
		return dados;
	}

	public void setDados(List<String> dados) {
		this.dados = dados;
	}
	
	

}
