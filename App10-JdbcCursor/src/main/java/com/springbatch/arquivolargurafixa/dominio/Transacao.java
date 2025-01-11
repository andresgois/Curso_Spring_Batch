package com.springbatch.arquivolargurafixa.dominio;


public class Transacao {
	private String id;
	private String descricao;
	private double valor;

	public Transacao() {}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "Transacao{" +
				"descricao='" + descricao + '\'' +
				", id='" + id + '\'' +
				", valor=" + valor +
				'}';
	}
}
