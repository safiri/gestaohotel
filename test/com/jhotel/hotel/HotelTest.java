package com.jhotel.hotel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.jhotel.pessoa.PessoaFisica;
import com.jhotel.util.DataUtil;

public class HotelTest {

   private Hotel hotel;

   @Before
   public final void setUp() {
      hotel = new Hotel("Premium Hotel");
   }

   //
   // Testes
   //

   @Test
   public final void testCriadoQuartos() {
      final int quantidadeDeQuartos = 5;
      dadoQueExistaQuartosNoHotel(quantidadeDeQuartos);
      eNenhumaMovimentacao();
      entaoTodosQuartosEstaoVazios();
      eNenhumQuartoEstaOcupado();
   }

   @Test
   public final void testHospedeSeHospeda() throws QuartosOcupadosException, QuartoOcupadoException {
      final int quartoNumUm = 1;
      dadoQueExistaUmQuartoNoHotel(quartoNumUm);
      Hospede frank = dadoQueExistaUmHospede("37575014896", "Frank");
      quandoEuHospedoNoHotel(frank);
      entaoOHospedeEstaNoQuarto(frank, quartoNumUm);
   }

   @Test
   public final void testHospedeSeHospedaComAFamilia() throws QuartosOcupadosException, QuartoOcupadoException {
      final int quartoNumUm = 1;
      dadoQueExistaUmQuartoNoHotel(quartoNumUm);
      final Hospede frank = dadoQueExistaUmHospede("37575014896", "Frank");
      PessoaFisica[] dependentes = new PessoaFisica[] { new PessoaFisica("12345678909", "Mirelli") };
      eQuandoEuHospedoHospedeESeusDependentesNoHotel(frank, dependentes);
      entaoOHospedeEstaNoQuarto(frank, quartoNumUm);
      eSeusDependentesEstaoNoQuarto(quartoNumUm, dependentes);
   }

   @Test
   public final void testHospedarVariosHospedes() throws QuartosOcupadosException, QuartoOcupadoException {
      final int quartoNumUm = 1;
      dadoQueExistaUmQuartoNoHotel(quartoNumUm);
      final int quartoNumDois = 2;
      dadoQueExistaUmQuartoNoHotel(quartoNumDois);
      final int quartoNumTres = 3;
      dadoQueExistaUmQuartoNoHotel(quartoNumTres);
      final Hospede frank = dadoQueExistaUmHospede("37575014896", "Frank");
      final Hospede fulano = dadoQueExistaUmHospede("37575014896", "Fulano");
      quandoEuHospedoNoHotel(frank);
      quandoEuHospedoNoHotel(fulano);
      entaoOHospedeEstaNoQuarto(frank, quartoNumUm);
      entaoOHospedeEstaNoQuarto(fulano, quartoNumDois);
   }

   @Test(expected = QuartosOcupadosException.class)
   public final void testUmQuartoNoHotelTentoHospedarSegundoHospede() throws QuartosOcupadosException, QuartoOcupadoException {
      final int quartoNumUm = 1;
      dadoQueExistaUmQuartoNoHotel(quartoNumUm);
      final Hospede frank = dadoQueExistaUmHospede("37575014896", "Frank");
      final Hospede fulano = dadoQueExistaUmHospede("37575014896", "Fulano");
      quandoEuHospedoNoHotel(frank);
      quandoEuHospedoNoHotel(fulano);
      // eh lancada uma excecao QuartosOcupadosException
   }

   @Test(expected = QuartosOcupadosException.class)
   public final void testHospedeSeHospedaNoQuartoReservado() throws QuartosOcupadosException, QuartoOcupadoException {
      final int quartoNumUm = 1;
      dadoQueExistaUmQuartoNoHotel(quartoNumUm);
      eEsteQuartoEstejaReservadoPara("Mirelli");
      final Hospede frank = dadoQueExistaUmHospede("37575014896", "Frank");
      quandoEuHospedoNoHotel(frank);
   }

   @Test
   public final void testHospedeSeHospedaEmOutroQuartoENaoNoQuartoReservado() throws QuartosOcupadosException, QuartoOcupadoException {
      final int quartoNumUm = 1;
      dadoQueExistaUmQuartoNoHotel(quartoNumUm);
      final int quartoNumDois = 2;
      dadoQueExistaUmQuartoNoHotel(quartoNumDois);
      eEsteQuartoEstejaReservadoPara("Mirelli");
      final Hospede frank = dadoQueExistaUmHospede("37575014896", "Frank");
      quandoEuHospedoNoHotel(frank);
      entaoOHospedeNaoEstaNoQuarto(frank, quartoNumUm);
      entaoOHospedeEstaNoQuarto(frank, quartoNumDois);
   }

   //
   // Helpers
   //

   private final void eSeusDependentesEstaoNoQuarto(final int numQuarto, final PessoaFisica... dependentes) {
      final Quarto quarto = hotel.getQuartos().buscaQuartoPeloNumero(numQuarto);
      assertEquals((List<PessoaFisica>) Arrays.asList(dependentes), quarto.getDependentes());
   }

   private final void eQuandoEuHospedoHospedeESeusDependentesNoHotel(final Hospede hospede,
         final PessoaFisica... dependentes) throws QuartosOcupadosException, QuartoOcupadoException {
      hotel.getQuartos().hospeda(hospede, dependentes);
   }

   private final void entaoOHospedeNaoEstaNoQuarto(final Hospede hospede, final int numQuarto) {
      final Quarto quarto = hotel.getQuartos().buscaQuartoPeloNumero(numQuarto);
      assertEquals(false, hospede.equals(quarto.getHospedePrincipal()));
   }

   private final void eEsteQuartoEstejaReservadoPara(final String alguem) throws QuartosOcupadosException {
      hotel.getQuartos().reserva(alguem, DataUtil.getDataHoje());
   }

   private final void entaoOHospedeEstaNoQuarto(final Hospede hospede, int numQuarto) {
      assertEquals(hospede, hotel.getQuartos().buscaQuartoPeloNumero(numQuarto).getHospedePrincipal());
   }

   private final void quandoEuHospedoNoHotel(final Hospede hospede) throws QuartosOcupadosException, QuartoOcupadoException {
      hotel.getQuartos().hospeda(hospede);
   }

   private final Hospede dadoQueExistaUmHospede(final String cpf, final String nome) {
      return new Hospede(cpf, nome);
   }

   private final void dadoQueExistaUmQuartoNoHotel(final int numero) {
      hotel.getQuartos().adiciona(numero);
   }

   private final void eNenhumQuartoEstaOcupado() {
      assertFalse(hotel.getQuartos().isTodosQuartosOcupados());
   }

   private final void entaoTodosQuartosEstaoVazios() {
      assertTrue(hotel.getQuartos().isTodosQuartosVazios());
   }

   private final void eNenhumaMovimentacao() {}

   private final void dadoQueExistaQuartosNoHotel(final int quantidadeDeQuartos) {
      for (int numQuarto = 1; numQuarto <= quantidadeDeQuartos; numQuarto++) {
         hotel.getQuartos().adiciona(numQuarto);
      }
   }

}
