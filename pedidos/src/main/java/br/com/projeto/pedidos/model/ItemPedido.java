package br.com.projeto.pedidos.model;



import java.util.Objects;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;





@Entity
public class ItemPedido {

	
	@EmbeddedId
    private ItemPedidoPK id;
	
	
	private Integer quantidade;


	public ItemPedido() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ItemPedido(ItemPedidoPK id, Integer quantidade) {
		super();
		this.id = id;
		this.quantidade = quantidade;
	}


	public ItemPedidoPK getId() {
		return id;
	}


	public void setId(ItemPedidoPK id) {
		this.id = id;
	}


	public Integer getQuantidade() {
		return quantidade;
	}


	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id, quantidade);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemPedido other = (ItemPedido) obj;
		return Objects.equals(id, other.id) && Objects.equals(quantidade, other.quantidade);
	}
	
	
}
