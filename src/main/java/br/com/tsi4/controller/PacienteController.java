package br.com.tsi4.controller;

import java.sql.SQLException;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.tsi4.model.Paciente;
import br.com.tsi4.model.DAO.ICRUD;
import br.com.tsi4.model.DAO.PacienteDAO;

@Controller
public class PacienteController {

	@Inject private Result result;
	private ICRUD<Paciente> pacietneIcrud ;
	
	@Path("/CadastroPaciente")
	public void paciente() {
		result.include("paciente", "Cadastro de Pacientes");
	}

	@Post
	public void adicionarPaciente(Paciente paciente) {
		System.out.println("começo");
		try {
			pacietneIcrud.create(paciente);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("final");
		result.include("paciente", paciente.getNomePaciente()+ " Salvo com sucesso");
	}
}
