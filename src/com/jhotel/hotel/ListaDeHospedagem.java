package com.jhotel.hotel;

import java.util.ArrayList;
import java.util.List;

public final class ListaDeHospedagem {

   private final List<Hospedagem> lista;

   public ListaDeHospedagem() {
      lista = new ArrayList<>();
   }

   public void adiciona(Hospedagem hospedagem) {
      lista.add(hospedagem);
   }

   public final Hospedagem getHospedagemAtual() {
      if (lista.size() == 0) {
         return null;
      } else {
         return lista.get(lista.size() - 1);
      }
   }
}
