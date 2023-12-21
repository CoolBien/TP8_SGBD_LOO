package bdd.view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import bdd.controller.Controller;
import bdd.data.TypeAnalyse;
import bdd.data.Utilisateur;

public class UtilisateurView {

	public UtilisateurView(final Composite composite, final Utilisateur user) {
		final Label label = new Label(composite, SWT.NONE);
		label.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		label.setText("Choisir un type d'analyse");

		final Combo combo = new Combo(composite, SWT.DROP_DOWN | SWT.READ_ONLY);
		combo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		for (final TypeAnalyse type: Controller.getInstance().getTypeAnalyses()) {
			combo.add(type.toString());
			combo.setData(type.toString(), type);
		}
	}
}
