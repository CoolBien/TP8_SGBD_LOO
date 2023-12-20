package bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import bdd.cli.UserView;
import bdd.util.Utils;

public class Main {

	public Main(final Connection conn) throws SQLException {
		while (true) {
			final String answer = Utils.prompt("Êtes vous un [M]édecin ou un [U]tilisateur ?").toUpperCase();
			if (answer.startsWith("M")) {
				// TODO
			} else if(answer.startsWith("U")) {
				new UserView(conn);
				return;
			} else if (answer.startsWith("R")) {
				resetDataBase(conn);
			} else if (answer.isBlank()) {
				return;
			}
			System.err.println("Choix incorrect.");
		}
	}

	private void resetDataBase(final Connection conn) throws SQLException {
		final Statement statement = conn.createStatement();
		statement.execute("DROP DATABASE IF EXISTS medecin;");
		statement.execute("CREATE DATABASE medecin;");
		statement.execute("USE medecin;");
		statement.execute("CREATE TABLE Medecin(\r\n"
				+ "   ID_Medecin INT,\r\n"
				+ "   Nom VARCHAR(50) NOT NULL,\r\n"
				+ "   Prenom VARCHAR(50),\r\n"
				+ "   Num_Securite_Sociale INT,\r\n"
				+ "   Salaire CURRENCY,\r\n"
				+ "   PRIMARY KEY(ID_Medecin)\r\n"
				+ ");");
		statement.execute("CREATE TABLE Utilisateur(\r\n"
				+ "   ID_Utilisateur INT,\r\n"
				+ "   Nom VARCHAR(50),\r\n"
				+ "   Prenom VARCHAR(50),\r\n"
				+ "   Num_Securite_Sociale INT,\r\n"
				+ "   PRIMARY KEY(ID_Utilisateur)\r\n"
				+ ");");
		statement.execute("CREATE TABLE Type_d_analyse(\r\n"
				+ "   ID_Type_Analyse INT,\r\n"
				+ "   Hemogramme VARCHAR(50),\r\n"
				+ "   Groupe_Sanguin VARCHAR(3),\r\n"
				+ "   Vitesse_de_sedimentation DOUBLE,\r\n"
				+ "   PRIMARY KEY(ID_Type_Analyse)\r\n"
				+ ");");
		statement.execute("CREATE TABLE Reservation(\r\n"
				+ "   ID_Reservation_ INT,\r\n"
				+ "   Date_debut DATETIME,\r\n"
				+ "   Date_fin DATETIME,\r\n"
				+ "   Prix_a_payer CURRENCY,\r\n"
				+ "   Prix_deja_paye CURRENCY,\r\n"
				+ "   ID_Medecin INT NOT NULL,\r\n"
				+ "   ID_Type_Analyse INT NOT NULL,\r\n"
				+ "   ID_Utilisateur INT NOT NULL,\r\n"
				+ "   PRIMARY KEY(ID_Reservation_),\r\n"
				+ "   FOREIGN KEY(ID_Medecin) REFERENCES Medecin(ID_Medecin),\r\n"
				+ "   FOREIGN KEY(ID_Type_Analyse) REFERENCES Type_d_analyse(ID_Type_Analyse),\r\n"
				+ "   FOREIGN KEY(ID_Utilisateur) REFERENCES Utilisateur(ID_Utilisateur)\r\n"
				+ ");");
		statement.execute("\r\n"
				+ "CREATE TABLE Autorisation(\r\n"
				+ "   ID_Medecin INT,\r\n"
				+ "   ID_Type_Analyse INT,\r\n"
				+ "   PRIMARY KEY(ID_Medecin, ID_Type_Analyse),\r\n"
				+ "   FOREIGN KEY(ID_Medecin) REFERENCES Medecin(ID_Medecin),\r\n"
				+ "   FOREIGN KEY(ID_Type_Analyse) REFERENCES Type_d_analyse(ID_Type_Analyse)\r\n"
				+ ");");
	}

	public static void main(final String[] args) {// Trouver la classe
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (final ClassNotFoundException e) {
			System.err.println("Impossible de trouver la classe Driver pour MySql");
			e.printStackTrace();
			return;
		}

		// Connexion
		try (
			final Connection conn = DriverManager.getConnection("jdbc:mariadb://127.0.0.1/medecin", "root", "");
		) {
			new Main(conn);
		} catch (final SQLException e) {
			System.err.println("Erreur de connexion ou autre");
			e.printStackTrace();
		}
	}
}
