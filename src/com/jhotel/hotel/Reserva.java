package com.jhotel.hotel;

import com.jhotel.pessoa.PessoaFisica;
import com.jhotel.util.DataUtil;
import com.jhotel.util.PeriodoDeData;

public final class Reserva {

   private final Quarto quarto;
   private final PessoaFisica pessoaFisica;
   private final PeriodoDeData periodoDeData;

   public Reserva(final Quarto quarto, final PessoaFisica pessoaFisica, final DataUtil dataDeEntrada,
         final DataUtil dataDeSaida) {
      this.quarto = quarto;
      this.pessoaFisica = pessoaFisica;
      this.periodoDeData = new PeriodoDeData(dataDeEntrada, dataDeSaida);
   }

   public final Quarto getQuarto() {
      return quarto;
   }

   public final PessoaFisica getPessoaFisica() {
      return pessoaFisica;
   }

   public final PeriodoDeData getPeriodoDeData() {
      return periodoDeData;
   }

}
