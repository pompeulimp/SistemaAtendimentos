package br.com.tsi4.controller;

import java.util.Calendar;
import java.util.Date;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;

@Controller
public class IndexController {
	@Inject private Result result;
	
	@Path("/")
	public void index(){
		result.include("wecan", "Paulo Pompeu Marcelo Kbral Commiters ");
		result.include("data", new Date(Calendar.getInstance().getTimeInMillis()));		
	}
}
