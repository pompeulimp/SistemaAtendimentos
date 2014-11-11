package testBlackBox;

import java.sql.SQLException;
import java.util.Date;

import br.com.tsi4.model.Medico;
import br.com.tsi4.model.DAO.ICRUD;
import br.com.tsi4.model.DAO.MedicoDAO;

public class MedicoTestDAO {

	Medico medico;
	ICRUD<Medico> icrudM = new MedicoDAO();

	public static void main(String[] args) throws SQLException {
		Date inicio = new Date();
		System.out.println(new MedicoTestDAO().retriveOne(2).toString());
		Date fim = new Date();
		
		System.out.println(fim.getTime()-inicio.getTime());
	}

	public void criarMedico() {
		medico = new Medico();
		medico.setCrm("12343");
		medico.setNomeMedico("Dr Juliano Gay");
		medico.setTelMedico("64344425251");
		medico.setDisponibilidade("a");

		try {
			icrudM.create(medico);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public Medico retriveOne(long pkKey) throws SQLException{
		return icrudM.retriveOneByPkKey(pkKey);
	}
}
