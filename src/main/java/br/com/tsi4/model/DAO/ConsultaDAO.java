package br.com.tsi4.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.caelum.vraptor.serialization.xstream.CalendarConverter;
import br.com.tsi4.model.Consulta;
import br.com.tsi4.model.Especialidade;
import br.com.tsi4.model.JDBC.Conectar;

public class ConsultaDAO implements ICRUD<Consulta> {
	private Connection connection;
	private PreparedStatement preparar;

	@Override
	public long create(Consulta obj) throws SQLException {
		String sql = "insert into consulta(pk_consulta, pk_medico, pk_hospital, pk_paciente, pk_atendimento, inicio_consulta, fim_consulta)" +
			      "values(?,?,?,?,?,?,?)";
		
		preparar = connection.prepareStatement(sql);

		preparar.setLong(1, obj.getPk_consulta());
		preparar.setLong(2, obj.getPk_medico());
		preparar.setLong(3, obj.getPk_hospital());		
		preparar.setLong(4, obj.getPk_paciente());
		preparar.setLong(5, obj.getPk_atendimento());		
		preparar.setDate(6, new java.sql.Date(obj.getInicioConsulta().getTime()));
		preparar.setDate(7, new java.sql.Date(obj.getFimConsulta().getTime()));
		
		preparar.execute();

		ResultSet rs = preparar.getGeneratedKeys();

		if (rs.next()) {
			return rs.getInt(1);
		}
		return -1;
	}

	@Override
	public long update(Consulta obj) throws SQLException {
		
		return 0;
	}

	@Override
	public boolean delete(long pkKey) throws SQLException {
		String sql = "delete from consulta where pk_consulta=?";
		
		preparar.setLong(1, pkKey);
		preparar.execute();
		
		if (retriveOneByPkKey(pkKey) == null) {
			return true;
		}

		return false;
	}

	@Override
	public List<Consulta> restriveAll() throws SQLException {
		List<Consulta> consultas = new ArrayList<Consulta>();
		Consulta consulta;
		
		String sql = "select * from consulta";
		
		preparar =  connection.prepareStatement(sql);
		
		ResultSet rs = preparar.executeQuery();
		
		while (rs.next()) {
			consulta = new Consulta();
			consulta.setPk_consulta(rs.getLong("pk_consulta"));
			consulta.setPk_atendimento(rs.getLong("pk_atendimento"));
			consulta.setPk_hospital(rs.getLong("pk_hospital"));
			consulta.setPk_medico(rs.getLong("pk_medico"));
			consulta.setPk_paciente(rs.getLong("pk_paciente"));
			consulta.setInicioConsulta(rs.getDate("inicio_consulta"));
			consulta.setFimConsulta(rs.getDate("inicio_consulta"));			
			
			consultas.add(consulta);
		}
		preparar.close();

		return consultas;
	}

	@Override
	public Consulta retriveOneByPkKey(long pkKLey) throws SQLException {
		String sql = "select * from consulta where pk_consulta = ?";
		Consulta consulta = null;
		
		preparar = connection.prepareStatement(sql);
		
		ResultSet rs = preparar.executeQuery();
		
		while (rs.next()) {
			consulta = new Consulta();
			consulta.setPk_consulta(rs.getLong("pk_consulta"));
			consulta.setPk_atendimento(rs.getLong("pk_atendimento"));
			consulta.setPk_hospital(rs.getLong("pk_hospital"));
			consulta.setPk_medico(rs.getLong("pk_medico"));
			consulta.setPk_paciente(rs.getLong("pk_paciente"));
			consulta.setInicioConsulta(rs.getDate("inicio_consulta"));
			consulta.setFimConsulta(rs.getDate("fim_consulta"));			
		}
		preparar.close();
		return consulta;
	}

	@Override
	public List<Consulta> retriveByName(String nome) throws SQLException {
//		List<Consulta> consultas = new ArrayList<Consulta>();
//		Consulta consulta = null;
//		
//		String sql = "select * from consulta where";
		return null;
	}

}
