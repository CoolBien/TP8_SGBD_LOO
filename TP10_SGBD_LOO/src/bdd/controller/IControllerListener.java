package bdd.controller;

import bdd.data.Reservation;
import bdd.data.Utilisateur;

public interface IControllerListener {

	default void addUtilsiateur(final Utilisateur utilisateur) {}

	default void addReservation(final Reservation reservation) {}

}
