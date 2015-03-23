package br.ucdb.controller;

import java.util.ArrayList;
import java.util.List;

import br.ucdb.utils.Produto;

public class GerenciadorProduto {

private static List<Produto> produtos =  new ArrayList<Produto>(); 
	
	public void salvar(Produto produto) {
		produtos.add(produto);
	}
	
	public void excluir(int posicao){
		produtos.remove(posicao);
	}

	public List<Produto> getProduto() {
		return produtos;
	}
}
