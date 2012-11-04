package com.jhotel.hotel;

import java.util.Arrays;
import java.util.List;

import com.jhotel.pessoa.PessoaFisica;
import com.jhotel.util.DataUtil;

public final class Quarto {

   private final Integer numero;
   private final ListaDeReservas reservas;
   private final ListaDeHospedagem hospedagens;

   public Quarto(int numero) {
      this.numero = numero;
      this.reservas = new ListaDeReservas();
      this.hospedagens = new ListaDeHospedagem();
   }

   public final Integer getNumero() {
      return this.numero;
   }

   public final Hospede getHospedePrincipal() {
      if (getHospedagemAtual() == null) {
         return null;
      }
      return getHospedagemAtual().getHospede();
   }

   public final List<PessoaFisica> getDependentes() {
      if (getHospedagemAtual() == null) {
         return null;
      }
      return getHospedagemAtual().getDependentes();
   }

   public final Hospedagem hospeda(final Hospede hospede,
         PessoaFisica... pessoaFisica) throws QuartoOcupadoException {
      if (ocupado()) {
         throw new QuartoOcupadoException(this);
      }
      Hospedagem hospedagem = new Hospedagem(hospede,
            Arrays.asList(pessoaFisica));
      hospedagens.adiciona(hospedagem);
      return hospedagem;
   }

   public final void novaHospedagem(Hospedagem hospedagem) {
      hospedagens.adiciona(hospedagem);
   }

   public void finalizaHospedagem() {
      hospedagens.finalizaUltimaHospedagem();
   }

   public final void reserva(final String nomeDoCliente,
         final DataUtil dataDaPrevisao) {
      final PessoaFisica pessoaFisica = new PessoaFisica("", nomeDoCliente);
      final Reserva reserva = new Reserva(this, pessoaFisica, dataDaPrevisao,
            dataDaPrevisao);
      reservas.adicionar(reserva);
   }

   public final boolean ocupado() {
      return getHospedePrincipal() != null;
   }

   public final boolean disponivel() {
      if (ocupado()) {
         return false;
      }

      if (reservas.reservadoPara(DataUtil.getDataHoje())) {
         return false;
      }

      return true;
   }

   public final String getSituacao() {
      return ocupado() ? "Ocupado" : "Disponivel";
   }

   public void novoConsumo(Consumo consumo) {
      if (getHospedagemAtual() == null) {
         return;
      }
      getHospedagemAtual().getConsumos().adiciona(consumo);
   }

   public ListaDeConsumo getConsumos() {
      if (getHospedagemAtual() == null) {
         return null;
      }

      return getHospedagemAtual().getConsumos();
   }

   public Hospedagem getHospedagemAtual() {
      return hospedagens.getHospedagemAtual();
   }

   @Override
   public final int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((numero == null) ? 0 : numero.hashCode());
      return result;
   }

   @Override
   public final boolean equals(Object obj) {
      if (this == obj) {
         return true;
      }
      if (obj == null) {
         return false;
      }
      if (getClass() != obj.getClass()) {
         return false;
      }
      final Quarto other = (Quarto) obj;
      if (numero == null) {
         if (other.numero != null) {
            return false;
         }
      } else if (!numero.equals(other.numero)) {
         return false;
      }
      return true;
   }

   @Override
   public final String toString() {
      return new StringBuilder("Quarto: ").append(getNumero()).append(" - ")
            .append(ocupado() ? getHospedePrincipal().toString() : "livre")
            .toString();
   }

}
