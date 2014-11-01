	package br.com.tsi4.controller;

	import javax.inject.Inject;

	import br.com.caelum.vraptor.Controller;
	import br.com.caelum.vraptor.Path;
	import br.com.caelum.vraptor.Result;

	@Controller
	public class MedicoController {
		
		@Inject private Result result;
		@Path("/CadastroMedico")
		public void medico(){
			result.include("medico", "Cadastro de Médicos");
		}
	}
