package jhotel.com;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Checkin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;  //pra que serve isso?
	private JButton butao;	
	private JPanel painel;
	
	public Checkin(String cpf){
		
		
		painel=new JPanel();
		painel.setLayout(new FlowLayout());	
		butao=new JButton("NOVA");
		butao.addActionListener(new Sair());
		painel.add(butao);
		
		this.add(painel);
		this.setSize(300,200);
		this.setResizable(false);
		this.setVisible(true);			
		
		
		if ((ClienteTemReserva(cpf) == true) || (ClienteTemCadastro(cpf) == true)){
			ReservaQuarto(cpf);
		}else
		{
			CadastraCliente(cpf);
		}
	}
	
	private boolean ClienteTemCadastro(String cpf) {
		// TODO Auto-generated method stub
		return false;
	}

	private class Sair implements ActionListener{	
		@Override
		public void actionPerformed(ActionEvent e) {
			
			
			new Jhotel();
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


