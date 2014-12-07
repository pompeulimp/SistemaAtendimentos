package br.com.tsi4.controller;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.com.tsi4.model.Hospital;
import br.com.tsi4.model.DAO.HospitalDAO;
import br.com.tsi4.model.DAO.ICRUD;

@Controller
public class HospitalController {

	private Result result;
	private ICRUD<Hospital> icrud;
	private Hospital hospital;
	private String mensagen = null;

	@Inject
	public HospitalController(Result result, HospitalDAO hospitalDAO) {
		this.icrud = hospitalDAO;
		this.result = result;

	}

	@Deprecated
	public HospitalController() {
		this(null, null);
	}

	public void formulario() {
	}

	public void create(Hospital hospital) {
		try {
			if (hospital.getPkHospital() != 0) {
				icrud.update(hospital);
				mensagen = "atualizado";
			} else {
				icrud.create(hospital);
				mensagen = "criado";
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		result.include("mensagem", "Hospital " + mensagen + " com sucesso!");
		result.redirectTo(this).listar();
	}

	public List<Hospital> listar() {
		try {

			return icrud.restriveAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void editar(long pkKey) {
		try {
			hospital = icrud.retriveOneByPkKey(pkKey);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		result.include(hospital);
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
		result.include("mensagem", "Hospital " + mensagen);
		result.redirectTo(this).listar();
	}
}
