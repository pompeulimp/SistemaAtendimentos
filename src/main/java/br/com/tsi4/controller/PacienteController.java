package br.com.tsi4.controller;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.com.tsi4.model.Paciente;
import br.com.tsi4.model.DAO.ICRUD;
import br.com.tsi4.model.DAO.PacienteDAO;

@Controller
public class PacienteController {
	@Inject
	private Result result;
	private ICRUD<Paciente> icrud;
	@Inject
	private Paciente paciente;
	private String mensagen = null;

	public PacienteController() {
		this.icrud = new PacienteDAO();
	}

	public void formulario() {
	}

	public void editar(long pkKey) {
		try {
			this.paciente = icrud.retriveOneByPkKey(pkKey);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		result.include(this.paciente);
		result.of(this).formulario();
	}

	public void deletar(long pkKLey){
		try {
			if(icrud.delete(pkKLey)){
				mensagen = "deletado";
			}else{
				mensagen = "não econtroado";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		result.include("mensagem", "Paciente " + mensagen);
		result.redirectTo(this).listar();
	}

	public void create(Paciente paciente) {

		try {
			if (paciente.getPk_paciente() != 0) {
				icrud.update(paciente);
				mensagen = "atualisado";
			} else {
				icrud.create(paciente);
				mensagen = "criado";
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		result.include("mensagem", "Paciente " + mensagen + " com sucesso!");
		result.redirectTo(this).listar();
	}

	public List<Paciente> listar() {
		try {
			return icrud.restriveAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
