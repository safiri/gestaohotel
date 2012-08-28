package jhotel.com;


public class Cliente extends Pessoa {

	private Quarto quarto;

	public Cliente(String cpf, String nome) {
		super(cpf, nome);
	}

	public Quarto getQuarto() {
		return quarto;
	}

	public void setQuarto(Quarto quarto) {
		this.quarto = quarto;
	}
}