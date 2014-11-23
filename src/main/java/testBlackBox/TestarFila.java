package testBlackBox;

import java.sql.SQLException;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;
import br.com.tsi4.model.Fila;
import br.com.tsi4.model.Medico;
import br.com.tsi4.model.Paciente;
import br.com.tsi4.model.DAO.FilaDAO;
import br.com.tsi4.model.DAO.ICRUD;
import br.com.tsi4.model.DAO.MedicoDAO;
import br.com.tsi4.model.DAO.PacienteDAO;

public class TestarFila {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testeEntradaNaFilaAtendimentos() throws SQLException {
//		// pegar Paciente usando seu nome;
//		ICRUD<Paciente> icrudPanciente = new PacienteDAO();
//		List<Paciente> pacientes = icrudPanciente.retriveByName("Jose");
//		for (Paciente p : pacientes) {
//			System.out.println(p.toString());
//		}
//		ICRUD<Medico> icrudMedico = new MedicoDAO();
//		List<Medico> medicosbyName = icrudMedico.retriveByName("Jacinto");
//		for (Medico m : medicosbyName) {
//			System.out.println(m.toString());
//		}
//
//		Fila fila = new Fila(pacientes.get(0).getPk_paciente(), medicosbyName
//				.get(0).getPkMedico());
		/*
		 * ICRUD<Fila> icrudFila = new FilaDAO();
		 * 
		 * long create = icrudFila.create(fila); assertTrue(create != 0);
		 */

	}

	@Test
	public void testeAtulizarFilaAtendimentos() throws SQLException {

		ICRUD<Paciente> icrudPaciente = new PacienteDAO();
		List<Paciente> pacientes = icrudPaciente.retriveByName("Pompeu");
		for (Paciente p : pacientes) {
			System.out.println(p.toString());
		}

		long pkKLey = pacientes.get(0).getPk_paciente();
		ICRUD<Fila> icrudFila = new FilaDAO();
		Fila fila = icrudFila.retriveOneByPkKey(pkKLey);
		System.out.println(fila.toString());

	}
}
