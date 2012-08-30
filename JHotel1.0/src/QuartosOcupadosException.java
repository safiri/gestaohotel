package com.jhotel;

public class QuartosOcupadosException extends Exception {

   private static final long serialVersionUID = 6757054235745646669L;

   public QuartosOcupadosException() {
      super("Quartos Ocupados no Momento");
   }

}
