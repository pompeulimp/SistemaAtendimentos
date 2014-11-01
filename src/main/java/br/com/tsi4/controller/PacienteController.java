package br.com.tsi4.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;

@Controller
public class PacienteController {
	
	@Inject private Result result;
	@Path("/CadastroPaciente")
	public void paciente(){
		result.include("paciente", "Cadastro de Pacientes");
	}
}
