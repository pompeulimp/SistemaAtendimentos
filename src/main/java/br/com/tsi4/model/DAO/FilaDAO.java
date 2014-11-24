package br.com.tsi4.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.tsi4.model.Fila;
import br.com.tsi4.model.JDBC.Conectar;

public class FilaDAO implements ICRUD<Fila> {

	private Connection connection;
	private PreparedStatement preparar;

	public FilaDAO() {
		connection = Conectar.getConnection();
	}

	@Override
	public long create(Fila obj) throws SQLException {

		String sql = "insert into fila(pk_paciente ,status,"
				+ "hora_entrada, pk_medico)" + "values (?,?,?,?)";

		preparar = connection.prepareStatement(sql);
		preparar.setLong(1, obj.getpkPaciente());
		preparar.setBoolean(2, obj.getStatus());
		preparar.setTimestamp(3, new Timestamp(obj.getHoraEntrada()
				.getTimeInMillis()));
		preparar.setLong(4, obj.getPkMedico());
		preparar.execute();
		ResultSet rs = preparar.getGeneratedKeys();

		if (rs.next()) {
			return rs.getInt(1);
		}

		return -1;
	}

	@Override
	public long update(Fila obj) throws SQLException {

		String sql = "update fila set pk_paciente=?,status=?,"
				+ "hora_saida=?, pk_medico=? where pk_fila = ?";

		preparar = connection.prepareStatement(sql);
		preparar.setLong(1, obj.getpkPaciente());
		preparar.setBoolean(2, obj.getStatus());
		preparar.setTimestamp(3, new Timestamp(obj.getHoraSaida()
				.getTimeInMillis()));
		preparar.setLong(4, obj.getPkMedico());
		preparar.setLong(5, obj.getpkFila());

		preparar.execute();

		return obj.getpkFila();
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

		List<Fila> filas = new ArrayList<>();
		Fila fila;
		String sql = "select * from fila order by pk_fila";

		preparar = connection.prepareStatement(sql);

		ResultSet rs = preparar.executeQuery();

		while (rs.next()) {

			filas.add(null);
		}
		preparar.close();

		return filas;
	}

	/**
	 * esse metodo recebe uma chave primaria de um paciente e retorna uma sua a
	 * fila que ele pertence
	 */
	@Override
	public Fila retriveOneByPkKey(long pkKLey) throws SQLException {

		Fila fila = null;
		Calendar calendar = Calendar.getInstance();
		/*
		 * select * from (select * from pacientes join fila using(pk_paciente))
		 * pf where pk_paciente = 25 select * from (select * from pacientes join
		 * fila using(pk_paciente)) pf where pk_paciente = 25
		 */
		String sql = "select * from (select * from pacientes join fila using(pk_paciente)) pf where pf.pk_paciente=?";

		preparar = connection.prepareStatement(sql);
		preparar.setLong(1, pkKLey);
		ResultSet rs = preparar.executeQuery();

		while (rs.next()) {
			calendar.setTimeInMillis(rs.getTimestamp("hora_entrada").getTime());
			fila = new Fila(rs.getLong("pk_fila"), rs.getLong("pk_paciente"),
					rs.getLong("pk_medico"), calendar);
		}
		preparar.close();

		return fila;

	}

	@Override
	public List<Fila> retriveByName(String nome) throws SQLException {
		return null;
	}

}
