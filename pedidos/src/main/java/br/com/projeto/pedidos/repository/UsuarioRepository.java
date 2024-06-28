package br.com.projeto.pedidos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.projeto.pedidos.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	
	
	@Query("select j from Usuario j where j.email = :email and j.senha = :senha")
	public Usuario buscarLogin(String email,String senha);
	
	
}
