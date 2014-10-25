package br.com.tsi4.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.tsi4.model.Medico;
import br.com.tsi4.model.Paciente;
import br.com.tsi4.model.JDBC.Conectar;

public class MedicoDAO implements ICRUD<Medico>{
	
	private Connection connection;
	private PreparedStatement preparar;

	public MedicoDAO() {
		connection = Conectar.getConnection();
	}

	@Override
	public long create(Medico obj) throws SQLException {
		String sql = "insert into medicos (pk_medico,crm,nomemedico,telmedico,disponibilidade)"
				+ "values (? ,? , ? , ?, ?)";

		preparar = connection.prepareStatement(sql);
		
		preparar.setLong(1, obj.getPkMedico());
		preparar.setString(2, obj.getCrm());
		preparar.setString(3, obj.getNomeMedico());
		preparar.setString(4, obj.getTelMedico());
		preparar.setString(5, obj.getDisponibilidade());

		preparar.execute();
		ResultSet rs = preparar.getGeneratedKeys();

		if (rs.next()) {
			return rs.getInt(1);
		}

		return -1;
	}


	@Override
	public long update(Medico obj) throws SQLException {
		String sql = "update medicos set"
				+ "(crm =? nomemedico=?,telmedico=?,disponibilidade=?)";

		preparar = connection.prepareStatement(sql);

		preparar.setString(1, obj.getCrm());
		preparar.setString(2, obj.getNomeMedico());
		preparar.setString(3, obj.getTelMedico());
		preparar.setString(4, obj.getDisponibilidade());

		preparar.execute();
		ResultSet rs = preparar.getGeneratedKeys();

		if (rs.next()) {
			return rs.getInt(1);
		}
		return -1;
	}

	@Override
	public boolean delete(Medico obj) throws SQLException {
		
		String sql = "DELETE FROM medicos WHERE pk_medico=?";

		preparar = connection.prepareStatement(sql);
		preparar.setLong(1, obj.getPkMedico());
		preparar.execute();
		preparar.close();

		if (retriveOneByPkKey(obj.getPkMedico()) == null) {
			return true;
		}

		return false;
	}

	@Override
	public List<Medico> restriveAll() throws SQLException {
		List<Medico> lMedicos = new ArrayList<>();
		Medico medico;
		String sql = "select * from medicos order by nomemedico";

		preparar = connection.prepareStatement(sql);

		ResultSet rs = preparar.executeQuery();

		while (rs.next()) {
			medico = new Medico();

			medico.setPkMedico(rs.getInt("pk_medico"));
			medico.setCrm(rs.getString("crm"));
			medico.setNomeMedico(rs.getString("nomemedico"));
			medico.setTelMedico(rs.getString("telmedico"));
			medico.setDisponibilidade(rs.getString("disponibilidade"));

			lMedicos.add(medico);
		}
		preparar.close();

		return lMedicos;
	}

	@Override
	public Medico retriveOneByPkKey(long pkKLey) throws SQLException {
		Medico medico = null;

		String sql = "select * from medicos where pk_medico=?";

		preparar = connection.prepareStatement(sql);
		preparar.setLong(1, pkKLey);
		ResultSet rs = preparar.executeQuery();

		while (rs.next()) {
			medico = new Medico();
			medico.setPkMedico(rs.getInt("pk_medico"));
			medico.setCrm(rs.getString("crm"));
			medico.setNomeMedico(rs.getString("nomemedico"));
			medico.setTelMedico(rs.getString("telmedico"));
			medico.setDisponibilidade(rs.getString("disponibilidade"));

		}
		preparar.close();

		return medico;
	
	}

	@Override
	public List<Medico> retriveByName(String nome) throws SQLException {
		List<Medico> lMedicos = new ArrayList<>();
		Medico medico = null;
		String sql = "select * from medicos where nomemedico like ?";

		preparar = connection.prepareStatement(sql);
		preparar.setString(1, "%" + nome + "%");

		ResultSet rs = preparar.executeQuery();

		while (rs.next()) {
			medico = new Medico();
			medico.setPkMedico(rs.getInt("pk_medico"));
			medico.setCrm(rs.getString("crm"));
			medico.setNomeMedico(rs.getString("nomemedico"));
			medico.setTelMedico(rs.getString("telmedico"));
			medico.setDisponibilidade(rs.getString("disponibilidade"));
			lMedicos.add(medico);
		}
		preparar.close();

		return lMedicos;
	}

	

}
