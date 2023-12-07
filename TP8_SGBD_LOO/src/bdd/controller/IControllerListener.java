package bdd.controller;

import bdd.data.Etudiant;

public interface IControllerListener {

	default void addEtudiant(Etudiant etudiant) {}

}
