package com.jhotel.documento;

public final class CPF extends Documento {

   public CPF(final String numero) {
      super("CPF", numero);
   }

   /*private void validarCPF(String numero) throws CPFInvalidoException {
      // Valida CPF
      Pattern padrao = Pattern.compile("[0-9]{2,3}?\\.[0-9]{3}?\\.[0-9]{3}?\\-[0-9]{2}?");
      Matcher pesquisa = padrao.matcher(getNumero());

      if (pesquisa.matches()) {
         throw new CPFInvalidoException("CPF \"" + numero + "\" invalido!");
      }
   }*/

   @Override
   public final String getNumeroComMascara() {
      return getNumero().substring(0, 3) + "." +
             getNumero().substring(3, 6) + "." +
             getNumero().substring(6, 9) + "-" +
             getNumero().substring(9, 11);
   }

}
