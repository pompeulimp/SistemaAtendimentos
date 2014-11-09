package br.com.tsi4.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.tsi4.model.Paciente;
import br.com.tsi4.model.JDBC.Conectar;

public class PacienteDAO implements ICRUD<Paciente> {

	private Connection connection;
	private PreparedStatement preparar;

	public PacienteDAO() {
		connection = Conectar.getConnection();
	}

	@Override
	public long create(Paciente obj) throws SQLException {

		String sql = "insert into pacientes(nomepaciente,cpfPaciente,endPaciente,telpaciente)"
				+ "values (? , ? , ? , ?)";

		preparar = connection.prepareStatement(sql);
		
		
		preparar.setString(1, obj.getNomePaciente());
		preparar.setString(2, obj.getCpfPaciente());
		preparar.setString(3, obj.getEnderecoPaciente());
		preparar.setString(4, obj.getTelefonePaciente());

		preparar.execute();
		ResultSet rs = preparar.getGeneratedKeys();
		preparar.close();
		if (rs.next()) {
			return rs.getInt(1);
		}

		return -1;
	}

	@Override
	public long update(Paciente obj) throws SQLException {

		String sql = "update pacientes set nomepaciente=?,cpfPaciente=?,endPaciente=?,telpaciente=? where pk_paciente = ?";

		preparar = connection.prepareStatement(sql);

		preparar.setString(1, obj.getNomePaciente());
		preparar.setString(2, obj.getCpfPaciente());
		preparar.setString(3, obj.getEnderecoPaciente());
		preparar.setString(4, obj.getTelefonePaciente());
		preparar.setLong(5, obj.getPk_paciente());

		preparar.execute();
		
		preparar.close();
		
		
		
		return obj.getPk_paciente();
	}

	@Override
	public boolean delete(long pkKey) throws SQLException {

		String sql = "DELETE FROM PACIENTES WHERE pk_paciente=?";

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
	public List<Paciente> restriveAll() throws SQLException {

		List<Paciente> lPacientes = new ArrayList<>();
		Paciente paciente;
		String sql = "select * from pacientes order by pk_paciente";

		preparar = connection.prepareStatement(sql);

		ResultSet rs = preparar.executeQuery();

		while (rs.next()) {
			paciente = new Paciente();

			paciente.setPk_paciente(rs.getLong("pk_paciente"));
			paciente.setNomePaciente(rs.getString("nomepaciente"));
			paciente.setEnderecoPaciente(rs.getString("endpaciente"));
			paciente.setCpfPaciente(rs.getString("cpfpaciente"));
			paciente.setTelefonePaciente(rs.getString("telpaciente"));

			lPacientes.add(paciente);
		}
		preparar.close();

		return lPacientes;
	}

	@Override
	public Paciente retriveOneByPkKey(long pkKLey) throws SQLException {

		Paciente paciente = null;

		String sql = "select * from pacientes where pk_paciente=?";

		preparar = connection.prepareStatement(sql);
		preparar.setLong(1, pkKLey);
		ResultSet rs = preparar.executeQuery();

		while (rs.next()) {
			paciente = new Paciente();
			paciente.setPk_paciente(rs.getLong("pk_paciente"));
			paciente.setNomePaciente(rs.getString("nomepaciente"));
			paciente.setEnderecoPaciente(rs.getString("endpaciente"));
			paciente.setCpfPaciente(rs.getString("cpfpaciente"));
			paciente.setTelefonePaciente(rs.getString("telpaciente"));

		}
		preparar.close();

		return paciente;
	}

	@Override
	public List<Paciente> retriveByName(String nome) throws SQLException {

		List<Paciente> lPacientes = new ArrayList<>();
		Paciente paciente = null;
		String sql = "select * from pacientes where nomepaciente like ?";

		preparar = connection.prepareStatement(sql);
		preparar.setString(1, "%" + nome + "%");

		ResultSet rs = preparar.executeQuery();

		while (rs.next()) {
			paciente = new Paciente();
			paciente.setPk_paciente(rs.getLong("pk_paciente"));
			paciente.setNomePaciente(rs.getString("nomepaciente"));
			paciente.setEnderecoPaciente(rs.getString("endpaciente"));
			paciente.setCpfPaciente(rs.getString("cpfpaciente"));
			paciente.setTelefonePaciente(rs.getString("telpaciente"));
			lPacientes.add(paciente);
		}
		preparar.close();

		return lPacientes;
	}

}
