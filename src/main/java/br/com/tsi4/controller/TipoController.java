package br.com.tsi4.controller;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.com.tsi4.model.Tipo;
import br.com.tsi4.model.DAO.ICRUD;
import br.com.tsi4.model.DAO.TipoDAO;


@Controller
public class TipoController {

	
	private Result result;
	private final ICRUD<Tipo> icrud;
	private Tipo tipo;
	private String mensagen = null;
	
	@Inject
	public TipoController(Result result, TipoDAO tipoDAO) {
		this.icrud = tipoDAO;
		this.result = result;
	}
	@Deprecated
	public TipoController() {
		this(null,null);
	}
	public void formulario() {
	}

	public void create(Tipo tipo) {

		try {
			if (tipo.getPkTipoAtendimento() != 0) {
				icrud.update(tipo);
				mensagen = "atualizado";
			} else {
				icrud.create(tipo);
				mensagen = "criado";
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		result.include("mensagem", "Tipo" + mensagen
				+ " com sucesso!");
		result.redirectTo(this).listar();
	}

	public List<Tipo> listar() {
		try {

			return icrud.restriveAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void editar(long pkKey) {
		try {
			tipo = icrud.retriveOneByPkKey(pkKey);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		result.include(tipo);
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
		result.include("mensagem", "Tipo" + mensagen);
		result.redirectTo(this).listar();
	}
}

