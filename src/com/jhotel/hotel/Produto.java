package com.jhotel.hotel;

import java.math.BigDecimal;

public class Produto {

   private Integer codigo;
   private String descricao;
   private BigDecimal preco;
   private Integer quantidade;

   public Produto(Integer codigo, String descricao, BigDecimal preco, Integer quantidade) {
      this.descricao = descricao;
      this.codigo = codigo;
      this.preco = preco;
      this.quantidade = quantidade;
   }

   public Integer getCodigo() {
      return codigo;
   }

   public String getDescricao() {
      return descricao;
   }

   public BigDecimal getPreco() {
      return preco;
   }

   public Integer getQuantidade() {
      return quantidade;
   }

   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
      return result;
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj) {
         return true;
      }
      if (obj == null) {
         return false;
      }
      if (getClass() != obj.getClass()) {
         return false;
      }
      Produto other = (Produto) obj;
      if (codigo == null) {
         if (other.codigo != null) {
            return false;
         }
      } else if (!codigo.equals(other.codigo)) {
         return false;
      }
      return true;
   }

   @Override
   public String toString() {
      return "Produto [codigo=" + codigo + ", descricao=" + descricao + ", preco=" + preco + ", quantidade="
            + quantidade + "]";
   }

}
