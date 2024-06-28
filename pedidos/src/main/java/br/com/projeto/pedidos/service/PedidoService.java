package br.com.projeto.pedidos.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import br.com.projeto.pedidos.dto.PedidoDTO;

import br.com.projeto.pedidos.model.Pedido;

import br.com.projeto.pedidos.repository.PedidoRepository;





@Service
public class PedidoService {

	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	
	
	
	public Pedido inserir(Pedido pedido) {
		
		return pedidoRepository.save(pedido);
	}
	
	
	
	public void excluirPorId(Integer codigo) {
		
		pedidoRepository.deleteById(codigo);
	}
	
	
	public void excluir(Pedido pedido) {
		
		pedidoRepository.delete(pedido);
	}
	
	
	
	public List<Pedido> listar(){
				
		
		return pedidoRepository.findAll();
	}
	
	
	public Integer GETcodPedido() {
		
		Integer b;
		List<Pedido> lista = listar();
				
		if (lista.size() > 0) {
			
			Pedido a = lista.get(lista.size()-1);			
			b = a.getCodPedido()+1;
			
			return b;
			
		}else {
					
			return 1;
			
		}
		
	}
	
		
	public Pedido listarPorId(Integer codigo) {
		
		return pedidoRepository.findById(codigo).get();
	}
	
	
	public Pedido editar(Integer codigo) {
		
		  Optional<Pedido> us = pedidoRepository.findById(codigo);
			
		  Pedido pedido = null;
		  
		  if (us.isPresent()) {
			  
			  pedido = us.get();
			  
		  }else {
			  
			  throw new RuntimeException(" Pedido não existe :: " + codigo);
		  }
		  
		  return pedido;
		}

	
	
	public PedidoDTO listar(Integer codigo) {
		
		Pedido pedido = pedidoRepository.getReferenceById(codigo) ;
		
		
		
		PedidoDTO dto = new PedidoDTO(pedido);
		
		return dto;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
