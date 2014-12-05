package br.com.tsi4.controller;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.com.tsi4.model.Fila;
import br.com.tsi4.model.DAO.FilaDAO;
import br.com.tsi4.model.DAO.ICRUD;

@Controller
public class FilaController {

	@Inject
	private Result result;
	private Fila fila;
	private ICRUD<Fila> icrud;
	private String mensagen = null;

	public void Fila() {
		icrud = new FilaDAO();
	}

	public void formulario() {
	}

	public void create(Fila fila) {

		try {
			if (fila.getpkFila() != 0) {
				icrud.update(fila);
				mensagen = "atualizado";
			} else {
				icrud.create(fila);
				mensagen = "criado";
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		result.include("mensagem", "Tipo" + mensagen
				+ " com sucesso!");
		result.redirectTo(this).listar();
	}

	public List<Fila> listar() {
		try {

			return icrud.restriveAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void editar(long pkKey) {
		try {
			fila = icrud.retriveOneByPkKey(pkKey);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		result.include(fila);
		result.of(this).formulario();
	}

	public void deletar(long pkKey) {
		try {
			if (icrud.delete(pkKey)) {
				mensagen = "deletado";
			} else {
				mensagen = "não econtroado";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		result.include("mensagem", "Tipo" + mensagen);
		result.redirectTo(this).listar();
	}
}
