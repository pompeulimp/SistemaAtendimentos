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

	@Inject
	private Result result;
	private ICRUD<Hospital> icrud;
	@Inject
	private Hospital hospital;
	private String mensagen = null;

	public HospitalController() {
		this.icrud = new HospitalDAO();
	}

	public void formulario() {
	}

	public void create(Hospital hospital) {
		try {
			if (hospital.getPkHospital() != 0) {
				icrud.update(hospital);
				mensagen = "Cadastro atualizado com Sucesso";
			} else {
				icrud.create(hospital);
				mensagen = "Unidade criada com Sucesso";
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		result.include("mensagem", "Hospital " + mensagen + " com sucesso!");
		result.redirectTo(this).listar();
	}

	public List<Hospital>listar() {
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

	public void deletar(long pkKLey) {
		try {
			if (icrud.delete(pkKLey)) {
				mensagen = "deletado com sucesso !";
			} else {
				mensagen = " Unidade não econtrada!";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		result.include("mensagem", "Hospital " + mensagen);
		result.redirectTo(this).listar();
	}
}
