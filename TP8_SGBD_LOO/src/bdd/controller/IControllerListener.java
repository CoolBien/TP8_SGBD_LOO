package bdd.controller;

import bdd.data.Bourse;
import bdd.data.Enseignant;
import bdd.data.Enseignement;
import bdd.data.Etudiant;

public interface IControllerListener {

	default void addEtudiant(Etudiant etudiant) {}

	default void addEnseignant(Enseignant enseignant) {}
	
	default void addEnseignement(Enseignement enseignement) {}
	
	default void addBourse(Bourse bourse) {}
}
