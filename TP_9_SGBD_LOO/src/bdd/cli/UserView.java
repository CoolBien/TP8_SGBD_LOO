package bdd.cli;

import java.sql.Connection;

import bdd.data.Utilisateur;
import bdd.util.Utils;

public class UserView {

	private final Connection c;

	public UserView(final Connection c) {
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

	private void inscription() {
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
		final Utilisateur user = new Utilisateur(0, name, firstName, ssn);
		c.prepareStatement("INSERT INTO User")
	}

	private void connexion() {
		// TODO Auto-generated method stub

	}

}
