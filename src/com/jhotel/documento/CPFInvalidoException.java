package com.jhotel.documento;

public final class CPFInvalidoException extends Exception {
   private static final long serialVersionUID = 1L;
   public CPFInvalidoException(final String erro) {
      super(erro);
   }
}
