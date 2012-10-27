package com.jhotel.pessoa;

import com.jhotel.documento.CPF;

public class PessoaFisica implements Pessoa {

   private final CPF cpf;
   private RG rg;
   private final String nome;

   public PessoaFisica(final String cpf, final String nome) {
      this.cpf = new CPF(cpf);
      this.nome = nome;
   }

   public final CPF getCpf() {
      return cpf;
   }

   @Override
   public final String getNome() {
      return nome;
   }

   @Override
   public final CPF getDocumento() {
      return getCpf();
   }

   public RG getRg() {
      return rg;
   }

   public void setRg(RG rg) {
      this.rg = rg;
   }

   @Override
   public final int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
      return result;
   }

   @Override
   public final boolean equals(Object obj) {
      if (this == obj) {
         return true;
      }
      if (obj == null) {
         return false;
      }
      if (getClass() != obj.getClass()) {
         return false;
      }
      final PessoaFisica other = (PessoaFisica) obj;
      if (cpf == null) {
         if (other.cpf != null) {
            return false;
         }
      } else if (!cpf.equals(other.cpf)) {
         return false;
      }
      return true;
   }

   @Override
   public String toString() {
      return this.nome + " (" + this.cpf + ")";
   }

}
