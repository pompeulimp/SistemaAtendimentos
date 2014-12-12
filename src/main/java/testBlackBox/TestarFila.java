package testBlackBox;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

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
	
	public void testeEntradaNaFilaAtendimentos() throws SQLException {

		Fila fila = new Fila(32, 5);

		ICRUD<Fila> icrudFila = new FilaDAO();

		long create = icrudFila.create(fila);
		assertTrue(create != 0);

	}

	public void testeAtulizarFilaAtendimentos() throws SQLException {

		ICRUD<Paciente> icrudPaciente = new PacienteDAO();
		List<Paciente> pacientes = icrudPaciente.retriveByName("Pompeu");
		for (Paciente p : pacientes) {
			System.out.println(p.toString());
		}

		long pkKLey = pacientes.get(0).getPk_paciente();
		ICRUD<Fila> icrudFila = new FilaDAO();
		Fila fila = icrudFila.retriveOneByPkKey(pkKLey);
		assertTrue(fila != null);
	}

	public void deletarPacienteDaFila() throws SQLException {

		ICRUD<Paciente> icrudPaciente = new PacienteDAO();
		List<Paciente> pacientes = icrudPaciente.retriveByName("Jose");
		for (Paciente p : pacientes) {
			System.out.println(p.toString());
		}
		long pkKLey = pacientes.get(0).getPk_paciente();
		ICRUD<Fila> icrudFila = new FilaDAO(); // pegando paciente em uma fila
												// Fila fila =

		Fila fila = icrudFila.retriveOneByPkKey(pkKLey);
		assertTrue(icrudFila.delete(fila.getPkFila()));

	}

	@Test
	public void testeUpdateStatusFila() throws SQLException {

		IPacienteDAO daoPaciente = new PacienteDAO();
		Paciente paciente = daoPaciente.retriveByCPF("00311920179");
		assertEquals(paciente.getCpfPaciente(), "00311920179");

		IMedicoDAO daoMedico = new MedicoDAO();
		Medico medico = daoMedico.retriveByCRM("12345");
		assertEquals(medico.getCrm(), "12345");

		long pkKLey = paciente.getPk_paciente();
		
		ICRUD<Fila> icrudFila = new FilaDAO();

		Fila fila = icrudFila.retriveOneByPkKey(pkKLey);
		fila.setStatus(false);
		
		long fk_fila = icrudFila.update(fila);
		assertTrue(fila.getHoraSaida().getTimeInMillis() != 0);
		assertTrue(fk_fila > 0);
	}
	
	@Test
	public void deveCriarUmFilaPorMedico(){
		
	}

}
