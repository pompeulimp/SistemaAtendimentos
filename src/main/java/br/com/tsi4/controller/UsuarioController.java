package br.com.tsi4.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;

@Controller
public class UsuarioController {
	
	@Inject private Result result;
	@Path("/CadastroUsuario")
	public void usuario(){
		result.include("usuario", "Cadastro de Usuarios");
	}
}
