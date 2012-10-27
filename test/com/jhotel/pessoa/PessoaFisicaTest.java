package com.jhotel.pessoa;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.jhotel.pessoa.Pessoa;
import com.jhotel.pessoa.PessoaFisica;

public class PessoaFisicaTest {

   private static final String CPF_FRANK = "37575014896";

   private Pessoa pessoa;

   @Before
   public void setUp() throws Exception {
      this.pessoa = new PessoaFisica(CPF_FRANK, "Frank");
   }

   @Test
   public void testEquals() {
      final Pessoa frank;
      try {
         frank = new PessoaFisica(CPF_FRANK, "Frank Hermes");
         assertTrue(this.pessoa.equals(frank));
         assertTrue(frank.equals(this.pessoa));
      } catch (Exception e) {
         fail("CPF Invalido");
      }
   }

}
