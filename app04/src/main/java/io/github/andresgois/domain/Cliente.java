package io.github.andresgois.domain;

public class Cliente {
	
	private String nome;
	private String sobreNome;
	private String idade;
	private String email;

	public Cliente(String nome, String sobreNome, String idade, String email) {
		this.nome = nome;
		this.sobreNome = sobreNome;
		this.idade = idade;
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobreNome() {
		return sobreNome;
	}

	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}

	public String getIdade() {
		return idade;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", sobreNome=" + sobreNome + ", idade=" + idade + ", email=" + email + "]";
	}
	
	
}
