package com.jhotel.hotel;

public final class Hotel {

   private final String nome;
   private final ListaDeQuartos quartos;

   public Hotel(final String nome) {
      this.nome = nome;
      quartos = new ListaDeQuartos(this);
   }

   public final String getNome() {
      return nome;
   }

   public final ListaDeQuartos getQuartos() {
      return quartos;
   }

   public final boolean temReservaDe(final String string) {
      return false;
   }

}
