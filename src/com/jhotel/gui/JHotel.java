package com.jhotel.gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import com.jhotel.hotel.Hotel;
import com.jhotel.hotel.Quarto;

public class JHotel implements JTela {

   private static final int NUM_MIN_QUARTO = 101;
   private static final int NUM_MAX_QUARTO = 110;

   private Hotel hotel;
   private JFrame jTela;
   private Grade grade;
   private JTable table_4;
   
   private enum SITUACAO_QUARTO {
      Disponivel, Ocupado
   };

   public static final void main(String[] args) {
      final JHotel telaPrincipal = new JHotel();
      telaPrincipal.mostraTela();
   }

   public JHotel() {
      criaHotel();
      criaQuartos();
      initialize();
      atualizaGrade();
   }

   public final void mostraTela() {
      jTela.setVisible(true);
   }

   public final void atualizaGrade() {
      grade.limpa();

      Quarto quarto;

      for (int i = NUM_MIN_QUARTO; i <= NUM_MAX_QUARTO; i++) {
         quarto = hotel.getQuartos().buscaQuartoPeloNumero(i);
         grade.adicionaLinha(String.valueOf(i), quarto.getSituacao(), quarto.getHospedePrincipal() == null ? ""
               : quarto.getHospedePrincipal().getNome());
      }
   }

   private final void criaQuartos() {
      for (int i = NUM_MIN_QUARTO; i <= NUM_MAX_QUARTO; i++) {
         hotel.getQuartos().adiciona(i);
      }
   }

   private final void criaHotel() {
      hotel = new Hotel("Premium Hotel");
   }

   private final void initialize() {
      jTela = new JFrame();
      jTela.setTitle("JHOTEL 1.0 - " + hotel.getNome());
      jTela.setBounds(100, 100, 395, 382);
      jTela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      jTela.getContentPane().setLayout(null);

      final JButton btnCheckin = new JButton("Check-In");
      btnCheckin.addActionListener(new ActionListener() {
         public final void actionPerformed(ActionEvent e) {
            try {
               final JTela checkIn = new JCheckIn(JHotel.this, getQuartoSelecionado(SITUACAO_QUARTO.Disponivel));
               checkIn.mostraTela();
            } catch (Exception ex) {
               Mensagem.atencao(ex.getMessage());
            }

         }
      });
      btnCheckin.setBounds(265, 11, 104, 23);
      jTela.getContentPane().add(btnCheckin);

      final JButton btnCheckout = new JButton("Check-Out");
      btnCheckout.addActionListener(new ActionListener() {
         public final void actionPerformed(ActionEvent e) {
            try {
               final JTela checkOut = new JCheckOut(JHotel.this, getQuartoSelecionado(SITUACAO_QUARTO.Ocupado));
               checkOut.mostraTela();
            } catch (Exception ex) {
               Mensagem.atencao(ex.getMessage());
            }
         }
      });
      btnCheckout.setBounds(265, 42, 104, 23);
      jTela.getContentPane().add(btnCheckout);

      final JButton btnReservas = new JButton("Reservas");
      btnReservas.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            try {
               final JTela reserva = new JReserva(JHotel.this, getQuartoSelecionado(SITUACAO_QUARTO.Ocupado));
               reserva.mostraTela();
            } catch (Exception ex) {
               Mensagem.atencao(ex.getMessage());
            }
         }
      });
      btnReservas.setBounds(265, 76, 104, 23);
      jTela.getContentPane().add(btnReservas);

      final JButton btnConsumo = new JButton("Consumo");
      btnConsumo.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            try {
               final JTela consumo = new JConsumo(JHotel.this, getQuartoSelecionado(SITUACAO_QUARTO.Ocupado));
               consumo.mostraTela();
            } catch (Exception ex) {
               Mensagem.atencao(ex.getMessage());
            }
         }
      });
      btnConsumo.setBounds(265, 110, 104, 23);
      jTela.getContentPane().add(btnConsumo);

      table_4 = new JTable(new DefaultTableModel(new String[][] {}, new String[] { "Numero do Quarto", "Status", "Hospede" }));
      table_4.setFillsViewportHeight(true);
      table_4.setBounds(163, 45, 373, 363);
      table_4.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
      table_4.setPreferredScrollableViewportSize(new Dimension(800, 400));
      grade = new Grade(table_4);

      final JScrollPane pane = new JScrollPane(table_4);
      pane.setBounds(10, 11, 246, 327);
      pane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
      jTela.getContentPane().add(pane);

      JPanel panel = new JPanel();
      pane.setColumnHeaderView(panel);
   }

   private final Quarto getQuartoSelecionado(SITUACAO_QUARTO situacao) throws Exception {
      if (grade.getNumeroDaLinha() < 0) {
         throw new Exception("Selecione um quarto");
      }

      final Quarto quarto = hotel.getQuartos().buscaQuartoPeloNumero(
            Integer.parseInt(grade.getValorEm(grade.getNumeroDaLinha(), 0)));

      switch (situacao) {
         case Disponivel:
            if (quarto.ocupado()) {
               throw new Exception("O quarto " + quarto.getNumero()
                     + " esta ocupado, favor escolher um quarto de situacao Disponivel");
            }
            break;

         case Ocupado:
            if (!quarto.ocupado()) {
               throw new Exception("O quarto " + quarto.getNumero()
                     + " esta livre, favor escolher um quarto de situacao Ocupado");
            }
            break;
      }

      return quarto;
   }

}
