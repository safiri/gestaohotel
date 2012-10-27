package com.jhotel.hotel;

import java.util.ArrayList;
import java.util.List;

import com.jhotel.util.DataUtil;

public class ListaDeReservas {

   private final List<Reserva> reservas;
   
   public ListaDeReservas() {
      this.reservas = new ArrayList<>();
   }

   public final boolean reservadoPara(DataUtil data) {
      for (final Reserva reserva : reservas) {
         if (reserva.getPeriodoDeData().estaDentro(data)) {
            return true;
         }
      }

      return false;
   }

   public final List<Reserva> getReservas() {
      return reservas;
   }

   public final boolean estaReservadoEm(final String dataInicial, final String dataFinal) {
      return false;
   }

   public void adicionar(Reserva reserva) {
      reservas.add(reserva);
   }

}
