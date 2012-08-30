package com.jhotel;

import java.util.Map;
import java.util.HashMap;

public class Hotel {

   private String nome;
   public Map<Integer, Quarto> quartos;
   private Map<Documento, Funcionario> funcionarios;

   public Hotel(String nome) {
      this.nome = nome;
      quartos = new HashMap<>();
      funcionarios = new HashMap<>();
   }

   public String getNome() {
      return nome;
   }

   public void adiciona(Quarto quarto) {
      quartos.put(quarto.getNumero(), quarto);
   }

   public void adiciona(Funcionario funcionario) {
      funcionario.setHotel(this);
      funcionarios.put(funcionario.getCpf(), funcionario);
   }

   public Quarto buscaQuartoDisponivel() throws QuartosOcupadosException {
      for (Quarto quarto : quartos.values()) {
         if (!quarto.ocupado()) {
            return quarto;
         }
      }
      throw new QuartosOcupadosException();
   }

   public void hospeda(Hospede hospede) throws QuartosOcupadosException {
      Quarto quarto = buscaQuartoDisponivel();
      quarto.setHospede(hospede); // ?
      hospede.setQuarto(quarto); // ?
   }

}
