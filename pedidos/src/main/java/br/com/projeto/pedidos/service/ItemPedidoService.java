package br.com.projeto.pedidos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projeto.pedidos.model.ItemPedido;
import br.com.projeto.pedidos.model.ItemPedidoPK;
import br.com.projeto.pedidos.repository.ItemPedidoRepository;

@Service
public class ItemPedidoService {

	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	
	public ItemPedido inserir(ItemPedido itemPedido) {
		
		return itemPedidoRepository.save(itemPedido);
	}
	
	
	
	public void excluirPorId(ItemPedidoPK codigo) {
		
		itemPedidoRepository.deleteById(codigo);
	}
	
	
	public void excluir(ItemPedido itemPedido) {
		
		itemPedidoRepository.delete(itemPedido);
	}
	
	
	
	
	public List<ItemPedido> listar(){
		
		return itemPedidoRepository.findAll();
	}
	
	
	public ItemPedido listarPorId(ItemPedidoPK codigo) {
		
		return itemPedidoRepository.findById(codigo).get();
	}
	
	
	public ItemPedido editar(ItemPedidoPK codigo) {
		
		  Optional<ItemPedido> us = itemPedidoRepository.findById(codigo);
			
		  ItemPedido itemPedido = null;
		  
		  if (us.isPresent()) {
			  
			  itemPedido = us.get();
			  
		  }else {
			  
			  throw new RuntimeException(" Item do Pedido não existe :: " + codigo);
		  }
		  
		  return itemPedido;
		}

}
