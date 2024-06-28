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
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codProduto;
	
	private Double preco;
	
	private String nome;
	
	private String descricao;
	
	
	@OneToMany(mappedBy = "id.produto",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@Cascade(org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
	private List<ItemPedido> itemPedidos;


	public Produto() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Produto(Integer codProduto, Double preco, String nome, String descricao, List<ItemPedido> itemPedidos) {
		super();
		this.codProduto = codProduto;
		this.preco = preco;
		this.nome = nome;
		this.descricao = descricao;
		this.itemPedidos = itemPedidos;
	}


	public Integer getCodProduto() {
		return codProduto;
	}


	public void setCodProduto(Integer codProduto) {
		this.codProduto = codProduto;
	}


	public Double getPreco() {
		return preco;
	}


	public void setPreco(Double preco) {
		this.preco = preco;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public List<ItemPedido> getItemPedidos() {
		return itemPedidos;
	}


	public void setItemPedidos(List<ItemPedido> itemPedidos) {
		this.itemPedidos = itemPedidos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codProduto, descricao, itemPedidos, nome, preco);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return Objects.equals(codProduto, other.codProduto) && Objects.equals(descricao, other.descricao)
				&& Objects.equals(itemPedidos, other.itemPedidos) && Objects.equals(nome, other.nome)
				&& Objects.equals(preco, other.preco);
	}


	@Override
	public String toString() {
		return "Produto [codProduto=" + codProduto + ", preco=" + preco + ", nome=" + nome + ", descricao=" + descricao
				+ "]";
	}
	
	
	
}
