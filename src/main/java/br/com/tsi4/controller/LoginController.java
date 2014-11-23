package br.com.tsi4.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.I18nMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.com.tsi4.annotations.Public;
import br.com.tsi4.model.Usuario;
import br.com.tsi4.model.DAO.UsuarioDAO;

@Controller
public class LoginController {
	
	private final UsuarioDAO dao;
	private final Validator validator;
	private final UsuarioLogado usuarioLogado;
	private Result result;

	@Inject
	public LoginController(UsuarioDAO dao, Validator validator, UsuarioLogado usuarioLogado,
			Result result) {
		this.dao = dao;
		this.validator = validator;
		this.usuarioLogado = usuarioLogado;
		this.result = result;
		
	}
	
	@Deprecated
	public LoginController() {
		this(null, null, null, null);
	}
	
	@Get @Public
	public void formulario(){
		
	}
	
	@Post @Public
	public void autentica(Usuario usuario){
		
		System.out.println("Vou buscar o usuario: "+usuario.getNomeUsuario());
		System.out.println("Com a Senha: "+usuario.getSenha());
		if(!dao.existe(usuario)){
			validator.add(new I18nMessage("login", "login.invalido"));
			validator.onErrorUsePageOf(this).formulario();
		}
		usuarioLogado.setUsuario(usuario);
		result.redirectTo(IndexController.class).index();
		
	}
	

}
