package com.jhotel.hotel;

import java.util.ArrayList;
import java.util.List;

public final class ListaDeHospedagem {

   private final List<Hospedagem> lista;
   private boolean haHospedagem;

   public ListaDeHospedagem() {
      lista = new ArrayList<>();
      haHospedagem = false;
   }

   public void adiciona(Hospedagem hospedagem) {
      lista.add(hospedagem);
      haHospedagem = true;
   }
   
   public void finalizaUltimaHospedagem() {
      haHospedagem = false;
   }

   public final Hospedagem getHospedagemAtual() {
      if (!haHospedagem) {
         return null;
      }
      return lista.get(lista.size() - 1);
   }
}
