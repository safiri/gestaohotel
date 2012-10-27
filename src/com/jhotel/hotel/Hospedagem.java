package com.jhotel.hotel;

import java.util.List;

import com.jhotel.pessoa.PessoaFisica;

public final class Hospedagem {

   private final Hospede hospede;
   private final List<PessoaFisica> dependentes;
   private String endereco;
   private String telefone;
   private String valorDiaria;
   private String dataDeEntrada;
   private String horaDeEntrada;
   private String dataDeSaida;
   private String horaDeSaida;
   private ListaDeConsumo consumos;

   public Hospedagem(final Hospede hospede, final List<PessoaFisica> dependentes) {
      this.hospede = hospede;
      this.dependentes = dependentes;
      this.consumos = new ListaDeConsumo();
   }

   public final Hospede getHospede() {
      return hospede;
   }

   public final List<PessoaFisica> getDependentes() {
      return dependentes;
   }

   public final String getEndereco() {
      return endereco;
   }

   public final void setEndereco(String endereco) {
      this.endereco = endereco;
   }

   public final String getTelefone() {
      return telefone;
   }

   public final void setTelefone(String telefone) {
      this.telefone = telefone;
   }

   public final String getValorDiaria() {
      return valorDiaria;
   }

   public final void setValorDiaria(String valorDiaria) {
      this.valorDiaria = valorDiaria;
   }

   public final String getDataDeEntrada() {
      return dataDeEntrada;
   }

   public final void setDataDeEntrada(String dataDeEntrada) {
      this.dataDeEntrada = dataDeEntrada;
   }

   public final String getHoraDeEntrada() {
      return horaDeEntrada;
   }

   public final void setHoraDeEntrada(String horaDeEntrada) {
      this.horaDeEntrada = horaDeEntrada;
   }

   public final String getDataDeSaida() {
      return dataDeSaida;
   }

   public final void setDataDeSaida(String dataDeSaida) {
      this.dataDeSaida = dataDeSaida;
   }

   public final String getHoraDeSaida() {
      return horaDeSaida;
   }

   public final void setHoraDeSaida(String horaDeSaida) {
      this.horaDeSaida = horaDeSaida;
   }

   public ListaDeConsumo getConsumos() {
      return this.consumos;
   }

}
