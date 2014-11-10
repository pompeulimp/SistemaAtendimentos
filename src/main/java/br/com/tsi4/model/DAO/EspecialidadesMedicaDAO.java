package br.com.tsi4.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.tsi4.model.Especialidade;
import br.com.tsi4.model.JDBC.Conectar;

public class EspecialidadesMedicaDAO implements ICRUD<Especialidade> {

	private Connection connection;
	private PreparedStatement preparar;

	public EspecialidadesMedicaDAO() {
		connection = Conectar.getConnection();
	}

	@Override
	public long create(Especialidade obj) throws SQLException {

		String sql = "insert into especialidades (descricao) values (?)";
		preparar = connection.prepareStatement(sql);

		preparar.setString(1, obj.getDescricao());

		preparar.execute();

		ResultSet rs = preparar.getGeneratedKeys();

		if (rs.next()) {
			return rs.getInt(1);
		}
		return -1;
	}

	@Override
	public long update(Especialidade obj) throws SQLException {
		String sql = "update especialidades set descricao=? where pk_especialidade=?";

		preparar = connection.prepareStatement(sql);
		preparar.setString(1, obj.getDescricao());
		preparar.setLong(2, obj.getPkEspecialidade());

		preparar.execute();
		ResultSet rs = preparar.getGeneratedKeys();

		if (rs.next()) {
			return rs.getInt(1);
		}
		return -1;
	}

	@Override
	public boolean delete(long pkKey) throws SQLException {

		String sql = "delete from especialidades where pk_especialidade=?";

		preparar = connection.prepareStatement(sql);
		preparar.setLong(1, pkKey);
		preparar.execute();

		if (retriveOneByPkKey(pkKey) == null) {
			return true;
		}

		return false;
	}

	@Override
	public List<Especialidade> restriveAll() throws SQLException {

		List<Especialidade> especialidadeMedicas = new ArrayList<>();
		Especialidade especialidadeMedica;

		String sql = "select * from especialidades";

		preparar = connection.prepareStatement(sql);

		ResultSet rs = preparar.executeQuery();

		while (rs.next()) {
			especialidadeMedica = new Especialidade();
			especialidadeMedica.setPkEspecialidade(rs
					.getLong("pk_especialidade"));
			especialidadeMedica.setDescricao(rs.getString("descricao"));
			especialidadeMedicas.add(especialidadeMedica);
		}
		preparar.close();

		return especialidadeMedicas;
	}

	@Override
	public Especialidade retriveOneByPkKey(long pkKLey)
			throws SQLException {
		Especialidade especialidadeMedica = null;

		String sql = "select * from especialidades where pk_especialidade=?";

		preparar = connection.prepareStatement(sql);
		preparar.setLong(1, pkKLey);
		ResultSet rs = preparar.executeQuery();

		while (rs.next()) {
			especialidadeMedica = new Especialidade();
			especialidadeMedica.setPkEspecialidade(rs
					.getLong("pk_especialidade"));
			especialidadeMedica.setDescricao(rs.getString("descricao"));

		}
		preparar.close();
		return especialidadeMedica;
	}

	@Override
	public List<Especialidade> retriveByName(String nome)
			throws SQLException {
		List<Especialidade> especialidades = null;
		return especialidades;
	}

}
