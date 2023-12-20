package bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MainJDBC {

	public static void main(final String[] args) {// Trouver la classe
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (final ClassNotFoundException e) {
			System.err.println("Impossible de trouver la classe Driver pour MySql");
			e.printStackTrace();
			return;
		}

		// Connexion
		try (
			final Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306", "root", "password");
		) {
			new Main(conn);
		} catch (final SQLException e) {
			System.err.println("Erreur de connexion ou autre");
			e.printStackTrace();
		}
	}
	
}
