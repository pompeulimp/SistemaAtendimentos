package br.com.tsi4.model.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import br.com.tsi4.model.Atendimento;
import br.com.tsi4.model.JDBC.Conectar;

public class AtendimentoDAO implements ICRUD<Atendimento>{

	private Connection connection;
	private PreparedStatement preparar;

	public AtendimentoDAO() {
		connection = Conectar.getConnection();
	}

	@Override
	public long create(Atendimento obj) throws SQLException {
		String sql = "insert into Atendimentos (pk_atendimento,pk_paciente,pk_tipo,pk_usuario,pk_medico,dataincicio,datatermino,status)"
				+ "values (? ,? , ? , ?, ? , ? , ? , ?)";

		preparar = connection.prepareStatement(sql);
		
		preparar.setLong(1, obj.getPk_atendimento());
		preparar.setInt(2, obj.getPk_paciente());
		preparar.setInt(3, obj.getPk_tipo());
		preparar.setInt(4, obj.getPk_usuario());
		preparar.setInt(5, obj.getPk_medico());
		preparar.setTimestamp(6, obj.getDatainicio());
		preparar.setTimestamp(7, obj.getDatatermino());
		preparar.setString(8, obj.getStatus());

		preparar.execute();
		ResultSet rs = preparar.getGeneratedKeys();

		if (rs.next()) {
			return rs.getInt(1);
		}

		return -1;
	}

	

	@Override
	public long update(Atendimento obj) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean delete(long pkKey) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Atendimento> restriveAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Atendimento retriveOneByPkKey(long pkKLey) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Atendimento> retriveByName(String nome) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
}