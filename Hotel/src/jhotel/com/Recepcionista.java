package jhotel.com;

public class Recepcionista extends Funcionario {

	public Recepcionista(String cpf, String nome) {
		super(cpf, nome);
	}

	public void reserva(Cliente hospede, Quarto quarto) {
		hospede.setQuarto(quarto);
	}

	public Cliente buscaHospedePeloCpf(String cpf) {
		return getHotel().buscaHospedePeloCpf(cpf);
	}
	
	public Quarto procuraQuartoDisponivel() {
		return null;
	}
}