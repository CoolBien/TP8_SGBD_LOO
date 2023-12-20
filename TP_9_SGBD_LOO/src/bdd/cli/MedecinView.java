package bdd.cli;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bdd.util.Utils;

public class MedecinView {

	private final Connection conn;
	private int idMedecin;

	public MedecinView(final Connection conn) throws SQLException {
		this.conn = conn;
		System.out.println("Vous êtes un médecin.");
		while (true) {
			System.out.println("Que voulez-vous faire ?");
			System.out.println(" - [C] Se connecter");
			System.out.println(" - [I] S'inscrire");
			final String answer = Utils.prompt(">").toUpperCase();
			switch (answer.charAt(0)) {
			case 'C' -> {
				if (connexion()) {
					onConnected();
					return;
				}
			}
			case 'I' -> {
				inscription();
				onConnected();
				return;
			}
			default -> {
				System.err.println("Mauvais choix");
			}
			}
		}
	}

	private boolean connexion() throws SQLException {
		System.out.println("Veuillez renseigner");
		String answer = "";
		int ssn = 0;
		while (answer.isBlank()) {
			answer = Utils.prompt("N° Sécu social: ").toUpperCase();
			try {
				ssn = Integer.parseInt(answer);
			} catch (final Exception e) {
				answer = "";
			}
		}
		final ResultSet result = conn.createStatement()
				.executeQuery("SELECT ID_Medecin FROM Medecin WHERE Num_Securite_Sociale=" + ssn);
		if (result.next()) {
			idMedecin = result.getInt(1);
			return true;
		} else {
			return false;
		}
	}

	private void onConnected() throws SQLException {
		System.out.println("Vous êtes connecté.");
		while (true) {
			System.out.println("Que voulez-vous faire ?");
			System.out.println(" - [R] Réserver");
			System.out.println(" - [P] Payer");
			final String answer = Utils.prompt(">").toUpperCase();
			switch (answer.charAt(0)) {
			case 'R' -> {

			}
			case 'P' -> {
			}
			default -> {
				System.err.println("Mauvais choix");
			}
			}
		}
	}

	private void inscription() throws SQLException {
		System.out.println("Veuillez renseigner");
		String answer = "";
		String answer2 = "";
		String name = "";
		String firstName = "";
		int ssn = 0;
		int salary = 0;
		while (answer.isBlank()) {
			answer = Utils.prompt("N° Sécu social: ").toUpperCase();
			try {
				ssn = Integer.parseInt(answer);
			} catch (final Exception e) {
				answer = "";
			}
		}
		while (name.isBlank()) {
			name = Utils.prompt("Nom: ").toLowerCase();
		}
		while (firstName.isBlank()) {
			firstName = Utils.prompt("Prénom: ").toLowerCase();
		}
		while (answer2.isBlank()) {
			answer2 = Utils.prompt("Salaire: ").toUpperCase();
			try {
				salary = Integer.parseInt(answer2);
			} catch (final Exception e) {
				answer2 = "";
			}
		}
		final PreparedStatement statement = conn.prepareStatement(
				"INSERT INTO Medecin(Nom, prenom, Num_Securite_Sociale, Salaire) VALUES (?, ?, ?, ?);");
		statement.setString(1, name);
		statement.setString(2, firstName);
		statement.setInt(3, ssn);
		statement.setFloat(4, salary);
		statement.execute();
		final ResultSet result = conn.createStatement()
				.executeQuery("SELECT ID_Medecin FROM Medecin WHERE Num_Securite_Sociale=" + ssn);
		while (result.next()) {
			idMedecin = result.getInt(1);
		}
	}

}
