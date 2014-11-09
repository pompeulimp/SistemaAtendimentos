package br.com.tsi4.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.tsi4.model.Usuario;
import br.com.tsi4.model.JDBC.Conectar;

public class UsuarioDAO implements ICRUD<Usuario> {

	private Connection connection;
	private PreparedStatement preparar;

	public UsuarioDAO() {
		connection = Conectar.getConnection();
	}
	
	public boolean existe(Usuario usuario){
		String sql = "SELECT NOMEUSUARIO, SENHA FROM USUARIOS WHERE NOMEUSUARIO =? AND SENHA=?";
		
		try{
			preparar = connection.prepareStatement(sql);
			preparar.setString(1, usuario.getNomeUsuario());
			preparar.setString(2, usuario.getSenha());
			
			ResultSet rs = preparar.executeQuery();
			return rs.next();
			
		} catch(SQLException e){
			System.out.println("Ocorreu um erro: ");e.getMessage();
		}
		usuario.setNomeUsuario("admin");
		
		return false;
	}

	@Override
	public long create(Usuario obj) throws SQLException {
		String sql = "insert into usuarios(pk_hospital,nomeusuario,senha,nivelusuario)"
				+ "values (? , ? , ? , ?)";

		preparar = connection.prepareStatement(sql);

		preparar.setLong(1, obj.getPkHospital());
		preparar.setString(2, obj.getNomeUsuario());
		preparar.setString(3, obj.getSenha());
		preparar.setString(4, obj.getNivelusuario());

		preparar.execute();
		ResultSet rs = preparar.getGeneratedKeys();

		if (rs.next()) {
			return rs.getInt(1);
		}

		return -1;
	}

	@Override
	public long update(Usuario obj) throws SQLException {
		String sql = "update usuarios set"
				+ "(nomeusuario=?,senha=?,nivelusuario=?)";
		preparar = connection.prepareStatement(sql);

		preparar.setString(1, obj.getNomeUsuario());
		preparar.setString(2, obj.getSenha());
		preparar.setString(3, obj.getNivelusuario());
		preparar.execute();
		ResultSet rs = preparar.getGeneratedKeys();

		if (rs.next()) {
			return rs.getInt(1);
		}

		return -1;

	}

	@Override
	public boolean delete(long pkKey) throws SQLException {

		String sql = "DELETE FROM USUARIOS WHERE pk_usuario=?";

		preparar = connection.prepareStatement(sql);
		preparar.setLong(1, pkKey);
		preparar.execute();
		preparar.close();

		if (retriveOneByPkKey(pkKey) == null) {
			return true;
		}

		return false;
	}

	@Override
	public List<Usuario> restriveAll() throws SQLException {

		List<Usuario> lisUsuarios = new ArrayList<>();
		Usuario usuario;
		String sql = "select * from usuarios order by nomeusuario";

		preparar = connection.prepareStatement(sql);

		ResultSet rs = preparar.executeQuery();

		while (rs.next()) {
			usuario = new Usuario();

			usuario.setPkUsuario(rs.getLong("pk_usuario"));
			usuario.setPkHospital(rs.getLong("pk_hospital"));
			usuario.setNomeUsuario(rs.getNString("nomeusuario"));
			usuario.setSenha(rs.getNString("senha"));
			usuario.setNivelusuario(rs.getNString("nivelusuario"));

			lisUsuarios.add(usuario);
		}
		preparar.close();

		return lisUsuarios;
	}

	@Override
	public Usuario retriveOneByPkKey(long pkKLey) throws SQLException {

		Usuario usuario = null;

		String sql = "select * from usuarios where pk_usuario = ?";

		preparar = connection.prepareStatement(sql);
		preparar.setLong(1, pkKLey);
		ResultSet rs = preparar.executeQuery();

		while (rs.next()) {
			usuario = new Usuario();
			usuario.setPkHospital(rs.getLong("pk_hospital"));
			usuario.setPkUsuario(rs.getLong("pk_usuario"));
			usuario.setNomeUsuario(rs.getString("nomeUsuario"));
			usuario.setSenha(rs.getString("senha"));
			usuario.setNivelusuario(rs.getString("nivelusuario"));

		}
		preparar.close();

		return usuario;
	}

	@Override
	public List<Usuario> retriveByName(String nome) throws SQLException {

		List<Usuario> lisUsuarios = new ArrayList<>();
		Usuario usuario;
		String sql = "select * from usuarios where nomeusuario like ?";

		preparar = connection.prepareStatement(sql);
		preparar.setString(1, "%" + nome + "%");

		ResultSet rs = preparar.executeQuery();

		while (rs.next()) {
			usuario = new Usuario();
			usuario.setPkUsuario(rs.getLong("pk_usuario"));
			usuario.setPkHospital(rs.getLong("pk_hospital"));
			usuario.setNomeUsuario(rs.getNString("nomeusuario"));
			usuario.setSenha(rs.getNString("senha"));
			usuario.setNivelusuario(rs.getNString("nivelusuario"));

			lisUsuarios.add(usuario);
		}
		preparar.close();

		return lisUsuarios;
	}

}
