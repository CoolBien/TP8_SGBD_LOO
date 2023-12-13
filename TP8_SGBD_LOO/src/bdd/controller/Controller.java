package bdd.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.hibernate.Session;
import org.hibernate.Transaction;

import bdd.data.Enseignant;
import bdd.data.Enseignement;
import bdd.data.Etudiant;

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

	public void setSession(final Session session) {
		this.session = session;
		transaction = session.beginTransaction();
	}

	public void endSession() {
		transaction.commit();
		session = null;
	}

	////////////////////////////////// CONTROLLER

	@Override
	public void addEtudiant(final Etudiant etudiant) {
		session.save(etudiant);
		dispatchEvent(c -> c.addEtudiant(etudiant));
	}

	public void addEnseignant(final Enseignant enseignant) {
		session.save(enseignant);
		dispatchEvent(c -> c.addEnseignant(enseignant));
	}
	
	public void addEnseignement(final Enseignement enseignement) {
		session.save(enseignement);
		dispatchEvent(c -> c.addEnseignement(enseignement));
	}
}
