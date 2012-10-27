package com.jhotel.hotel;

import com.jhotel.pessoa.PessoaFisica;
import com.jhotel.pessoa.RG;

public final class CheckIn {

   public static final void criarHospedagem(final Quarto quarto, final String nome, final String cpf, final String rg,
         final String endereco, final String telefone, final String valorDiaria, final String dataDeEntrada,
         final String horaDeEntrada, final String dataDeSaida, final String horaDeSaida,
         final PessoaFisica... dependentes) throws QuartosOcupadosException, QuartoOcupadoException {

      Hospede hospede = new Hospede(cpf, nome);
      hospede.setRg(new RG(rg));

      Hospedagem hospedagem = quarto.hospeda(hospede, dependentes);
      hospedagem.setEndereco(endereco);
      hospedagem.setTelefone(telefone);
      hospedagem.setValorDiaria(valorDiaria);
      hospedagem.setDataDeEntrada(dataDeEntrada);
      hospedagem.setHoraDeEntrada(horaDeEntrada);
      hospedagem.setDataDeSaida(dataDeSaida);
      hospedagem.setHoraDeSaida(horaDeSaida);
      hospedagem.setDataDeEntrada(dataDeEntrada);
   }

}
