package jhotel.com;

public class Pessoa {

	private String cpf;
	private String nome;

	public Pessoa(String cpf, String nome) {
		this.cpf = cpf;
		this.nome = nome;
	}
	
	public String getCpf() {
		return cpf;
	}

	public String getNome() {
		return nome;
	}
}
