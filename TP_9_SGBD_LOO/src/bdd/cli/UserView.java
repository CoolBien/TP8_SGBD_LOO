package bdd.cli;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import bdd.util.Utils;

public class UserView {

	private final Connection c;

	public UserView(final Connection c) throws SQLException {
		this.c = c;
		System.out.println("Vous êtes un utilisateur.");
		while (true) {
			System.out.println("Que voulez-vous faire ?");
			System.out.println(" - [C] Se connecter");
			System.out.println(" - [I] S'inscrire");
			final String answer = Utils.prompt(">").toLowerCase();
			switch (answer.charAt(0)) {
			case 'C' -> {
				connexion();
				return;
			}
			case 'I' -> {
				inscription();
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
			answer = Utils.prompt("N° Sécu social: ").toLowerCase();
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
	}

	private void connexion() {
		// TODO Auto-generated method stub

	}

}
