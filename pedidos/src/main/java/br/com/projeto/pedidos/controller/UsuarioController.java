package br.com.projeto.pedidos.controller;

import java.security.NoSuchAlgorithmException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.com.projeto.pedidos.exception.ServiceEXC;
import br.com.projeto.pedidos.model.Usuario;
import br.com.projeto.pedidos.service.PerfilService;
import br.com.projeto.pedidos.service.UsuarioService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RestController
public class UsuarioController {
	
	private static final String SESSION_NOTES = "SESSION_NOTES";
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private PerfilService perfilService;
	
	
	@GetMapping("/")
	public ModelAndView login() {
		
		ModelAndView mv = new ModelAndView("login");
		mv.addObject("usuario", new Usuario());
		
		return mv;
	}
	
	
	@PostMapping(value = "/logar")
	 public ModelAndView login(@Valid Usuario usuario, BindingResult br,
			 HttpServletRequest request) throws NoSuchAlgorithmException, ServiceEXC {
	      
		 		 
	        Usuario userLogin = usuarioService.login(usuario.getEmail(), usuario.getSenha());
	       
	       
	        if(userLogin != null) {
	        	
	        	if (userLogin.getPerfil().getNome().equals("Administrador")) {
	        		
	        		ModelAndView mv = new ModelAndView("indexADM");
	        	        	
	        		request.getSession().setAttribute("usuarioLogado", userLogin.getNome());
	        			        	  
	        		return mv;
	        		
	        	}else {
	        		
	        		ModelAndView mv = new ModelAndView("index");
	        		    	        	
	        		request.getSession().setAttribute("usuarioLogado", userLogin);
	        	  
	        		return mv;
	        		
	        	}
	        	
	        } else {
	        	
	        	ModelAndView mv = new ModelAndView("login");
	        	
	        	mv.addObject("msg", "Login ou senha está incorreto");
	       
	            return mv;
	        }

	     
	    }
	
	
		@GetMapping("/logout")
		public ModelAndView logout(HttpSession session) {
			
			ModelAndView mv = new ModelAndView("login");
			
			mv.addObject("usuario", new Usuario());
			
			session.invalidate();
       
			return mv;
		}
	
	
	
	@GetMapping("/index")
	public ModelAndView index(@Valid Usuario usuario) {
		
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("usuario", usuario);
		
		return mv;
	}
	
	
	@GetMapping("/indexADM")
	public ModelAndView indexADM(@Valid Usuario usuario) {
		
		ModelAndView mv = new ModelAndView("indexADM");
		mv.addObject("usuario", usuario);
		
		return mv;
	}
	
	
	
	
	@GetMapping("/novoUsuario")
	public ModelAndView novo() {
		
		ModelAndView mv = new ModelAndView("novoUsuario");
		mv.addObject("usuario", new Usuario());
		mv.addObject("perfis", perfilService.listar());
		
		return mv;
	}
	
	
	@PostMapping("/salvarUsuario")
	public ModelAndView salvar(@Valid Usuario usuario) {
		
		
		try {
			
			ModelAndView mv = new ModelAndView("redirect:/novoUsuario");
			mv.addObject("usuario", usuario);
			usuarioService.inserir(usuario);
					
			return mv;			
			
		} catch (Exception e) {
			
			ModelAndView mv = new ModelAndView("redirect:/novoUsuario");
			
			mv.addObject("msg", "Erro ao salvar usuário, confira os campos!!");
			
			return mv;
		}
		
	}
	
	@GetMapping("/editarUsuario")
    public ModelAndView editar(@RequestParam Integer codigo){
        
        ModelAndView mv = new ModelAndView("editarUsuario");
    
        Usuario usuario = usuarioService.listarPorId(codigo);
        mv.addObject("usuario",  usuario);
        mv.addObject("perfis",  perfilService.listar());
       
        return mv;
   
    }
	
	
	@GetMapping("/removerUsuario")
    public ModelAndView remover(@RequestParam Integer codigo){
		
		try {
			
			ModelAndView mv = new ModelAndView("redirect:/listarUsuarios");
			
			Usuario usuario = usuarioService.listarPorId(codigo);
			usuarioService.excluir(usuario);
			
	        return mv;
			
		} catch (Exception e) {

			ModelAndView mv = new ModelAndView("redirect:/listarUsuarios");
			mv.addObject("msg", "Erro ao remover usuário!!");
		
			return mv;
		}
		
    }
	
	
	@GetMapping("/listarUsuarios")
    public ModelAndView listar(){
        
				
        ModelAndView mv = new ModelAndView("listarUsuarios");
        
        mv.addObject("usuarios",  usuarioService.listar());
        mv.addObject("usuario",  new Usuario());
        
        return mv;
   
    }
	
		

}
