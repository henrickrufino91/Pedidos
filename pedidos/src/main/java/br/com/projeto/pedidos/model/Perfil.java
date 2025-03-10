package br.com.projeto.pedidos.model;

import java.util.List;
import java.util.Objects;

import org.hibernate.annotations.Cascade;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Perfil {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codPerfil;
	
	
	private String nome;
	
	
	@OneToMany(mappedBy = "perfil",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@Cascade(org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
	private List<Usuario> usuarios;


	public Perfil() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Perfil(Integer codPerfil, String nome, List<Usuario> usuarios) {
		super();
		this.codPerfil = codPerfil;
		this.nome = nome;
		this.usuarios = usuarios;
	}


	public Integer getCodPerfil() {
		return codPerfil;
	}


	public void setCodPerfil(Integer codPerfil) {
		this.codPerfil = codPerfil;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public List<Usuario> getUsuarios() {
		return usuarios;
	}


	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}


	@Override
	public int hashCode() {
		return Objects.hash(codPerfil, nome, usuarios);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Perfil other = (Perfil) obj;
		return Objects.equals(codPerfil, other.codPerfil) && Objects.equals(nome, other.nome)
				&& Objects.equals(usuarios, other.usuarios);
	}


	@Override
	public String toString() {
		return "Perfil [codPerfil=" + codPerfil + ", nome=" + nome + "]";
	}
	
	
	
	
	
	
	
	
	
}
