package com.jhotel.hotel;

public final class Teste {
   private final static class Oi {
   }

   public static final void main(String[] args) {
      final Oi oi = new Oi();
      System.out.println(oi.equals(null));
      // System.out.println(((Object) null).equals(oi));
   }
}
