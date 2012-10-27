package com.jhotel.hotel;

import com.jhotel.pessoa.PessoaFisica;

public final class Hospede extends PessoaFisica {

   public Hospede(final String cpf, final String nome) {
      super(cpf, nome);
   }

   @Override
   public final String toString() {
      return "Hospede: " + super.toString();
   }
}
