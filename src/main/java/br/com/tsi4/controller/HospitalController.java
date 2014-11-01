package br.com.tsi4.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;

@Controller
public class HospitalController {
	
	@Inject private Result result;
	@Path("/CadastroDeUnidades")
	public void hospital(){
		result.include("hospital", "Cadastro de Unidades");
	}
}
