package br.com.projeto.pedidos.dto;

import br.com.projeto.pedidos.model.Produto;

public class ProdutoDTO {

	
	private Integer codProduto;
	
	private String nome;
	
	private String descricao;
	
	private Double preco;

	public ProdutoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProdutoDTO(Produto produto) {
		super();
		this.codProduto = produto.getCodProduto();
		this.nome = produto.getNome();
		this.descricao = produto.getDescricao();
		this.preco = produto.getPreco();
	}

	public Integer getCodProduto() {
		return codProduto;
	}

	public void setCodProduto(Integer codProduto) {
		this.codProduto = codProduto;
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

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	@Override
	public String toString() {
		return "ProdutoDTO [codProduto=" + codProduto + ", nome=" + nome + ", descricao=" + descricao + ", preco="
				+ preco + "]";
	}
	
	
	
}
