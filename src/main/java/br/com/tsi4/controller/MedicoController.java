package br.com.tsi4.controller;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.com.tsi4.model.Medico;
import br.com.tsi4.model.DAO.ICRUD;
import br.com.tsi4.model.DAO.MedicoDAO;

@Controller
public class MedicoController {

	@Inject
	private Result result;
	private ICRUD<Medico> icrud;
	@Inject
	private Medico medico;
	private String mensagen = null;

	public MedicoController() {
		this.icrud = new MedicoDAO();
	}

	public void formulario() {
	}

	public void create(Medico medico) {
		try {
			if (medico.getPkMedico() != 0) {
				icrud.update(medico);
				mensagen = "atualisado";
			} else {
				icrud.create(medico);
				mensagen = "criado";
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		result.include("mensagem", "Medico " + mensagen + " com sucesso!");
		result.redirectTo(this).listar();
	}

	public List<Medico> listar() {
		try {

			return icrud.restriveAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void editar(long pkKey) {
		try {
			medico = icrud.retriveOneByPkKey(pkKey);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		result.include(medico);
		result.of(this).formulario();
	}

	public void deletar(long pkKLey) {
		try {
			if (icrud.delete(pkKLey)) {
				mensagen = "deletado";
			} else {
				mensagen = "não econtroado";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		result.include("mensagem", "Medico " + mensagen);
		result.redirectTo(this).listar();
	}
}
