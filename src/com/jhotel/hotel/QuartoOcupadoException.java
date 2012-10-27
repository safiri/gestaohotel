package com.jhotel.hotel;

public class QuartoOcupadoException extends Exception {

   private static final long serialVersionUID = 1L;

   public QuartoOcupadoException(Quarto quarto) {
      super("Quarto " + quarto.getNumero() + " esta ocupado");
   }

}
