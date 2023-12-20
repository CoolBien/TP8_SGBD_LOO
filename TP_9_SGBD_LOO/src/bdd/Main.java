package bdd;

import bdd.cli.UserView;
import bdd.util.Utils;

public class Main {

	public static void main(final String[] args) {
		while (true) {
			final String answer = Utils.prompt("Êtes vous un [M]édecin ou un [U]tilisateur ?").toLowerCase();
			if (answer.startsWith("M")) {
				// TODO
			} else if(answer.startsWith("U")) {
				new UserView();
				return;
			} else if (answer.isBlank()) {
				return;
			}
			System.err.println("Choix incorrect.");
		}
	}
}
