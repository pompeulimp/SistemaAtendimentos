package testBlackBox;

import java.sql.SQLException;

import br.com.tsi4.model.Hospital;
import br.com.tsi4.model.DAO.HospitalDAO;
import br.com.tsi4.model.DAO.ICRUD;

public class HospitalTestDAO {
	
	Hospital hospital;
	ICRUD<Hospital> icrudH = new HospitalDAO();

	public static void main(String[] args) {
		new HospitalTestDAO().criarHospital();
	}

	public void criarHospital() {		
		hospital = new Hospital();
		hospital.setPkHospital(2);
		hospital.setPkFila(1);
		hospital.setRazaosocial("Hopital Odeilio Prudencio ltda");
		hospital.setNomeFantasia("Hospital Odelio Prudencio");
		hospital.setCnpj("9870987987");
		hospital.setEnderecoHospital("Rua Minas Gerais");	
		hospital.setTelefonehospital("98 9867 6979");
		
		System.out.println("Hospital Gravado com Sucesso");

		try {
			icrudH.create(hospital);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	

}
