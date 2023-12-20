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

	private void onConnected() throws SQLException {
		System.out.println("Vous êtes connecté.");
		while (true) {
			System.out.println("Que voulez-vous faire ?");
			System.out.println(" - [R] Réserver");
			System.out.println(" - [P] Payer");
			final String answer = Utils.prompt(">").toUpperCase();
			switch (answer.charAt(0)) {
			case 'R' -> {
				reserver();
			}
			case 'P' -> {
			}
			default -> {
				System.err.println("Mauvais choix");
			}
			}
		}
	}

	private void reserver() throws SQLException {
		System.out.println("Réserver");
		while (true) {
			System.out.println("Quoi (Type_d_analyse) ?");
			final ResultSet set = c.createStatement().executeQuery("SELECT ID_Type_Analyse, Hemogramme, Groupe_Sanguin, Vitesse_de_sedimentation FROM Type_d_analyse;");
			System.out.println("[0]\tAnnuler");
			while (set.next()) {
				System.out.println("["+set.getInt(1)+"]\t"+set.getString(2)+"\t"+set.getString(3)+"\t"+set.getString(4)+"\t");
			}
			final String answer = Utils.prompt(">").toUpperCase();
			int typeAnalyse = -1;
			while (typeAnalyse < 0) {
				try {
					typeAnalyse = Integer.parseInt(answer);
				} catch (final NumberFormatException e) {
					typeAnalyse = -1;
				}
			}
			if (typeAnalyse == 0) {	// cancel
				return;
			}
			System.out.println("Le type d'analyse est "+typeAnalyse);
		}
	}
}
