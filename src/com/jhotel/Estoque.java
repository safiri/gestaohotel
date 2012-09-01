package com.jhotel;
import java.util.HashMap;
import java.util.Map;

public class Estoque {
	
	Map<Integer, Produto> produtos;
	
	public Estoque(){
		produtos = new HashMap<>();
	}

	
	public void adiciona(Produto produto){
		produtos.put(produto.getCodigo(), produto);
	}
}
