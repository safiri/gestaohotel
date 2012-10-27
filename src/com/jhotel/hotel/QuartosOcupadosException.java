package com.jhotel.hotel;

public class QuartosOcupadosException extends Exception {

   private static final long serialVersionUID = 1;

   public QuartosOcupadosException() {
      super("Quartos Ocupados no Momento");
   }

}
