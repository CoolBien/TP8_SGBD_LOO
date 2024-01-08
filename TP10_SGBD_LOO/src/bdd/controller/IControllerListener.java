package bdd.controller;

import bdd.data.Medecin;
import bdd.data.Reservation;
import bdd.data.TypeAnalyse;
import bdd.data.Utilisateur;

public interface IControllerListener {

	default void addUtilsiateur(final Utilisateur utilisateur) {}

	default void addReservation(final Reservation reservation) {}

	default void selectTypeAnalyse(final TypeAnalyse selectedTypeAnalyse) {}

	default void selectMedecin(final Medecin selectedMedecin) {}

}
