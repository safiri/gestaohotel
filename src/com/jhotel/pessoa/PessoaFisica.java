package com.jhotel.pessoa;

import com.jhotel.documento.CPF;

public class PessoaFisica implements Pessoa {

   private CPF cpf;
   private String nome;

   public PessoaFisica(CPF cpf, String nome) {
      this.cpf = cpf;
      this.nome = nome;
   }

   public CPF getCpf() {
      return cpf;
   }

   @Override
   public String getNome() {
      return nome;
   }

   @Override
   public CPF getDocumento() {
      return getCpf();
   }

   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
      return result;
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj) {
         return true;
      }
      if (obj == null) {
         return false;
      }
      if (getClass() != obj.getClass()) {
         return false;
      }
      PessoaFisica other = (PessoaFisica) obj;
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
