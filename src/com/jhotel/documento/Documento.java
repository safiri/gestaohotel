package com.jhotel.documento;

public abstract class Documento {

   private final String tipo;
   private final String numero;

   public Documento(final String tipo, final String numero) {
      this.tipo = tipo;
      this.numero = numero;
   }

   public final String getTipo() {
      return tipo;
   }

   public final String getNumero() {
      return numero;
   }

   public abstract String getNumeroComMascara();

   @Override
   public final int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((numero == null) ? 0 : numero.hashCode());
      result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
      return result;
   }

   @Override
   public final boolean equals(Object obj) {
      if (this == obj)
         return true;
      if (obj == null)
         return false;
      if (getClass() != obj.getClass())
         return false;
      final Documento other = (Documento) obj;
      if (numero == null) {
         if (other.numero != null)
            return false;
      } else if (!numero.equals(other.numero))
         return false;
      if (tipo == null) {
         if (other.tipo != null)
            return false;
      } else if (!tipo.equals(other.tipo))
         return false;
      return true;
   }

   @Override
   public final String toString() {
      return getTipo() + ": " + getNumeroComMascara();
   }

}
