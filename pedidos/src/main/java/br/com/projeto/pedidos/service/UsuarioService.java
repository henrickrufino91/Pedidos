package br.com.projeto.pedidos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projeto.pedidos.model.Usuario;
import br.com.projeto.pedidos.repository.UsuarioRepository;


@Service
public class UsuarioService {

	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	
	
	public Usuario inserir(Usuario usuario) {
		
		return usuarioRepository.save(usuario);
	}
	
	
	
	public void excluirPorId(Integer codigo) {
		
		usuarioRepository.deleteById(codigo);
	}
	
	
	public void excluir(Usuario usuario) {
		
		usuarioRepository.delete(usuario);
	}
	
	
	
	
	public List<Usuario> listar(){
		
		return usuarioRepository.findAll();
	}
	
	
	public Usuario listarPorId(Integer codigo) {
		
		return usuarioRepository.findById(codigo).get();
	}
	
	
	public Usuario editar(Integer codigo) {
		
		  Optional<Usuario> us = usuarioRepository.findById(codigo);
			
		  Usuario usuario = null;
		  
		  if (us.isPresent()) {
			  
			  usuario = us.get();
			  
		  }else {
			  
			  throw new RuntimeException(" Usuario não existe :: " + codigo);
		  }
		  
		  return usuario;
		}
	
	
	
	public Usuario login(String email,String senha) {
		
		return usuarioRepository.buscarLogin(email, senha);
	}
	
	
	public String GETnome(String email,String senha) {
		
		Usuario usuario = login(email, senha);
		
		
		return usuario.getNome();
	}
	
	
	
	
	
	
	
	
	
	
}
