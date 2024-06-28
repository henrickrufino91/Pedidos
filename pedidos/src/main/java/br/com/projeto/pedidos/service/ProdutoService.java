package br.com.projeto.pedidos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projeto.pedidos.model.Produto;

import br.com.projeto.pedidos.repository.ProdutoRepository;



@Service
public class ProdutoService {

	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	
	
	
	public Produto inserir(Produto produto) {
		
		return produtoRepository.save(produto);
	}
	
	
	
	public void excluirPorId(Integer codigo) {
		
		produtoRepository.deleteById(codigo);
	}
	
	
	public void excluir(Produto produto) {
		
		produtoRepository.delete(produto);
	}
	
	
	
	
	public List<Produto> listar(){
		
		return produtoRepository.findAll();
	}
	
	
	public Produto listarPorId(Integer codigo) {
		
		return produtoRepository.findById(codigo).get();
	}
	
	
	public Produto editar(Integer codigo) {
		
		  Optional<Produto> us = produtoRepository.findById(codigo);
			
		  Produto produto = null;
		  
		  if (us.isPresent()) {
			  
			  produto = us.get();
			  
		  }else {
			  
			  throw new RuntimeException(" Produto não existe :: " + codigo);
		  }
		  
		  return produto;
		}
	
	
	
}
