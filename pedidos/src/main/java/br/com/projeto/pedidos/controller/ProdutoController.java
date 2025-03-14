package br.com.projeto.pedidos.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.com.projeto.pedidos.model.Produto;
import br.com.projeto.pedidos.service.ProdutoService;

@RestController
public class ProdutoController {

	
	@Autowired
	private ProdutoService produtoService;
	
	
	
	@GetMapping("/novoProduto")
	public ModelAndView novo() {
		
		ModelAndView mv = new ModelAndView("novoProduto");
		mv.addObject("produto", new Produto());
		
		return mv;
	}
	
	
	@PostMapping("/salvarProduto")
	public ModelAndView salvar(@Valid Produto produto) {
		
		try {
			
			if (produto.getCodProduto() == null) {
				produtoService.inserir(produto);
			} else {
				Produto p = produtoService.listarPorId(produto.getCodProduto());
				p.setNome(produto.getNome());
				p.setDescricao(produto.getDescricao());
				p.setPreco(produto.getPreco());
							
				produtoService.inserir(p);
				
			}
						
			ModelAndView mv = new ModelAndView("redirect:/novoProduto");
			mv.addObject("produto", produto);
						
			return mv;
					
			
		} catch (Exception e) {

			ModelAndView mv = new ModelAndView("redirect:/novoProduto");
			mv.addObject("msg", "Erro ao salvar produto, confira os campos!!");
			
			return mv;
			
		}
		
		
	}
	
	@GetMapping("/editarProduto")
    public ModelAndView editar(@RequestParam Integer codigo){
        
        ModelAndView mv = new ModelAndView("editarProduto");
    
        Produto produto = produtoService.listarPorId(codigo);
        mv.addObject("produto",  produto);
               
        return mv;
   
    }
	
	
	@GetMapping("/removerProduto")
    public ModelAndView remover(@RequestParam Integer codigo){
        
		try {
			
			ModelAndView mv = new ModelAndView("redirect:/listarProdutos");
			
			Produto produto = produtoService.listarPorId(codigo);
			produtoService.excluir(produto);
			
	        return mv;			
			
		} catch (Exception e) {

			ModelAndView mv = new ModelAndView("redirect:/listarProdutos");
			mv.addObject("msg", "Erro ao remover produto!!");
			
			return mv;
		}
		
		
    }
	
	
	@GetMapping("/listarProdutos")
    public ModelAndView listar(){
        
        ModelAndView mv = new ModelAndView("listarProdutos");
        
        mv.addObject("produtos",  produtoService.listar());
        mv.addObject("produto",  new Produto());
        
        return mv;
   
    }
	
	
	
}
