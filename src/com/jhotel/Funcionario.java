package com.jhotel;

public abstract class Funcionario extends PessoaFisica {

   private Hotel hotel;

   public Funcionario(CPF cpf, String nome) {
      super(cpf, nome);
   }

   public void setHotel(Hotel hotel) {
      this.hotel = hotel;
   }

   public Hotel getHotel() {
      return hotel;
   }

   @Override
   public String toString() {
      return "Funcionario: " + super.toString();
   }
}