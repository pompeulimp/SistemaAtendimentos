package testBlackBox;

import java.sql.SQLException;

import br.com.tsi4.model.Medico;

import br.com.tsi4.model.DAO.ICRUD;
import br.com.tsi4.model.DAO.MedicoDAO;


public class MedicoTestDAO {
	
	
	Medico medico;
	ICRUD<Medico> icrudM = new MedicoDAO();

	public static void main(String[] args) {
		new MedicoTestDAO().criarMedico();
	}

	public void criarMedico() {		
		medico = new Medico();
		medico.setPkMedico(2);;
		medico.setCrm("12343");
		medico.setNomeMedico("Dr Juliano Gay");
		medico.setTelMedico("64344425251");
		medico.setDisponibilidade("a");
		
		System.out.println("Gravado o Medico");

		try {
			icrudM.create(medico);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
