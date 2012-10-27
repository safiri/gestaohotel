package com.jhotel.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.text.MaskFormatter;

import com.jhotel.hotel.Quarto;

public class JCheckOut implements JTela {

   private final JHotel owner;
   private final Quarto quarto;
   JFrame jTela;
   private JTextField txtNome;
   private JTextField txtCPF;
   private JTextField txtRG;
   private JTextField txtEndereco;
   private JTextField txt_telefone;
   private JTable table;
   private JTable table_1;

   public JCheckOut(JHotel owner, Quarto quarto) throws ParseException {
      this.owner = owner;
      this.quarto = quarto;
      initialize();
   }

   public void mostraTela() {
      jTela.setVisible(true);
   }

   private void initialize() throws ParseException {
      jTela = new JFrame();
      jTela.setTitle("CHECK-OUT");
      jTela.setBounds(100, 100, 653, 492);
      jTela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      jTela.getContentPane().setLayout(null);

      final JLabel lblNewLabel = new JLabel("Data de Entrada");
      lblNewLabel.setBounds(25, 23, 125, 14);
      jTela.getContentPane().add(lblNewLabel);

      final JFormattedTextField txtEntrada = new JFormattedTextField();
      txtEntrada.setFont(new Font("Tahoma", Font.BOLD, 11));
      txtEntrada.setForeground(new Color(0, 51, 102));

      final MaskFormatter maskData = new MaskFormatter("##/##/#### ##:##");
      maskData.install(txtEntrada);

      final DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
      final Date today = Calendar.getInstance().getTime();
      final String reportDate = df.format(today);
      txtEntrada.setText(reportDate);

      txtEntrada.setBounds(131, 24, 138, 20);
      jTela.getContentPane().add(txtEntrada);

      final JLabel lblNome = new JLabel("Nome");
      lblNome.setBounds(24, 55, 112, 14);
      jTela.getContentPane().add(lblNome);

      txtNome = new JTextField();
      txtNome.setBounds(131, 52, 306, 20);
      jTela.getContentPane().add(txtNome);
      txtNome.setColumns(10);

      final JLabel lblCpf = new JLabel("CPF");
      lblCpf.setBounds(25, 86, 96, 14);
      jTela.getContentPane().add(lblCpf);

      txtCPF = new JTextField();
      txtCPF.setBounds(131, 83, 154, 20);
      jTela.getContentPane().add(txtCPF);
      txtCPF.setColumns(10);

      final JLabel lblRg = new JLabel("RG");
      lblRg.setBounds(307, 86, 27, 14);
      jTela.getContentPane().add(lblRg);

      txtRG = new JTextField();
      txtRG.setBounds(334, 83, 119, 20);
      jTela.getContentPane().add(txtRG);
      txtRG.setColumns(10);

      final JLabel lblEndereo = new JLabel("Endereço");
      lblEndereo.setBounds(25, 114, 96, 14);
      jTela.getContentPane().add(lblEndereo);

      txtEndereco = new JTextField();
      txtEndereco.setBounds(131, 111, 273, 20);
      jTela.getContentPane().add(txtEndereco);
      txtEndereco.setColumns(10);

      final JLabel lblTelefone = new JLabel("Telefone");
      lblTelefone.setBounds(25, 146, 125, 14);
      jTela.getContentPane().add(lblTelefone);

      txt_telefone = new JTextField();
      txt_telefone.setBounds(131, 143, 131, 20);
      jTela.getContentPane().add(txt_telefone);
      txt_telefone.setColumns(10);

      final JLabel lblValorDiria = new JLabel("Valor da Diária");
      lblValorDiria.setBounds(25, 174, 125, 14);
      jTela.getContentPane().add(lblValorDiria);

      final JFormattedTextField txtDiaria = new JFormattedTextField();
      txtDiaria.setBounds(131, 173, 97, 20);
      jTela.getContentPane().add(txtDiaria);

      table = new JTable();
      table.setBounds(74, 284, 138, -32);
      jTela.getContentPane().add(table);

      final JLabel lblHspedesDoQuarto = new JLabel("CONSUMO DO QUARTO");
      lblHspedesDoQuarto.setFont(new Font("Tahoma", Font.BOLD, 11));
      lblHspedesDoQuarto.setBounds(233, 218, 263, 14);
      jTela.getContentPane().add(lblHspedesDoQuarto);

      final JLabel lblDataSadaPrevista = new JLabel("Data Saída Prevista");
      lblDataSadaPrevista.setBounds(279, 26, 112, 14);
      jTela.getContentPane().add(lblDataSadaPrevista);

      final JFormattedTextField txtSaida = new JFormattedTextField();
      txtSaida.setText("09/10/2012 21:55:44");
      txtSaida.setForeground(new Color(0, 51, 102));
      txtSaida.setFont(new Font("Tahoma", Font.BOLD, 11));
      txtSaida.setBounds(401, 22, 138, 20);
      jTela.getContentPane().add(txtSaida);

      final JLabel lblNDoQuarto = new JLabel("Nº do Quarto");
      lblNDoQuarto.setBounds(317, 174, 87, 14);
      jTela.getContentPane().add(lblNDoQuarto);

      final JTextField txtApto = new JTextField();
      txtApto.setText("TESTE");
      txtApto.setBounds(396, 171, 86, 20);
      jTela.getContentPane().add(txtApto);
      txtApto.setColumns(10);
      txtApto.setText(this.quarto.getNumero().toString());

      table_1 = Grade.cria("Produto", "Quantidade", "Valor");
      table_1.setFillsViewportHeight(true);
      table_1.setBounds(10, 250, 500, 150);
      table_1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
      table_1.getColumnModel().getColumn(0).setPreferredWidth(200);
      table_1.getColumnModel().getColumn(1).setPreferredWidth(200);
      table_1.getColumnModel().getColumn(2).setPreferredWidth(100);
      table_1.setPreferredScrollableViewportSize(new Dimension(700, 400));

      final JScrollPane pane = new JScrollPane(table_1);
      pane.setBounds(10, 232, 601, 119);
      pane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
      jTela.getContentPane().add(pane);

      final JPanel panel = new JPanel();
      pane.setColumnHeaderView(panel);

      final JButton btnConfirmar = new JButton("Confirmar");
      btnConfirmar.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
            owner.atualizaGrade();
            jTela.dispose();
         }
      });
      btnConfirmar.setBounds(429, 408, 160, 23);
      jTela.getContentPane().add(btnConfirmar);

      final JLabel lblTotalDirias = new JLabel("TOTAL DIÁRIAS");
      lblTotalDirias.setBounds(75, 378, 104, 14);
      jTela.getContentPane().add(lblTotalDirias);

      final JLabel lblTotalConsumo = new JLabel("TOTAL CONSUMO");
      lblTotalConsumo.setBounds(75, 403, 104, 14);
      jTela.getContentPane().add(lblTotalConsumo);

      final JLabel lblTotalGeral = new JLabel("TOTAL GERAL");
      lblTotalGeral.setBounds(74, 429, 104, 14);
      jTela.getContentPane().add(lblTotalGeral);

      final JLabel lblR = new JLabel("R$");
      lblR.setBounds(182, 378, 125, 14);
      jTela.getContentPane().add(lblR);

      final JLabel label = new JLabel("R$");
      label.setBounds(182, 403, 125, 14);
      jTela.getContentPane().add(label);

      final JLabel label_1 = new JLabel("R$");
      label_1.setBounds(182, 429, 125, 14);
      jTela.getContentPane().add(label_1);
   }

}
