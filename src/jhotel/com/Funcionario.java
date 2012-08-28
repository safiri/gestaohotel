package jhotel.com;

public class Funcionario extends Pessoa {

	private Hotel hotel;

	public Funcionario(String cpf, String nome) {
		super(cpf, nome);
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;		
	}
	
	public Hotel getHotel() {
		return hotel;
	}
}
