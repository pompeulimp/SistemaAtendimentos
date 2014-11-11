package br.com.tsi4.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.tsi4.model.Fila;
import br.com.tsi4.model.JDBC.Conectar;

public class FilaDAO implements ICRUD<Fila>{
	
	
	private Connection connection;
	private PreparedStatement preparar;

	public FilaDAO() {
		connection = Conectar.getConnection();
	}
	

	@Override
	public long create(Fila obj) throws SQLException {
		

			String sql = "insert into fila(pk_fila,pk_atendimento)"
					+ "values (?,?)";

			preparar = connection.prepareStatement(sql);
			preparar.setLong(1, obj.getPk_fila());
			preparar.setLong(2, obj.getPk_atendimento());
			
			preparar.execute();
			ResultSet rs = preparar.getGeneratedKeys();

			if (rs.next()) {
				return rs.getInt(1);
			}

			return -1;
	}

	@Override
	public long update(Fila obj) throws SQLException {
		
		String sql = "update fila set"
				+ "(pk_fila=?, pk_atendimento = ?)";

		preparar = connection.prepareStatement(sql);
		preparar.setLong(1, obj.getPk_fila());
		preparar.setLong(2, obj.getPk_atendimento());
		
		preparar.execute();
		ResultSet rs = preparar.getGeneratedKeys();

		if (rs.next()) {
			return rs.getInt(1);
		}

		return -1;
	}

	@Override
	public boolean delete(long pkKey) throws SQLException {
		
		String sql = "DELETE FROM fila WHERE pk_fila = ?";

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
	public List<Fila> restriveAll() throws SQLException {
		
		List<Fila> lFilas = new ArrayList<>();
		Fila fila;
		String sql = "select * from fila order by pk_atendimento";

		preparar = connection.prepareStatement(sql);

		ResultSet rs = preparar.executeQuery();

		while (rs.next()) {
			 fila = new Fila();

			fila.setPk_fila(rs.getLong("pk_fila"));
			fila.setPk_atendimento(rs.getLong("pk_atendimento"));
			
			lFilas.add(fila);
		}
		preparar.close();

		return lFilas;
	}

	@Override
	public Fila retriveOneByPkKey(long pkKLey) throws SQLException {
		
		Fila fila = null;

		String sql = "select * from fila where pk_fila=?";

		preparar = connection.prepareStatement(sql);
		preparar.setLong(1, pkKLey);
		ResultSet rs = preparar.executeQuery();

		while (rs.next()) {
			fila = new Fila();
			fila.setPk_fila(rs.getLong("pk_fila"));
			fila.setPk_atendimento(rs.getLong("pk_atendimento"));
			
		}
		preparar.close();

		return fila;
		
		
		
	}

	@Override
	public List<Fila> retriveByName(String nome) throws SQLException {
		return null;
	}

	
	
}
