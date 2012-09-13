package com.jhotel.documento;

public abstract class Documento {

   private String tipo;
   private String numero;

   public Documento(String tipo, String numero) {
      this.tipo = tipo;
      this.numero = numero;
   }

   public String getTipo() {
      return tipo;
   }

   public String getNumero() {
      return numero;
   }

   public abstract String getNumeroComMascara();

   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((numero == null) ? 0 : numero.hashCode());
      result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
      return result;
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj)
         return true;
      if (obj == null)
         return false;
      if (getClass() != obj.getClass())
         return false;
      Documento other = (Documento) obj;
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
   public String toString() {
      return getTipo() + ": " + getNumeroComMascara();
   }

}
