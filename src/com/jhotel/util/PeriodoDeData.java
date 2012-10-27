package com.jhotel.util;

public final class PeriodoDeData {

   private final DataUtil dataInicial;
   private final DataUtil dataFinal;

   public PeriodoDeData(final DataUtil dataInicial, final DataUtil dataFinal) {
      this.dataInicial = dataInicial;
      this.dataFinal = dataFinal;
   }

   public final String getDataInicial() {
      return dataInicial.toString();
   }

   public final String getDataFinal() {
      return dataFinal.toString();
   }

   public final boolean estaDentro(final DataUtil data) {
      return (data.apos(dataInicial) || data.equals(dataInicial)) &&
             (data.antes(dataFinal)  || data.equals(dataFinal));
   }

   public final boolean estaDentro(final DataUtil aDataInicial, final DataUtil aDataFinal) {
      return estaDentro(aDataInicial) || estaDentro(aDataFinal);
   }
}
