package jhotel.com;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;


public class Jhotel{

	private JFrame frame;
	private JFrame frmCheckIn;	
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Jhotel window = new Jhotel();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Jhotel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()  {
		frame = new JFrame();
		frame.setBounds(100, 100, 633, 429);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnCheckin = new JButton("Check-In!");
		btnCheckin.setBounds(176, 159, 114, 25);
		btnCheckin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Checkin("284486943434");
			}
		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(btnCheckin);
		
		textField = new JTextField();
		textField.setBounds(91, 40, 161, 23);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(39, 44, 46, 14);
		frame.getContentPane().add(lblCpf);
		
		textField_1 = new JTextField();
		textField_1.setBounds(91, 11, 307, 23);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(39, 14, 46, 14);
		frame.getContentPane().add(lblNome);
		
		JButton btnFazerCheckout = new JButton("Check-out!");
		btnFazerCheckout.setBounds(292, 160, 107, 23);
		frame.getContentPane().add(btnFazerCheckout);
		
		textField_2 = new JTextField();
		textField_2.setBounds(91, 71, 86, 23);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblQuarto = new JLabel("Quarto:");
		lblQuarto.setBounds(26, 74, 46, 14);
		frame.getContentPane().add(lblQuarto);
		
		JButton btnReservaQuarto = new JButton("Reserva Quarto");
		btnReservaQuarto.setBounds(52, 160, 125, 23);
		frame.getContentPane().add(btnReservaQuarto);
	}
}
