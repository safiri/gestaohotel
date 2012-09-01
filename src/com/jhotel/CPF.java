package com.jhotel;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CPF extends Documento {

   public CPF(String numero) {
      super("CPF", numero);
   }

   @Override
   public String getNumeroComMascara() {
      Pattern padrao = Pattern.compile("[0-9]{2,3}?\\.[0-9]{3}?\\.[0-9]{3}?\\-[0-9]{2}?");
      Matcher pesquisa = padrao.matcher(getNumero());

      if (pesquisa.matches()) {
         return getNumero();
      } else {
         return getNumero().substring(0, 3) + "." + getNumero().substring(3, 6) + "." + getNumero().substring(6, 9)
               + "-" + getNumero().substring(9, 11);
      }
   }

}
