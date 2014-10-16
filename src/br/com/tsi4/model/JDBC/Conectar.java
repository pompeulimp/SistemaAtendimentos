package br.com.tsi4.model.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conectar {
	
	private static Connection connection;

	private Conectar() {
	}

	public static Connection getConnection() {
		
		try {
			Class.forName("org.postgresql.Driver");
			
			connection = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/agendamento", "postgres",
					"1234");
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
}
