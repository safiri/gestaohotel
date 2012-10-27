package com.jhotel.documento;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class CPFTest {

   private static final String CPF_FRANK = "37575014896";
   private static final String CPF_FRANK_COM_MASCARA = "375.750.148-96";

   private CPF cpf;

   @Before
   public final void setUp() throws Exception {
      this.cpf = new CPF(CPF_FRANK);
   }

   @Test
   public final void testGetNumeroComMascara() {
      assertEquals(CPF_FRANK_COM_MASCARA, this.cpf.getNumeroComMascara());
   }

   @Test
   public final void testEquals() {
      final CPF frank;
      try {
         frank = new CPF(CPF_FRANK);
         assertTrue(this.cpf.equals(frank));
         assertTrue(frank.equals(this.cpf));
      } catch (Exception e) {
         fail("CPF Invalido");
      }
   }

}
