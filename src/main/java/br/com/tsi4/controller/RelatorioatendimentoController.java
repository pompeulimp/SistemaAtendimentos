package br.com.tsi4.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;

@Controller
public class RelatorioatendimentoController {
	
	@Inject
	private Result result;

	public void formulario() {
		
		result.include("formulario", "Relatorios de Atendimento");

	
	}
	
	

}
