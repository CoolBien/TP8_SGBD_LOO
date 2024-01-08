package bdd.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.hibernate.Session;
import org.hibernate.Transaction;

import bdd.data.Medecin;
import bdd.data.Reservation;
import bdd.data.TypeAnalyse;
import bdd.data.Utilisateur;

public class Controller implements IControllerListener {

	////////////////////////////////// SINGLETON

	private static final Controller INSTANCE = new Controller();

	public static final Controller getInstance() {
		return INSTANCE;
	}

	public Controller() {
		if (INSTANCE != null) {
			throw new IllegalStateException("Cannot instantiate multiple times a singleton");
		}
	}

	////////////////////////////////// LISTENERS

	/** List of listeners of controller changes */
	private final List<IControllerListener> listeners = new ArrayList<>();

	/**
	 * Add a new listener to listen to this controller's changes.
	 *
	 * @param listener : the listener to add.
	 */
	public void addListener(final IControllerListener listener) {
		listeners.add(listener);
	}

	/**
	 * Remove a listener form listening to this controller's listeners
	 *
	 * @param listener : the listener to remove
	 */
	public void removeListener(final IControllerListener listener) {
		listeners.remove(listener);
	}

	/**
	 * Dispatch an event to all listeners of this controller.
	 *
	 * @param action : the action to execute with each listeners.
	 */
	private void dispatchEvent(final Consumer<IControllerListener> action) {
		for (int i = listeners.size(); i-- > 0;) {
			try {
				action.accept(listeners.get(i));
			} catch (final Exception e) {
				System.err.println("Exception in Controller's callback:");
				e.printStackTrace();
			}
		}
	}

	////////////////////////////////// SESSION

	private Session session;
	private Transaction transaction;
	private TypeAnalyse selectedTypeAnalyse;
	private Medecin selectedMedecin;

	public void setSession(final Session session) {
		this.session = session;
		transaction = session.beginTransaction();
	}

	public void endSession() {
		transaction.commit();
		session = null;
	}

	////////////////////////////////// CONTROLLER

	public void addUtilisateur(final Utilisateur utilisateur) {
		session.save(utilisateur);
		dispatchEvent(c -> c.addUtilsiateur(utilisateur));
	}

	public Utilisateur getUtilisateurWithSSN(final int ssn) {
		for (final Utilisateur u: getAllUtilisateurs()) {
			if (u.getSnn() == ssn) {
				return u;
			}
		}
		return null;
	}

	@Override
	public void addReservation(final Reservation reservation) {
		session.save(reservation);
		dispatchEvent(c -> c.addReservation(reservation));
	}

	/**
	 * @return la liste des {@link Utilisateur utilisateurs}.
	 */
	public List<Utilisateur> getAllUtilisateurs() {
		return session.createQuery("FROM Utilisateur", Utilisateur.class).list();
	}

	/**
	 * @return la liste des {@link Enseignement enseignements}.
	 */
	public List<TypeAnalyse> getAllTypeAnalyses() {
		return session.createQuery("FROM TypeAnalyse", TypeAnalyse.class).list();
	}

	/**
	 * @return la liste des {@link Reservation réservations}.
	 */
	public List<Reservation> getAllReservations() {
		return session.createQuery("FROM Reservation", Reservation.class).list();
	}

	/**
	 * Renvoie liste des {@link Reservation réservations} d'un {@link Utilisateur} particulier.
	 * @param user : l'utilisateur auquel il faut récupérer les réservations.
	 * @return la liste des {@link Reservation réservations} de cet utilisateur.
	 */
	public List<Reservation> getReservations(final Utilisateur user) {
		return getAllReservations().stream().filter(r -> r.getUser().equals(user)).toList();
	}

	/**
	 * @return la liste des {@link Medecin médecins}.
	 */
	public List<Medecin> getAllMedecins() {
		return session.createQuery("FROM Medecin", Medecin.class).list();
	}

	/**
	 * Renvoie la liste des {@link Medecin médecins} compétents pour un type d'analyse.
	 * @param typeAnalyse : le {@link TypeAnalyse type d'analyse} dont on veut les médecins compétents.
	 * @return la liste des {@link Medecin médecins} compétents pour ce type d'analyse.
	 */
	public List<Medecin> getMedecinForAnalyse(final TypeAnalyse typeAnalyse) {
		return getAllMedecins().stream().filter(m -> m.getAutorisations().contains(typeAnalyse)).toList();
	}

	@Override
	public void selectTypeAnalyse(final TypeAnalyse selectedTypeAnalyse) {
		this.selectedTypeAnalyse = selectedTypeAnalyse;
		dispatchEvent(c -> c.selectTypeAnalyse(selectedTypeAnalyse));
	}

	public TypeAnalyse getSelectedTypeAnalyse() {
		return selectedTypeAnalyse;
	}

	@Override
	public void selectMedecin(final Medecin selectedMedecin) {
		this.selectedMedecin = selectedMedecin;
		dispatchEvent(c -> c.selectMedecin(selectedMedecin));
	}

	public Medecin getSelectedMedecin() {
		return selectedMedecin;
	}
}
