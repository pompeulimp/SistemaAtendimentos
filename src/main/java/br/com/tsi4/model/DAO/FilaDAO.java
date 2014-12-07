package br.com.tsi4.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.tsi4.model.Fila;

@RequestScoped
public class FilaDAO implements ICRUD<Fila> {

	private Connection connection;
	private PreparedStatement preparar;

	@Inject
	public FilaDAO(Connection connection) {
		this.connection = connection;
	}

	@Deprecated
	public FilaDAO() {
		this(null);
	}

	@Override
	public long create(Fila obj) throws SQLException {

		String sql = "insert into fila(pk_paciente ,status,"
				+ "hora_entrada, pk_medico)" + "values (?,?,?,?)";

		preparar = connection.prepareStatement(sql);
		preparar.setLong(1, obj.getPkPaciente());
		preparar.setBoolean(2, obj.isStatus());
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

		String sql = "update fila set status=?,"
				+ "hora_saida=? where pk_fila = ?";

		preparar = connection.prepareStatement(sql);

		preparar.setBoolean(1, obj.isStatus());
		preparar.setTimestamp(2, new Timestamp(obj.getHoraSaida()
				.getTimeInMillis()));
		preparar.setLong(3, obj.getPkFila());

		preparar.execute();

		return obj.getPkFila();
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

		String sql = "select * from fila order by pk_fila";

		preparar = connection.prepareStatement(sql);

		ResultSet rs = preparar.executeQuery();
		Calendar entrada = Calendar.getInstance();
		Calendar saida = Calendar.getInstance();
		while (rs.next()) {
			entrada.setTimeInMillis(rs.getTimestamp("hora_entrada").getTime());
			//saida.setTimeInMillis(rs.getTimestamp("hora_saida").getTime());
			filas.add(new Fila(rs.getLong("pk_fila"),
					rs.getLong("pk_paciente"), rs.getLong("pk_medico"),rs.getBoolean("status"),
					entrada, saida));
		}
		preparar.close();

		return filas;
	}

	/**
	 * esse metodo recebe uma chave primaria de um paciente e retorna a fila que
	 * ele pertence
	 */
	@Override
	public Fila retriveOneByPkKey(long pkKLey) throws SQLException {

		Fila fila = null;
		Calendar entrada = Calendar.getInstance();
		Calendar saida = Calendar.getInstance();
		String sql = "select * from (select * from pacientes join fila using(pk_paciente)) pf where pf.pk_paciente=?";

		preparar = connection.prepareStatement(sql);
		preparar.setLong(1, pkKLey);
		ResultSet rs = preparar.executeQuery();

		while (rs.next()) {
			entrada.setTimeInMillis(rs.getTimestamp("hora_entrada").getTime());

			fila = new Fila(rs.getLong("pk_fila"), rs.getLong("pk_paciente"),
					rs.getLong("pk_medico"),rs.getBoolean("status"), entrada, saida);
		}
		preparar.close();

		return fila;

	}

	@Override
	public List<Fila> retriveByName(String nome) throws SQLException {
		return null;
	}

}
