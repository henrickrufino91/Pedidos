package br.com.projeto.pedidos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projeto.pedidos.model.Perfil;

import br.com.projeto.pedidos.repository.PerfilRepository;



@Service
public class PerfilService {

	
	@Autowired
	private PerfilRepository perfilRepository;
	
	
	
	
	public Perfil inserir(Perfil perfil) {
		
		return perfilRepository.save(perfil);
	}
	
	
	
	public void excluirPorId(Integer codigo) {
		
		perfilRepository.deleteById(codigo);
	}
	
	public void excluir(Perfil perfil) {
		
		perfilRepository.delete(perfil);
	}
	
	
	public List<Perfil> listar(){
		
		return perfilRepository.findAll();
	}
	
	
	public Perfil listarPorId(Integer codigo) {
		
		return perfilRepository.findById(codigo).get();
	}
	
	
	public Perfil editar(Integer codigo) {
		
		  Optional<Perfil> us = perfilRepository.findById(codigo);
			
		  Perfil perfil = null;
		  
		  if (us.isPresent()) {
			  
			  perfil = us.get();
			  
		  }else {
			  
			  throw new RuntimeException(" Perfil não existe :: " + codigo);
		  }
		  
		  return perfil;
		}
	

	
}
