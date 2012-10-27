package com.jhotel.hotel;

import java.util.ArrayList;
import java.util.List;

public class ListaDeConsumo {

   private final List<Consumo> lista;
   
   public ListaDeConsumo() {
      lista = new ArrayList<>();
   }

   public void adiciona(Consumo consumo) {
      lista.add(consumo);
   }

   public int getQuantidade() {
      return lista.size();
   }

   public Consumo getConsumo(int i) {
      return lista.get(i);
   }
}
