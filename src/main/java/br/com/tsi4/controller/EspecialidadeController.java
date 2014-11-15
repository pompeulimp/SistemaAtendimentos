package br.com.tsi4.controller;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.com.tsi4.model.Especialidade;
import br.com.tsi4.model.DAO.EspecialidadesDAO;
import br.com.tsi4.model.DAO.ICRUD;

@Controller
public class EspecialidadeController {

	@Inject
	private Result result;
	private ICRUD<Especialidade> icrud;
	@Inject
	private Especialidade especialidade;
	private String mensagen = null;

	public EspecialidadeController() {
		this.icrud = new EspecialidadesDAO();
	}

	public void formulario() {
	}

	public void create(Especialidade especialidade) {
		System.out.println(especialidade.toString());

		try {
			if (especialidade.getPkEspecialidade() != 0) {
				icrud.update(especialidade);
				mensagen = "atualisado";
			} else {
				icrud.create(especialidade);
				mensagen = "criado";
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		result.include("mensagem", "especialidade " + mensagen
				+ " com sucesso!");
		result.redirectTo(this).listar();
	}

	public List<Especialidade> listar() {
		try {

			return icrud.restriveAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void editar(long pkKey) {
		try {
			especialidade = icrud.retriveOneByPkKey(pkKey);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		result.include(especialidade);
		result.of(this).formulario();
	}

	public void deletar(long pkKey) {
		System.out.println(pkKey);
		try {
			if (icrud.delete(pkKey)) {
				mensagen = "deletado";
			} else {
				mensagen = "não econtroado";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		result.include("mensagem", "especialidade " + mensagen);
		result.redirectTo(this).listar();
	}
}
