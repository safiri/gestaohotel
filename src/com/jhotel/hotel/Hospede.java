package com.jhotel.hotel;

import com.jhotel.documento.CPF;
import com.jhotel.pessoa.PessoaFisica;

public class Hospede extends PessoaFisica {

   private Quarto quarto;

   public Hospede(CPF cpf, String nome) {
      super(cpf, nome);
   }

   public Quarto getQuarto() {
      return quarto;
   }

   public void setQuarto(Quarto quarto) {
      this.quarto = quarto;
   }

   @Override
   public String toString() {
      return "Hospede: " + super.toString();
   }
}
