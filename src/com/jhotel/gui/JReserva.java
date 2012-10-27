package com.jhotel.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import com.jhotel.hotel.Quarto;

public class JReserva implements JTela {

   private final JHotel owner;
   private final Quarto quarto;
   JFrame jTela;
   private JTextField textField;
   private JTextField textField_1;
   private JTextField textField_2;
   private JTextField textField_3;
   private JTextField textField_4;
   private JTable table;
   private String apto;

   public JReserva(JHotel owner, Quarto quarto) throws ParseException {
      this.owner = owner;
      this.quarto = quarto;
      initialize();
   }

   public void mostraTela() {
      jTela.setVisible(true);
   }

   private void initialize() throws ParseException {
      jTela = new JFrame();
      jTela.addWindowListener(new WindowAdapter() {
         @Override
         public void windowClosed(WindowEvent arg0) {
            jTela.dispose();
         }
      });
      jTela.setResizable(false);
      jTela.setTitle("RESERVAS");
      jTela.setBounds(100, 100, 575, 292);
      jTela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      jTela.getContentPane().setLayout(null);

      JLabel lblNewLabel = new JLabel("Data de Entrada");
      lblNewLabel.setBounds(25, 23, 125, 14);
      jTela.getContentPane().add(lblNewLabel);

      JFormattedTextField formattedTextField = new JFormattedTextField();
      formattedTextField.setFont(new Font("Tahoma", Font.BOLD, 11));
      formattedTextField.setForeground(new Color(0, 51, 102));

      MaskFormatter maskData = new MaskFormatter("##/##/#### ##:##");
      maskData.install(formattedTextField);

      DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

      Date today = Calendar.getInstance().getTime();
      String reportDate = df.format(today);

      formattedTextField.setText(reportDate);
      formattedTextField.setBounds(131, 24, 138, 20);
      jTela.getContentPane().add(formattedTextField);

      JLabel lblNome = new JLabel("Nome");
      lblNome.setBounds(24, 55, 112, 14);
      jTela.getContentPane().add(lblNome);

      textField = new JTextField();
      textField.setBounds(131, 52, 306, 20);
      jTela.getContentPane().add(textField);
      textField.setColumns(10);

      JLabel lblCpf = new JLabel("CPF");
      lblCpf.setBounds(25, 86, 96, 14);
      jTela.getContentPane().add(lblCpf);

      textField_1 = new JTextField();
      textField_1.setBounds(131, 83, 154, 20);
      jTela.getContentPane().add(textField_1);
      textField_1.setColumns(10);

      JLabel lblRg = new JLabel("RG");
      lblRg.setBounds(307, 86, 27, 14);
      jTela.getContentPane().add(lblRg);

      textField_2 = new JTextField();
      textField_2.setBounds(334, 83, 119, 20);
      jTela.getContentPane().add(textField_2);
      textField_2.setColumns(10);

      JLabel lblEndereo = new JLabel("Endereço");
      lblEndereo.setBounds(25, 114, 96, 14);
      jTela.getContentPane().add(lblEndereo);

      textField_3 = new JTextField();
      textField_3.setBounds(131, 111, 273, 20);
      jTela.getContentPane().add(textField_3);
      textField_3.setColumns(10);

      JLabel lblTelefone = new JLabel("Telefone");
      lblTelefone.setBounds(25, 146, 125, 14);
      jTela.getContentPane().add(lblTelefone);

      textField_4 = new JTextField();
      textField_4.setBounds(131, 143, 131, 20);
      jTela.getContentPane().add(textField_4);
      textField_4.setColumns(10);

      JLabel lblValorDiria = new JLabel("Valor da Diária");
      lblValorDiria.setBounds(25, 174, 125, 14);
      jTela.getContentPane().add(lblValorDiria);

      JFormattedTextField formattedTextField_1 = new JFormattedTextField();
      formattedTextField_1.setBounds(131, 173, 97, 20);
      jTela.getContentPane().add(formattedTextField_1);

      table = new JTable();
      table.setBounds(74, 284, 138, -32);
      jTela.getContentPane().add(table);

      JLabel lblDataSadaPrevista = new JLabel("Data Saída Prevista");
      lblDataSadaPrevista.setBounds(279, 26, 112, 14);
      jTela.getContentPane().add(lblDataSadaPrevista);

      JFormattedTextField formattedTextField_2 = new JFormattedTextField();
      formattedTextField_2.setText("09/10/2012 21:55:44");
      formattedTextField_2.setForeground(new Color(0, 51, 102));
      formattedTextField_2.setFont(new Font("Tahoma", Font.BOLD, 11));
      formattedTextField_2.setBounds(401, 22, 138, 20);
      jTela.getContentPane().add(formattedTextField_2);

      JLabel lblNDoQuarto = new JLabel("Nº do Quarto");
      lblNDoQuarto.setBounds(317, 174, 87, 14);
      jTela.getContentPane().add(lblNDoQuarto);

      JTextField txtApto = new JTextField();
      txtApto.setText("TESTE");
      txtApto.setBounds(396, 171, 86, 20);
      jTela.getContentPane().add(txtApto);
      txtApto.setColumns(10);
      txtApto.setText(this.apto);

      JButton btnNewButton = new JButton("Confirmar");
      btnNewButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
            owner.atualizaGrade();
            jTela.dispose();
         }
      });
      btnNewButton.setBounds(265, 202, 160, 23);
      jTela.getContentPane().add(btnNewButton);

      JLabel lblQtdePessoas = new JLabel("Qtde pessoas");
      lblQtdePessoas.setBounds(25, 206, 125, 14);
      jTela.getContentPane().add(lblQtdePessoas);

      JFormattedTextField formattedTextField_3 = new JFormattedTextField();
      formattedTextField_3.setBounds(131, 205, 97, 20);
      jTela.getContentPane().add(formattedTextField_3);

   }

}
