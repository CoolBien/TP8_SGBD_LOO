package bdd.controller;

import bdd.data.Enseignant;
import bdd.data.Etudiant;

public interface IControllerListener {

	default void addEtudiant(Etudiant etudiant) {}

	default void addEnseignant(Enseignant enseignant) {}
}
