package com.jhotel;

import java.math.BigDecimal;

public class Produto {
	
	private Integer codigo;
	private String descricao;
	private BigDecimal preco;
	private Integer quantidade;
	
	public Produto(Integer codigo, String descricao, BigDecimal preco, Integer quantidade){
	  this.descricao = descricao;
	  this.codigo = codigo;
	  this.preco = preco;
	  this.quantidade = quantidade;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public Integer getQuantidade() {
		return quantidade;
	}


	

}
