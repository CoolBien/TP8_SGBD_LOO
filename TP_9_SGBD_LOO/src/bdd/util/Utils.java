package bdd.util;

import java.io.Console;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Utils {

	private final static Console con = System.console();
	private final static Scanner s = con != null ? new Scanner(con.reader()) : new Scanner(new InputStreamReader(System.in));

	/**
	 * @param question : poser votre question
	 * @return la réponse
	 */
	public static String prompt(final String question) {
		System.out.print(question+":\t");
		return s.nextLine();
	}
}
