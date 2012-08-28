package jhotel.com;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hotel {

	private Map<String, Cliente> clientes;
	private List<Funcionario> funcionarios;

	public Hotel() {
		clientes = new HashMap<String, Cliente>();
	}

	public void adicionarFuncionario(Funcionario funcionario) {
		funcionario.setHotel(this);
		funcionarios.add(funcionario);
	}

	public Cliente buscaHospedePeloCpf(String cpf) {
		Cliente hospede = clientes.get(cpf);
		return hospede;
	}
}