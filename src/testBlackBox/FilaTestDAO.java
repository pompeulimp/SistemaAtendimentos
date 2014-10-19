package testBlackBox;

import java.sql.SQLException;

import br.com.tsi4.model.Fila;
import br.com.tsi4.model.DAO.FilaDAO;
import br.com.tsi4.model.DAO.ICRUD;

public class FilaTestDAO {
	
	private ICRUD<Fila> FilaIcrud = new FilaDAO();

	private Fila obj = new Fila();
	

	public static void main(String[] args){
		
		try {
			new FilaTestDAO().cadastrarFila();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public  void cadastrarFila() throws SQLException{
		obj.setPk_fila(3);
		obj.setPk_atendimento(3);
		long pkkey = FilaIcrud.create(obj);
		System.out.println("Fila cadastrada com sucesso");
	}
	

}
