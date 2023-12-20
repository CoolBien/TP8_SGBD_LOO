package bdd.cli;

import java.sql.Connection;

import bdd.util.Utils;

public class MedecinView {

	private final Connection conn;

	public MedecinView(final Connection conn) {
		this.conn = conn;
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

}
