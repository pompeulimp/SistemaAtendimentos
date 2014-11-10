package br.com.tsi4.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.tsi4.model.Especialidade;

import br.com.tsi4.model.JDBC.Conectar;

public class EspMedicoDAO implements ICRUD<Especialidade>{
	
	private Connection connection;
	private PreparedStatement preparar;

	public EspMedicoDAO() {
		connection = Conectar.getConnection();
	}

	@Override
	public long create(Especialidade obj) throws SQLException {
		String sql = "insert into especialidades(pk_especialidade,descricao)"
				+ "values (? , ?)";

		preparar = connection.prepareStatement(sql);
		preparar.setLong(1, obj.getPkEspecialidade());
		preparar.setString(2, obj.getDescricao());
		
		preparar.execute();
		ResultSet rs = preparar.getGeneratedKeys();

		if (rs.next()) {
			return rs.getInt(1);
		}

		return -1;
	}

	@Override
	public long update(Especialidade obj) throws SQLException {
		String sql = "update especialidades set"
				+ "(descricao=?)";

		preparar = connection.prepareStatement(sql);
		preparar.setLong(1, obj.getPkEspecialidade());
		preparar.setString(2, obj.getDescricao());
		
		preparar.execute();
		ResultSet rs = preparar.getGeneratedKeys();

		if (rs.next()) {
			return rs.getInt(1);
		}

		return -1;
	}

	@Override
	public boolean delete(long pkKey) throws SQLException {
		String sql = "DELETE FROM especialidades WHERE id=?";

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
	public List<Especialidade> restriveAll() throws SQLException {
		List<Especialidade> lEspecialidadeMedica = new ArrayList<>();
		Especialidade esp;
		String sql = "select * from especialidades order by descricao";

		preparar = connection.prepareStatement(sql);

		ResultSet rs = preparar.executeQuery();

		while (rs.next()) {
			 esp = new Especialidade();

			esp.setPkEspecialidade(rs.getLong("pk_especialidade"));
			esp.setDescricao(rs.getString("descricao"));
			
			lEspecialidadeMedica.add(esp);
		}
		preparar.close();

		return lEspecialidadeMedica;
	}

	@Override
	public Especialidade retriveOneByPkKey(long pkKLey)
			throws SQLException {
		
		Especialidade Esp = null;

		String sql = "select * from especialidades where pk_especialidade=?";

		preparar = connection.prepareStatement(sql);
		preparar.setLong(1, pkKLey);
		ResultSet rs = preparar.executeQuery();

		while (rs.next()) {
			Esp = new Especialidade();
			Esp.setPkEspecialidade(rs.getLong("pk_especialidade"));
			Esp.setDescricao(rs.getString("descricao"));
			
		}
		preparar.close();

		return Esp;
		
		
	}

	@Override
	public List<Especialidade> retriveByName(String nome)
			throws SQLException {
		
		List<Especialidade> lEsp = new ArrayList<>();
		Especialidade esp = null;
		String sql = "select * from especialidades where descricao like ?";

		preparar = connection.prepareStatement(sql);
		preparar.setString(1, "%" + nome + "%");

		ResultSet rs = preparar.executeQuery();

		while (rs.next()) {
			esp = new Especialidade();
			esp.setPkEspecialidade(rs.getLong("pk_especialidade"));
			esp.setDescricao(rs.getString("descricao"));
			lEsp.add(esp);
		}
		preparar.close();

		return lEsp;
		
	}


	

}
