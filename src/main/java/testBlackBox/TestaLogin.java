package testBlackBox;

import java.sql.SQLException;

import br.com.tsi4.model.Usuario;
import br.com.tsi4.model.DAO.UsuarioDAO;

public class TestaLogin {

	public static void main(String[] args) {
		Usuario usuario = new Usuario();
		UsuarioDAO dao = new UsuarioDAO();
		usuario.setPkUsuario(1);
		usuario.setPkHospital(1);
		usuario.setNomeUsuario("admin");
		usuario.setSenha("admin");
		
		
		try {
			dao.create(usuario);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println(dao.existe(usuario));

	}

}
