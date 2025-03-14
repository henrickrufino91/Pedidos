package br.com.projeto.pedidos.controller;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


import br.com.projeto.pedidos.model.ItemPedido;
import br.com.projeto.pedidos.model.ItemPedidoPK;

import br.com.projeto.pedidos.service.ItemPedidoService;
import br.com.projeto.pedidos.service.PedidoService;

import br.com.projeto.pedidos.service.ProdutoService;


@RestController
public class ItemPedidoController {
	
	
	@Autowired
	private ItemPedidoService itemPedidoService;
	
	@Autowired
	private ProdutoService produtoService;
	
	@Autowired
	private PedidoService pedidoService;
	
	
	
	@GetMapping("/novoItemPedido")
	public ModelAndView novo() {
		
		ModelAndView mv = new ModelAndView("novoItemPedido");
		mv.addObject("itemPedido", new ItemPedido());
		mv.addObject("produtos", produtoService.listar());
		mv.addObject("pedidos", pedidoService.listar());
		
		return mv;
	}
	
	
	@PostMapping("/salvarItemPedido")
	public ModelAndView salvar(@Valid ItemPedido itemPedido) {
		
		try {
			
			ModelAndView mv = new ModelAndView("redirect:/novoItemPedido");
			mv.addObject("itemPedido", itemPedido);
			itemPedidoService.inserir(itemPedido);
					
			return mv;
			
		} catch (Exception e) {
			
			ModelAndView mv = new ModelAndView("redirect:/novoItemPedido");
			mv.addObject("msg", "Erro ao salvar item do pedido, confira os campos!!");
			
			return mv;
			
		}
		
	}
	
	
	@GetMapping("/editarItemPedido")
    public ModelAndView editar(@RequestParam ItemPedidoPK codigo){
        
        ModelAndView mv = new ModelAndView("editarItemPedido");
    
        ItemPedido itemPedido = itemPedidoService.listarPorId(codigo);
        mv.addObject("itemPedido",  itemPedido);
        mv.addObject("produtos", produtoService.listar());
		mv.addObject("pedidos", pedidoService.listar());
       
        return mv;
   
    }
	
	
	@GetMapping("/removerItemPedido")
    public ModelAndView remover(@RequestParam ItemPedidoPK codigo){
		
		try {
			
			ModelAndView mv = new ModelAndView("redirect:/listarItemPedidos");
			
			ItemPedido itemPedido = itemPedidoService.listarPorId(codigo);
			itemPedidoService.excluir(itemPedido);
			
	        return mv;
			
		} catch (Exception e) {
			
			ModelAndView mv = new ModelAndView("redirect:/listarItemPedidos");
			mv.addObject("msg", "Erro ao remover item do pedido!!");
			
			return mv;			
		}
		
    }
	
	
	@GetMapping("/listarItemPedidos")
    public ModelAndView listar(){
        
        ModelAndView mv = new ModelAndView("listarItemPedidos");
        
        mv.addObject("itemPedidos",  itemPedidoService.listar());
        mv.addObject("itemPedido",  new ItemPedido());
        
        return mv;
   
    }
	
		

}
