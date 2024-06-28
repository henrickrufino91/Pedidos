package br.com.projeto.pedidos.dto;

import br.com.projeto.pedidos.model.Usuario;

public class UsuarioDTO {

	
	private Integer codUsuario;
	
	
	private String nome;


	public UsuarioDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public UsuarioDTO(Usuario usuario) {
		super();
		this.codUsuario = usuario.getCodUsuario();
		this.nome = usuario.getNome();
	}


	public Integer getCodUsuario() {
		return codUsuario;
	}


	public void setCodUsuario(Integer codUsuario) {
		this.codUsuario = codUsuario;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	@Override
	public String toString() {
		return "UsuarioDTO [codUsuario=" + codUsuario + ", nome=" + nome + "]";
	}
	
}
