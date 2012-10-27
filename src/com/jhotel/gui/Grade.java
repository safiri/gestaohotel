package com.jhotel.gui;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public final class Grade {

   private final JTable jTable;

   public Grade(JTable jTable) {
      this.jTable = jTable;
   }

   public final void limpa() {
      this.getTableModel().setRowCount(0);
   }

   public static JTable cria(String... colunas) {
      return new JTable(new DefaultTableModel(new String[][] {}, colunas));
   }

   public final void adicionaLinha(String... colunas) {
      this.getTableModel().addRow(colunas);
   }

   public final int getNumeroDaLinha() {
      return this.jTable.getSelectedRow();
   }

   private final DefaultTableModel getTableModel() {
      return (DefaultTableModel) jTable.getModel();
   }

   public final String getValorEm(int linha, int coluna) {
      return (String) this.jTable.getValueAt(linha, coluna);
   }

   public final int getQuantidadeDeLinhas() {
      return this.jTable.getRowCount();
   }

}
