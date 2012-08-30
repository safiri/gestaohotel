package com.jhotel;

public class Quarto {

   private Integer numero;
   private Hospede hospede;

   public Quarto(Integer numero) {
      this.numero = numero;
      this.hospede = null;
   }

   public Integer getNumero() {
      return numero;
   }

   public Hospede getHospede() {
      return hospede;
   }

   public void setHospede(Hospede hospede) {
      this.hospede = hospede;
   }

   public boolean ocupado() {
      return getHospede() != null;
   }

   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((numero == null) ? 0 : numero.hashCode());
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
      Quarto other = (Quarto) obj;
      if (numero == null) {
         if (other.numero != null) {
            return false;
         }
      } else if (!numero.equals(other.numero)) {
         return false;
      }
      return true;
   }

   @Override
   public String toString() {
      return "Quarto (No. " + numero + ") - " + (ocupado() ? getHospede().toString() : "livre");
   }

}
