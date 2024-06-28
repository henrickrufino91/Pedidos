package br.com.projeto.pedidos.dto;

import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;

import br.com.projeto.pedidos.model.ItemPedido;
import br.com.projeto.pedidos.model.Pedido;


public class PedidoDTO {

	
	private Integer codPedido;
	
	private UsuarioDTO usuario;
	
	private LocalDate dataPedido;	
	
	
	private Integer codProduto;
	
	private Integer quantidade;
	
	private Double preco;
	
	private String nome;
		
	private Double total;
	
	private List<ItemPedidoDTO> itemPedidos = new ArrayList<>();
	
	

	public PedidoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	public PedidoDTO(Integer codPedido, UsuarioDTO usuario, LocalDate dataPedido, Integer codProduto,
			Integer quantidade, Double preco, String nome, List<ItemPedidoDTO> itemPedidos) {
		super();
		this.codPedido = codPedido;
		this.usuario = usuario;
		this.dataPedido = dataPedido;
		this.codProduto = codProduto;
		this.quantidade = quantidade;
		this.preco = preco;
		this.nome = nome;
		this.itemPedidos = itemPedidos;
	}




	public PedidoDTO(Pedido pedido) {
		super();
		this.codPedido = pedido.getCodPedido();
		this.usuario = new UsuarioDTO(pedido.getUsuario());
		this.dataPedido = pedido.getDataPedido();
		
						
		for (ItemPedido item: pedido.getItemPedidos()) {
			
			ItemPedidoDTO dto = new ItemPedidoDTO(item);
			itemPedidos.add(dto);
			
			this.codProduto = dto.getCodProduto();
			this.quantidade = dto.getQuantidade();
			this.preco = dto.getPreco();
			this.nome = dto.getNome();
			this.total = dto.getPreco() * dto.getQuantidade();
		}
		
		
		
	}

	public Integer getCodPedido() {
		return codPedido;
	}

	public void setCodPedido(Integer codPedido) {
		this.codPedido = codPedido;
	}

	public UsuarioDTO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}

	public LocalDate getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(LocalDate dataPedido) {
		this.dataPedido = dataPedido;
	}

	public List<ItemPedidoDTO> getItemPedidos() {
		return itemPedidos;
	}

	public void setItemPedidos(List<ItemPedidoDTO> itemPedidos) {
		this.itemPedidos = itemPedidos;
		
		
	}




	public Integer getCodProduto() {
		return codProduto;
	}




	public void setCodProduto(Integer codProduto) {
		this.codProduto = codProduto;
	}




	public Integer getQuantidade() {
		return quantidade;
	}




	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
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




	public Double getTotal() {
		return total;
	}




	public void setTotal(Double total) {
		this.total = total;
	}




	@Override
	public String toString() {
		return "PedidoDTO [codPedido=" + codPedido + ", usuario=" + usuario + ", dataPedido=" + dataPedido
				+ ", codProduto=" + codProduto + ", quantidade=" + quantidade + ", preco=" + preco + ", nome=" + nome
				+ ", total=" + total + ", itemPedidos=" + itemPedidos + "]";
	}


	
	
	
	
}
