package bdd.cli;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bdd.util.Utils;

public class UserView {

	private final Connection c;
	private int idUser;

	public UserView(final Connection c) throws SQLException {
		this.c = c;
		System.out.println("Vous êtes un utilisateur.");
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

	private void inscription() throws SQLException {
		System.out.println("Veuillez renseigner");
		String answer = "";
		String name = "";
		String firstName = "";
		int ssn = 0;
		while (answer.isBlank()) {
			answer = Utils.prompt("N° Sécu social: ").toUpperCase();
			try { ssn = Integer.parseInt(answer);}
			catch (final Exception e) {answer="";}
		}
		while (name.isBlank()) {
			name = Utils.prompt("Nom: ").toLowerCase();
		}
		while (firstName.isBlank()) {
			firstName = Utils.prompt("Prénom: ").toLowerCase();
		}
		final PreparedStatement statement = c.prepareStatement("INSERT INTO Utilisateur(Nom, prenom, Num_Securite_Sociale) VALUES (?, ?, ?);");
		statement.setString(1, name);
		statement.setString(2, firstName);
		statement.setInt(3, ssn);
		statement.execute();
		final ResultSet result = c.createStatement().executeQuery("SELECT ID_Utilisateur FROM Utilisateur WHERE Num_Securite_Sociale=" + ssn);
		while (result.next()) {
			idUser = result.getInt(1);
		}
	}

	private boolean connexion() throws SQLException {
		System.out.println("Veuillez renseigner");
		String answer = "";
		int ssn = 0;
		while (answer.isBlank()) {
			answer = Utils.prompt("N° Sécu social: ").toUpperCase();
			try { ssn = Integer.parseInt(answer);}
			catch (final Exception e) {answer="";}
		}
		final ResultSet result = c.createStatement().executeQuery("SELECT ID_Utilisateur FROM Utilisateur WHERE Num_Securite_Sociale=" + ssn);
		if (result.next()) {
			idUser = result.getInt(1);
			return true;
		} else {
			return false;
		}
	}

	private void onConnected() {
		System.out.println("Vous êtes connecté. Que faire ?");

	}
}
