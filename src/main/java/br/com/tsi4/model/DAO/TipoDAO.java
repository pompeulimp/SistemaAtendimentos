package br.com.tsi4.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.tsi4.model.Tipo;
import br.com.tsi4.model.JDBC.Conectar;

public class TipoDAO implements ICRUD<Tipo> {

	private Connection connection;
	private PreparedStatement preparar;

	public TipoDAO() {
		connection = Conectar.getConnection();
	}

	@Override
	public long create(Tipo obj) throws SQLException {

		String sql = "insert into tipoatendimento (descricaotipo,tempoestimado) values (?,?)";
		preparar = connection.prepareStatement(sql);

		preparar.setString(1, obj.getDescricaoTipo());
		preparar.setDouble(2, obj.getTempoEstimado());

		preparar.execute();

		ResultSet rs = preparar.getGeneratedKeys();

		if (rs.next()) {
			return rs.getInt(1);
		}
		return -1;
	}

	@Override
	public long update(Tipo obj) throws SQLException {
		String sql = "update tipoatendimento set descricaotipo=?, tempoestimado=? where pk_tipo=?";

		preparar = connection.prepareStatement(sql);
		preparar.setString(1, obj.getDescricaoTipo());
		preparar.setDouble(2, obj.getTempoEstimado());

		preparar.execute();
		ResultSet rs = preparar.getGeneratedKeys();

		if (rs.next()) {
			return rs.getInt(1);
		}
		return -1;
	}

	@Override
	public boolean delete(long pkKey) throws SQLException {

		String sql = "delete from tipoatendimento where pktipoatendimento=?";

		preparar = connection.prepareStatement(sql);
		preparar.setLong(1, pkKey);
		preparar.execute();

		if (retriveOneByPkKey(pkKey) == null) {
			return true;
		}

		return false;
	}

	@Override
	public List<Tipo> restriveAll() throws SQLException {

		List<Tipo> tipoatendimentos = new ArrayList<>();
		
		Tipo tipo;

		String sql = "select * from tipoatendimento";

		preparar = connection.prepareStatement(sql);

		ResultSet rs = preparar.executeQuery();

		while (rs.next()) {
			tipo = new Tipo();
			tipo.setPkTipoAtendimento(rs.getLong("pk_tipo"));
			tipo.setDescricaoTipo(rs.getString("descricaotipo"));
			tipo.setTempoEstimado(rs.getDouble("tempoEstimado"));
			tipoatendimentos.add(tipo);
		}
		preparar.close();

		return tipoatendimentos;
	}

	@Override
	public Tipo retriveOneByPkKey(long pkKLey) throws SQLException {
		Tipo tipo= null;

		String sql = "select * from tipoatendimento where pk_tipo=?";

		preparar = connection.prepareStatement(sql);
		preparar.setLong(1, pkKLey);
		ResultSet rs = preparar.executeQuery();

		while (rs.next()) {
			tipo= new Tipo();
			tipo.setPkTipoAtendimento(rs.getLong("pk_tipo"));
			tipo.setDescricaoTipo(rs.getString("descricaotipo"));
			tipo.setTempoEstimado(rs.getDouble("tempoEstimado"));

		}
		preparar.close();
		return tipo;
	}

	@Override
	public List<Tipo> retriveByName(String nome) throws SQLException {
		List<Tipo> tipoatendimentos = new ArrayList<>();
		Tipo tipo = null;
		String sql = "select * from tipoatendimento where descricaotipo like ?";

		preparar = connection.prepareStatement(sql);
		preparar.setString(1, "%" + nome + "%");

		ResultSet rs = preparar.executeQuery();

		while (rs.next()) {
			tipo = new Tipo();
			tipo.setPkTipoAtendimento(rs.getLong("pk_tipo"));
			tipo.setDescricaoTipo(rs.getString("descricaotipo"));
			tipo.setTempoEstimado(rs.getDouble("tempoEstimado"));
			tipoatendimentos.add(tipo);
		}
		preparar.close();

		return tipoatendimentos;

	}
	
	

}

