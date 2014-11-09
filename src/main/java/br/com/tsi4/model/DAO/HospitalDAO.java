package br.com.tsi4.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.tsi4.model.Hospital;
import br.com.tsi4.model.Medico;
import br.com.tsi4.model.JDBC.Conectar;

public class HospitalDAO implements ICRUD<Hospital> {
	
	
	private Connection connection;
	private PreparedStatement preparar;

	public HospitalDAO() {
		connection = Conectar.getConnection();
	}

	@Override
	public long create(Hospital obj) throws SQLException {
		String sql = "insert into hospitais (pk_hospital,pk_fila,razaosocial,nomefantasia,cnpj,endhospital,telefonehospital)"
				+ "values (?, ?, ? , ?, ?, ?, ?)";

		preparar = connection.prepareStatement(sql);
		
		preparar.setLong(1, obj.getPkHospital());
		preparar.setLong(2, obj.getPkFila());
		preparar.setString(3, obj.getRazaosocial());
		preparar.setString(4, obj.getNomeFantasia());
		preparar.setString(5, obj.getCnpj());
		preparar.setString(6, obj.getEnderecoHospital());
		preparar.setString(7, obj.getTelefonehospital());
		

		preparar.execute();
		ResultSet rs = preparar.getGeneratedKeys();

		if (rs.next()) {
			return rs.getInt(1);
		}

		return -1;
	}



	@Override
	public long update(Hospital obj) throws SQLException {
		
		String sql = "update hospitais set"
				+ "(pk_hospital =? pk_fila=?, razaosocial=?, nomefantasia=? , cnpj=?, endhospital=?,telefonehospital=?)";

		preparar = connection.prepareStatement(sql);

		preparar.setLong(1, obj.getPkHospital());
		preparar.setLong(2, obj.getPkFila());
		preparar.setString(3, obj.getRazaosocial());
		preparar.setString(4, obj.getCnpj());
		preparar.setString(4, obj.getEnderecoHospital());
		preparar.setString(4, obj.getTelefonehospital());
		
		

		preparar.execute();
		ResultSet rs = preparar.getGeneratedKeys();

		if (rs.next()) {
			return rs.getInt(1);
		}
		return -1;
		
		
	}

	@Override
	public boolean delete(long pkKey) throws SQLException {
		
		String sql = "DELETE FROM hospitais WHERE pk_hospital=?";

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
	public List<Hospital> restriveAll() throws SQLException {
		List<Hospital> lHospital = new ArrayList<>();
		Hospital hospital;
		String sql = "select * from hospitais order by razaosocial";

		preparar = connection.prepareStatement(sql);

		ResultSet rs = preparar.executeQuery();

		while (rs.next()) {
			hospital = new Hospital();

			hospital.setPkHospital(rs.getInt("pk_hospital"));
			hospital.setPkFila(rs.getInt("pk_fila"));
			hospital.setRazaosocial(rs.getString("razaosocial"));
			hospital.setNomeFantasia(rs.getString("nomefantasia"));
			hospital.setCnpj(rs.getString("cnpj"));
			hospital.setEnderecoHospital(rs.getString("endhospital"));
			hospital.setTelefonehospital(rs.getString("telefonehospital"));

			lHospital.add(hospital);
		}
		preparar.close();

		return lHospital;
	}

	@Override
	public Hospital retriveOneByPkKey(long pkKLey) throws SQLException {
		
		Hospital hospital = null;

		String sql = "select * from hospitais where pk_hospital=?";

		preparar = connection.prepareStatement(sql);
		preparar.setLong(1, pkKLey);
		ResultSet rs = preparar.executeQuery();

		while (rs.next()) {
			hospital = new Hospital();
			hospital.setPkHospital(rs.getInt("pk_medico"));
			hospital.setPkFila(rs.getInt("pk_fila"));
			hospital.setRazaosocial(rs.getString("razaosocial"));
			hospital.setNomeFantasia(rs.getString("nomefantasia"));
			hospital.setCnpj(rs.getString("cnpj"));
			hospital.setEnderecoHospital(rs.getString("endhospital"));
			hospital.setTelefonehospital(rs.getString("telefonehospital"));

		}
		preparar.close();

		return hospital;
		
		
	}

	@Override
	public List<Hospital> retriveByName(String nome) throws SQLException {
		List<Hospital> lHospitais = new ArrayList<>();
		Hospital hospital = null;
		String sql = "select * from hospitais where razaosocial like ?";

		preparar = connection.prepareStatement(sql);
		preparar.setString(1, "%" + nome + "%");

		ResultSet rs = preparar.executeQuery();

		while (rs.next()) {
			hospital = new Hospital();
			hospital.setPkHospital(rs.getInt("pk_hospital"));
			hospital.setPkFila(rs.getInt("pk_fila"));
			hospital.setRazaosocial(rs.getString("razaosocial"));
			hospital.setNomeFantasia(rs.getString("nomefantasia"));
			hospital.setCnpj(rs.getString("cnpj"));
			hospital.setEnderecoHospital(rs.getString("endhospital"));
			hospital.setCnpj(rs.getString("telefonehospital"));
			lHospitais.add(hospital);
		}
		preparar.close();

		return lHospitais;
	}
	
	

}
