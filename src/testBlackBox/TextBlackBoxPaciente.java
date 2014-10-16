package testBlackBox;

import java.sql.SQLException;
import java.util.List;

import br.com.tsi4.model.Paciente;
import br.com.tsi4.model.DAO.ICRUD;
import br.com.tsi4.model.DAO.PacienteDAO;

public class TextBlackBoxPaciente {
	Paciente paciente;
	ICRUD<Paciente> icrudP = new PacienteDAO();

	public static void main(String[] args) {
		new TextBlackBoxPaciente().ListarTodos();
	}

	public void criar() {	
		paciente = new Paciente();
		paciente.setPk_paciente(3);
		paciente.setNomePaciente("Jose Oliveira 2");
		paciente.setCpfPaciente("12345678911");
		paciente.setTelefonePaciente("64344425251");
		paciente.setEnderecoPaciente("Rua Antonio Maciel Moraes");

		try {
			icrudP.create(paciente);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void ListarTodos(){
		List<Paciente> pacientes = null;
		try {
			 pacientes = icrudP.restriveAll();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Paciente paciente : pacientes) {
			System.out.println(paciente.getNomePaciente());
		}
		
	}
}
