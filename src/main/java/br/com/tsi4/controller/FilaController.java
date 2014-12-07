package br.com.tsi4.controller;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

import testBlackBox.IMedicoDAO;
import testBlackBox.IPacienteDAO;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.I18nMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.com.tsi4.model.Fila;
import br.com.tsi4.model.Medico;
import br.com.tsi4.model.Paciente;
import br.com.tsi4.model.DAO.FilaDAO;
import br.com.tsi4.model.DAO.ICRUD;

@Controller
@SessionScoped
public class FilaController implements Serializable {

	private static final long serialVersionUID = 1L;
	private Result result;
	private final ICRUD<Fila> icrud;
	private String mensagen = null;
	private final IPacienteDAO pacienteDAO;
	private final IMedicoDAO medicoDAO;
	private Fila fila;
	private final Validator validator;
	private Medico retriveByCRM;
	private Paciente retriveByCPF;

	@Inject
	public FilaController(Result result, Validator validator, FilaDAO fDao,
			IPacienteDAO pacienteDAO, IMedicoDAO medicoDAO) {
		this.icrud = fDao;
		this.result = result;
		this.validator = validator;
		this.pacienteDAO = pacienteDAO;
		this.medicoDAO = medicoDAO;
	}

	@Deprecated
	public FilaController() {
		this(null, null, null, null, null);
	}

	public void formulario() {
	}

	public void pacienteForm() {

	}

	public void addFila() {
		result.include(retriveByCRM);
		result.include(retriveByCPF);
	}

	public void medicoForm() {
		result.include(retriveByCRM);
		result.include(retriveByCPF);
	}

	public void create(Fila fila) {
		try {
			if (fila.getPkFila() != 0) {

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

	public void editar(Fila fila) {
		try {
			fila = icrud.retriveOneByPkKey(fila.getPkFila());
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

		if (cpf.matches("^\\d{11}$")) {
			try {
				retriveByCPF = pacienteDAO.retriveByCPF(cpf);
			} catch (SQLException e) {
				erroCPF("CPF INEXISTENTE");
			}

			result.include(retriveByCPF);
			result.redirectTo(this).pacienteForm();
		} else {
			erroCPF("CPF INVALIDO");
		}
	}

	@Post("/medico/crm")
	public void buscarMedicoByCRM(String crm) {
		if (crm.matches("^\\d{4,10}$")) {

			try {
				retriveByCRM = medicoDAO.retriveByCRM(crm);
			} catch (SQLException e) {
				erroCRM("CRM INEXISTENTE");
			}

			result.include(retriveByCRM);
			result.include(retriveByCPF);
			result.redirectTo(this).medicoForm();

		} else {
			erroCRM("CRM INVALIDO");
		}
	}

	@Post("/addPacienteFila")
	public void addPacienteFila(long pkPaciente, long pkMedico) {
		System.out.println(pkPaciente + " " + pkMedico);
		fila = new Fila(pkPaciente, pkMedico);
		try {
			icrud.create(fila);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		result.include(fila);
		result.redirectTo(this).listar();
	}

	private void erroCPF(String msg) {
		validator.add(new I18nMessage("erro", msg));
		validator.onErrorUsePageOf(this).pacienteForm();
	}

	private void erroCRM(String msg) {
		validator.add(new I18nMessage("erro", msg));
		validator.onErrorUsePageOf(this).medicoForm();
	}

}
