package br.com.projeto.pedidos.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import org.hibernate.annotations.Cascade;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codPedido;
	
	
	private LocalDate dataPedido;	
	
	
	
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario_codigo")
	private Usuario usuario;
	
	
	@OneToMany(mappedBy = "id.pedido",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@Cascade(org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
	private List<ItemPedido> itemPedidos;


	public Pedido() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Pedido(Integer codPedido, LocalDate dataPedido, Usuario usuario, List<ItemPedido> itemPedidos) {
		super();
		this.codPedido = codPedido;
		this.dataPedido = dataPedido;
		this.usuario = usuario;
		this.itemPedidos = itemPedidos;
	}


	public Integer getCodPedido() {
		return codPedido;
	}


	public void setCodPedido(Integer codPedido) {
		this.codPedido = codPedido;
	}


	public LocalDate getDataPedido() {
		return dataPedido;
	}


	public void setDataPedido(LocalDate dataPedido) {
		this.dataPedido = dataPedido;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public List<ItemPedido> getItemPedidos() {
		return itemPedidos;
	}


	public void setItemPedidos(List<ItemPedido> itemPedidos) {
		this.itemPedidos = itemPedidos;
	}

	


	@Override
	public String toString() {
		return "Pedido [codPedido=" + codPedido + ", dataPedido=" + dataPedido + ", usuario=" + usuario + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(codPedido, dataPedido, itemPedidos, usuario);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		return Objects.equals(codPedido, other.codPedido) && Objects.equals(dataPedido, other.dataPedido)
				&& Objects.equals(itemPedidos, other.itemPedidos) && Objects.equals(usuario, other.usuario);
	}
		
	
	

}
