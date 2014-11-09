package br.com.tsi4.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import br.com.tsi4.model.EspecialidadeMedica;
import br.com.tsi4.model.JDBC.Conectar;

public class EspecialidadesMedicaDAO implements ICRUD<EspecialidadeMedica> {

	private Connection connection;
	private PreparedStatement preparar;

	public EspecialidadesMedicaDAO() {
		connection = Conectar.getConnection();
	}

	@Override
	public long create(EspecialidadeMedica obj) throws SQLException {

		return -1;
	}

	@Override
	public long update(EspecialidadeMedica obj) throws SQLException {
		// TODO Auto-generated method stub
		return -1;
	}

	@Override
	public boolean delete(long pkKey) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<EspecialidadeMedica> restriveAll() throws SQLException {
		// TODO Auto-generated method stub
		List<EspecialidadeMedica> especialidadeMedicas = null;

		return especialidadeMedicas;
	}

	@Override
	public EspecialidadeMedica retriveOneByPkKey(long pkKLey)
			throws SQLException {
		EspecialidadeMedica especialidadeMedica = null;
		return especialidadeMedica;
	}

	@Override
	public List<EspecialidadeMedica> retriveByName(String nome)
			throws SQLException {
		List<EspecialidadeMedica> especialidades = null;
		return especialidades;
	}

}
