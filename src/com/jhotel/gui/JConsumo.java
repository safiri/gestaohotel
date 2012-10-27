package com.jhotel.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.text.MaskFormatter;

import com.jhotel.hotel.Consumo;
import com.jhotel.hotel.ListaDeConsumo;
import com.jhotel.hotel.Quarto;

public class JConsumo implements JTela {

   private final JHotel owner;
   private final Quarto quarto;
   private JFrame jTela;
   private Grade grade;
   private double total = 0;
   private JLabel lblTotalGeral;

   public JConsumo(JHotel owner, Quarto quarto) throws ParseException {
      this.owner = owner;
      this.quarto = quarto;
      initialize();
      carregaConsumos();
   }

   public void mostraTela() {
      jTela.setVisible(true);
   }

   private void carregaConsumos() {
      ListaDeConsumo consumos = quarto.getConsumos();
      Consumo consumo;

      grade.limpa();

      total = 0;

      for (int i = 0; i < consumos.getQuantidade(); i++) {
         consumo = consumos.getConsumo(i);
         grade.adicionaLinha(consumo.getProduto(), String.valueOf(consumo.getQuantidade()),
               String.valueOf(consumo.getValor()));
         total += consumo.getValor() * consumo.getQuantidade();
      }

      atualizaSoma();
   }

   private void initialize() throws ParseException {
      jTela = new JFrame();
      jTela.setTitle("CONSUMO");
      jTela.setBounds(100, 100, 653, 492);
      jTela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      jTela.getContentPane().setLayout(null);

      final JLabel lblNewLabel = new JLabel("Data");
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

      final JLabel lblNome = new JLabel("Descrição");
      lblNome.setBounds(24, 55, 112, 14);
      jTela.getContentPane().add(lblNome);

      final JLabel lblEndereo = new JLabel("Quantidade");
      lblEndereo.setBounds(25, 85, 96, 14);
      jTela.getContentPane().add(lblEndereo);

      final JLabel lblValorDiria = new JLabel("Valor  R$");
      lblValorDiria.setBounds(310, 55, 59, 14);
      jTela.getContentPane().add(lblValorDiria);

      final JFormattedTextField txtQuantidade = new JFormattedTextField();
      txtQuantidade.setText("0");
      txtQuantidade.setBounds(131, 82, 97, 20);
      jTela.getContentPane().add(txtQuantidade);

      final JLabel lblHspedesDoQuarto = new JLabel("Lista de Consumo");
      lblHspedesDoQuarto.setFont(new Font("Tahoma", Font.BOLD, 11));
      lblHspedesDoQuarto.setBounds(247, 117, 263, 14);
      jTela.getContentPane().add(lblHspedesDoQuarto);

      final JLabel lblNDoQuarto = new JLabel("Nº do Quarto");
      lblNDoQuarto.setBounds(289, 26, 87, 14);
      jTela.getContentPane().add(lblNDoQuarto);

      final JTextField txtApto = new JTextField();
      txtApto.setText("TESTE");
      txtApto.setBounds(368, 23, 86, 20);
      txtApto.setColumns(10);
      txtApto.setText(String.valueOf(this.quarto.getNumero()));
      jTela.getContentPane().add(txtApto);

      final JTable table_1 = Grade.cria("Produto", "Quantidade", "Valor");
      table_1.setFillsViewportHeight(true);
      table_1.setBounds(10, 250, 500, 150);
      table_1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
      table_1.getColumnModel().getColumn(0).setPreferredWidth(200);
      table_1.getColumnModel().getColumn(1).setPreferredWidth(200);
      table_1.getColumnModel().getColumn(2).setPreferredWidth(100);
      table_1.setPreferredScrollableViewportSize(new Dimension(700, 400));
      grade = new Grade(table_1);

      final JScrollPane pane = new JScrollPane(table_1);
      pane.setBounds(10, 142, 601, 258);
      pane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
      jTela.getContentPane().add(pane);

      final JPanel panel = new JPanel();
      pane.setColumnHeaderView(panel);

      final JButton btnConfirmar = new JButton("Confirmar");
      btnConfirmar.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {

            if (!Mensagem.confirma("Deseja atualizar o Consumo?")) {
               return;
            }

            Consumo consumo;

            for (int i = 0; i < grade.getQuantidadeDeLinhas(); i++) {
               consumo = new Consumo();
               consumo.setProduto(grade.getValorEm(i, 0));
               consumo.setQuantidade(Integer.parseInt(grade.getValorEm(i, 1)));
               consumo.setValor(Double.parseDouble(grade.getValorEm(i, 2)));
               quarto.novoConsumo(consumo);
            }
            owner.atualizaGrade();
            jTela.dispose();
         }
      });

      btnConfirmar.setBounds(451, 411, 160, 23);
      jTela.getContentPane().add(btnConfirmar);

      final JComboBox<String> comboBox = new JComboBox<String>();
      comboBox.setModel(new DefaultComboBoxModel<String>(new String[] { "coca-cola", "rufles", "guaraná", "cerveja",
            "água" }));
      comboBox.setBounds(131, 52, 169, 20);
      jTela.getContentPane().add(comboBox);

      final JTextField txtValor = new JTextField();
      txtValor.setText("0");
      txtValor.setColumns(10);
      txtValor.setBounds(368, 52, 86, 20);
      jTela.getContentPane().add(txtValor);

      final JLabel lblTotal = new JLabel("TOTAL ");
      lblTotal.setBounds(25, 415, 96, 14);
      jTela.getContentPane().add(lblTotal);

      lblTotalGeral = new JLabel("0");
      lblTotalGeral.setFont(new Font("Tahoma", Font.BOLD, 11));
      lblTotalGeral.setBounds(84, 415, 160, 14);
      jTela.getContentPane().add(lblTotalGeral);

      final JButton btnAdicionarConsumo = new JButton("Adicionar Consumo");
      btnAdicionarConsumo.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            grade.adicionaLinha(comboBox.getItemAt(comboBox.getSelectedIndex()), txtQuantidade.getText(),
                  txtValor.getText());
            total += Float.parseFloat(txtQuantidade.getText()) * Float.parseFloat(txtValor.getText());
            atualizaSoma();
         }
      });
      btnAdicionarConsumo.setBounds(276, 81, 160, 23);
      jTela.getContentPane().add(btnAdicionarConsumo);
   }

   private void atualizaSoma() {
      NumberFormat formatador = DecimalFormat.getCurrencyInstance(new Locale("pt", "BR"));
      formatador.setMinimumFractionDigits(2);
      lblTotalGeral.setText(formatador.format(total));
   }

}
