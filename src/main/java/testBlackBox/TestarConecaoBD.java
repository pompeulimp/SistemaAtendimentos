package testBlackBox;

import java.sql.Connection;

import br.com.tsi4.model.JDBC.Conectar;

public class TestarConecaoBD {

	public static void main(String[] args) {
		Connection con = Conectar.getConnection();
		
		if(con != null){
			System.out.println("Conectado");
		}else{
			System.out.println("Erro!!");
		}
	}

}
