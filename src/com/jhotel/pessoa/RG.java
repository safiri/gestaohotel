package com.jhotel.pessoa;

import com.jhotel.documento.Documento;

public class RG extends Documento {

   public RG(final String numero) {
      super("CPF", numero);
   }

   @Override
   public final String getNumeroComMascara() {
      return getNumero();
   }

}
