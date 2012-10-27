package com.jhotel.gui;

import javax.swing.JOptionPane;

public final class Mensagem {

   public static final void atencao(final String msg) {
      JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), msg);
   }

   public static final boolean confirma(final String msg) {
      return JOptionPane.showConfirmDialog(JOptionPane.getRootFrame(), msg, "Confirmacao", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION;
   }

}
