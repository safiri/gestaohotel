package com.jhotel.hotel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.jhotel.pessoa.PessoaFisica;
import com.jhotel.util.DataUtil;

public final class ListaDeQuartos {

   private final Hotel hotel;
   private final Map<Integer, Quarto> quartos;

   public ListaDeQuartos(Hotel hotel) {
      this.hotel = hotel;
      this.quartos = new HashMap<>();
   }

   public final Quarto adiciona(final int numero) {
      final Quarto quarto = new Quarto(numero);
      quartos.put(numero, quarto);
      return quarto;
   }

   public Quarto hospeda(final Hospede hospede, final PessoaFisica... pessoaFisica) throws QuartosOcupadosException,
         QuartoOcupadoException {
      final Quarto quarto = buscaUmQuartoDisponivel();
      quarto.hospeda(hospede, pessoaFisica);
      return quarto;
   }

   public Quarto buscaUmQuartoDisponivel() throws QuartosOcupadosException {
      for (final Quarto quarto : quartos.values()) {
         if (quarto.disponivel()) {
            return quarto;
         }
      }
      throw new QuartosOcupadosException();
   }

   private final Quarto buscaUmQuartoDisponivel(final DataUtil dataDaPrevisao) throws QuartosOcupadosException {
      return buscaUmQuartoDisponivel();
   }

   public final List<Quarto> buscaQuartosDoHospede(final Hospede hospede) {
      final List<Quarto> listaDeQuartos = new ArrayList<>();

      for (final Quarto quarto : quartos.values()) {
         if (hospede.equals(quarto.getHospedePrincipal())) {
            listaDeQuartos.add(quarto);
         }
      }

      return listaDeQuartos;
   }

   public final Quarto buscaQuartoPeloNumero(final Integer numQuarto) {
      return quartos.get(numQuarto);
   }

   public final List<Quarto> getQuartosParaHospedagem() {
      return new ArrayList<>(quartos.values());
   }

   public final boolean isTodosQuartosVazios() {
      final Iterator<Quarto> listaDeQuartos = quartos.values().iterator();
      Quarto quarto;
      while (listaDeQuartos.hasNext()) {
         quarto = listaDeQuartos.next();
         if (quarto.ocupado()) {
            return false;
         }
      }
      return true;
   }

   public final boolean isTodosQuartosOcupados() {
      final Iterator<Quarto> listaDeQuartos = quartos.values().iterator();
      Quarto quarto;
      while (listaDeQuartos.hasNext()) {
         quarto = listaDeQuartos.next();
         if (!quarto.ocupado()) {
            return false;
         }
      }
      return true;
   }

   public void reserva(final String nomeDoCliente, final DataUtil dataDaPrevisao) throws QuartosOcupadosException {
      final Quarto quarto = buscaUmQuartoDisponivel(dataDaPrevisao);
      quarto.reserva(nomeDoCliente, dataDaPrevisao);
   }

   public final List<Quarto> lista() {
      final List<Quarto> quartos = new ArrayList<>();

      for (Quarto quarto : getQuartosParaHospedagem()) {
         quartos.add(quarto);
      }

      return quartos;
   }

   public Hotel getHotel() {
      return this.hotel;
   }

}
