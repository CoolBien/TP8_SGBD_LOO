package bdd.controller;

import bdd.data.Utilisateur;

public interface IControllerListener {

	default void addUtilsiateur(final Utilisateur utilisateur) {}

}
