package testBlackBox;

import java.sql.SQLException;

import br.com.tsi4.model.Paciente;
import br.com.tsi4.model.DAO.ICRUD;
import br.com.tsi4.model.DAO.PacienteDAO;

public class TextBlackBoxPaciente {
	
	ICRUD<Paciente> icrudP = new PacienteDAO();
	Paciente paciente;
	public static void main(String[] args) {
		new TextBlackBoxPaciente().criar();
	}

	public void criar() {		
		paciente = new Paciente();
		paciente.setNomePaciente("asdfasd Oliveira");
		paciente.setCpfPaciente("12345678911");
		paciente.setTelefonePaciente("64344425251");
		paciente.setEnderecoPaciente("Rua Antonio Maciel Moraes");
		
		System.out.println("Gravado o Paciente");

		try {
			icrudP.create(paciente);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void upadate(){
		
	}
}
