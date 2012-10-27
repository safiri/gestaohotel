package com.jhotel.hotel;

import java.math.BigDecimal;

public final class Produto {

   private final Integer codigo;
   private final String descricao;
   private final BigDecimal preco;
   private final Integer quantidade;

   public Produto(final Integer codigo, final String descricao, final BigDecimal preco, final Integer quantidade) {
      this.descricao = descricao;
      this.codigo = codigo;
      this.preco = preco;
      this.quantidade = quantidade;
   }

   public final Integer getCodigo() {
      return codigo;
   }

   public final String getDescricao() {
      return descricao;
   }

   public final BigDecimal getPreco() {
      return preco;
   }

   public final Integer getQuantidade() {
      return quantidade;
   }

   @Override
   public final int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
   public final String toString() {
      return "Produto [codigo=" + codigo + ", descricao=" + descricao + ", preco=" + preco + ", quantidade="
            + quantidade + "]";
   }

}
