package bdd.controller;

import bdd.data.Bourse;
import bdd.data.Enseignant;
import bdd.data.Enseignement;
import bdd.data.Etudiant;

public interface IControllerListener {

	default void addEtudiant(final Etudiant etudiant) {}

	default void addEnseignant(final Enseignant enseignant) {}

	default void addEnseignement(final Enseignement enseignement) {}

	default void addBourse(final Bourse bourse) {}

	default void setSelectedEtudiant(final Etudiant etudiant) {}

	default void addEnseignementToSelectedEtudiant(final Enseignement enseignement) {}
}
