package bdd;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import bdd.util.HibernateUtil;

public class Main {
	public static void main(final String[] args) throws Exception {

		try (SessionFactory sessFact = HibernateUtil.getSessionFactory()) {
			final Session session = sessFact.getCurrentSession();
			final Transaction tr = session.beginTransaction();
//
//			final Auteur a = new Auteur();
//			a.setNom("Natsume");
//			a.setPrenom("Soseki");
//
//			final Editeur e = new Editeur();
//			e.setAdresse("oui");
//			e.setNom("hototogisu");
//			e.setVille("東京");
//
//			final Livre l = new Livre();
//			l.setTitre("wagahai wa neko de aru");
//			l.setUrlImage("http://www.image.com/image3");
//			l.setAuteur(a);
//			l.setEditeur(e);
//
//			session.save(a);
//			session.save(e);
//			session.save(l);
//
//			afficherToutLivre(session);
//			afficherLivreIsbn(session, 6);
//			demandeInsertionLivre(session);

			tr.commit();
			System.out.println("Successfully inserted");
			sessFact.close();
		}
	}

//	/**
//	 * @param session
//	 */
//	private static void afficherToutLivre(final Session session) {
//		final Query<Livre> query = session.createQuery("FROM Livre", Livre.class);
//		for (final Livre livre: query.list()) {
//			System.out.println(livre);
//		}
//	}
//
//	/**
//	 * @param session
//	 * @param isbn
//	 */
//	private static void afficherLivreIsbn(final Session session, final int isbn) {
//		final Livre livre = session.find(Livre.class, isbn);
//		System.out.println(livre);
//	}
//
//	private static void demandeInsertionLivre(final Session session) {
//
//		final Console con = System.console();
//		final Scanner s = con != null ? new Scanner(con.reader()) : new Scanner(new InputStreamReader(System.in));
//
//		final String titre = prompt(s, "titre");
//		final String urlImage = prompt(s, "urlImage");
//		final String nomA = prompt(s, "auteur -> nom");
//		final String prenomA = prompt(s, "auteur -> prenom");
//		final String nomE = prompt(s, "editeur -> nom");
//		final String adresseE = prompt(s, "editeur -> adresse");
//		final String villeE = prompt(s, "editeur -> ville");
//
//		Auteur a = null;
//		final Query<Auteur> query = session.createQuery("FROM Auteur", Auteur.class);
//		for (final Auteur auteur: query.list()) {
//			if (!auteur.getNom().equalsIgnoreCase(nomA)) continue;
//			if (!auteur.getPrenom().equalsIgnoreCase(prenomA)) continue;
//			a = auteur;
//			break;
//		}
//		if (a == null) {
//			System.err.println("Auteur inexistant");
//			return;
//		}
//
//		Editeur e = null;
//		final Query<Editeur> query2 = session.createQuery("FROM Editeur", Editeur.class);
//		for (final Editeur editeur: query2.list()) {
//			if (!editeur.getNom().equalsIgnoreCase(nomE)) continue;
//			if (!editeur.getAdresse().equalsIgnoreCase(adresseE)) continue;
//			if (!editeur.getVille().equalsIgnoreCase(villeE)) continue;
//			e = editeur;
//			break;
//		}
//		if (e == null) {
//			System.err.println("Editeur inexistant");
//			return;
//		}
//
//		final Livre l = new Livre(titre, urlImage, a, e);
//		session.save(l);
//		System.out.println("Livre inséré: "+l);
//	}

	/**
	 * @param s
	 * @return
	 */
	@SuppressWarnings("unused")
	private static String prompt(final Scanner s, final String question) {
		System.out.print(question+":\t");
		return s.nextLine();
	}
}
