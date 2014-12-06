package br.com.tsi4.controller;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import testBlackBox.IMedicoDAO;
import testBlackBox.IPacienteDAO;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.tsi4.model.Fila;
import br.com.tsi4.model.Medico;
import br.com.tsi4.model.Paciente;
import br.com.tsi4.model.DAO.FilaDAO;
import br.com.tsi4.model.DAO.ICRUD;
import br.com.tsi4.model.DAO.MedicoDAO;
import br.com.tsi4.model.DAO.PacienteDAO;

@Controller
public class FilaController {

	@Inject
	private Result result;
	private Fila fila;
	private ICRUD<Fila> icrud;
	private String mensagen = null;
	private IPacienteDAO pacienteDAO;
	private IMedicoDAO medicoDAO;
	private Medico medico;
	private Paciente paciente;

	public void Fila() {
		icrud = new FilaDAO();
	}

	public void formulario() {
	}

	public void pacienteForm() {
	}

	public void medicoForm() {
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
		result.include("mensagem", "Tipo" + mensagen + " com sucesso!");
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


	@Post("/paciente/cpf")
	public void buscarPacienteByCPF(String cpf) {
		pacienteDAO = new PacienteDAO();
		System.out.println(cpf);
		try {
			paciente = pacienteDAO.retriveByCPF(cpf);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		result.include(paciente);
		result.redirectTo(this).pacienteForm();
	}

	@Post("/medico/crm")
	public void buscarMedicoByCRM(String crm) {
		medicoDAO = new MedicoDAO();
		System.out.println(crm);
		try {
			medico = medicoDAO.retriveByCRM(crm);
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		result.include(medico);
		result.redirectTo(this).medicoForm();
	}
}
