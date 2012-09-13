package com.jhotel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Estoque {

   Map<Integer, Produto> produtos;

   public Estoque() {
      produtos = new HashMap<>();
   }

   public void adiciona(Produto produto) {
      produtos.put(produto.getCodigo(), produto);
   }

   public List<Produto> listaDeProdutos() {
      List<Produto> lista = new ArrayList<>();
      
      for (Produto produto : produtos.values()) {
         lista.add(produto);
      }
      
      return lista;
   }

}
