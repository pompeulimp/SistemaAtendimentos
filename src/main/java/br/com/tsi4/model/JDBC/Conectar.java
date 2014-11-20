package br.com.tsi4.model.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conectar {

	private Conectar() {
	}

	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("org.postgresql.Driver");
			con =  	DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/agendamento",
					"postgres",
					"123");
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return con;
	}

	

}
