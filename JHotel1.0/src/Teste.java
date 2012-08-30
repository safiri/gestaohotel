package com.jhotel;

public class Teste {

   public static void main(String[] args) {
      Hotel premiumHotel = criaHotel("Premium Hotel");

      adicionaQuartosNo(premiumHotel, 5);
      hospeda(premiumHotel, new Hospede(new CPF("37575014896"), "Frank"));
      hospeda(premiumHotel, new Hospede(new CPF("99999999999"), "Mirelli"));

      mostraSituacaoDosQuartos(premiumHotel);
   }

   private static Hotel criaHotel(String nomeDoHotel) {
      Hotel hotel = new Hotel(nomeDoHotel);
      log("Hotel \"" + nomeDoHotel + "\" criado");
      return hotel;
   }

   private static void adicionaQuartosNo(Hotel hotel, int quantidade) {
      for (int i = 1; i <= quantidade; i++) {
         hotel.adiciona(new Quarto(i));
      }
      log("Criado \"" + quantidade + "\" quarto(s) no hotel \"" + hotel.getNome() + "\"");
   }

   private static void hospeda(Hotel hotel, Hospede hospede) {
      try {
         hotel.hospeda(hospede);
         log("Hospedado Sr(a) \"" + hospede.getNome() + "\" no Quarto \"" + hospede.getQuarto().getNumero()
               + "\" no hotel \"" + hotel.getNome() + "\"");
      } catch (QuartosOcupadosException e) {
         System.out.println(e.getMessage());
      }
   }

   private static void mostraSituacaoDosQuartos(Hotel hotel) {
      log("Lista de quartos do hotel \"" + hotel.getNome() + "\"");
      for (Quarto quarto : hotel.quartos.values()) {
         System.out.println(quarto);
      }
   }

   private static void log(String msg) {
      System.out.println(">> " + msg + "...");
   }

}
