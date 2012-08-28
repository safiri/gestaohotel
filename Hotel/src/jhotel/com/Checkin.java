package jhotel.com;

public class Checkin {
   
	public Checkin(String cpf){
		if (ClienteTemReserva(cpf) == true){
			ReservaQuarto(cpf);
		}else
		{
			CadastraCliente(cpf);
		}
	}
	
	
  private void CadastraCliente(String cpf) {
	
		
	}


private boolean ClienteTemReserva(String cpf){
	return false;
    }

  private void ReservaQuarto(String cpf){
	  //
  }
  
  
}
