package com.jhotel.hotel;

import java.util.Map;
import java.util.HashMap;
import com.jhotel.documento.Documento;
import com.jhotel.excecoes.QuartosOcupadosException;

public class Hotel {

   private String nome;
   public Map<Integer, Quarto> quartos;
   private Map<Documento, Funcionario> funcionarios;
   private Estoque estoque;

   public Hotel(String nome) {
      this.nome = nome;
      quartos = new HashMap<>();
      funcionarios = new HashMap<>();
      estoque = new Estoque();

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

   public Estoque getEstoque() {
      return estoque;
   }

}
