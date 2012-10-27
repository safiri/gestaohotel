package com.jhotel.hotel;

public final class Consumo {

   private String produto;
   private int quantidade;
   private double valor;

   public Consumo() {
      produto = "";
      quantidade = 0;
      valor = 0;
   }

   public final String getProduto() {
      return produto;
   }

   public final void setProduto(String produto) {
      this.produto = produto;
   }

   public final Integer getQuantidade() {
      return quantidade;
   }

   public final void setQuantidade(int quantidade) {
      this.quantidade = quantidade;
   }

   public final double getValor() {
      return valor;
   }

   public final void setValor(double valor) {
      this.valor = valor;
   }
   
}
