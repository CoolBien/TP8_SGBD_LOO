package bdd.view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class UtilisateurView {

	public UtilisateurView(final Composite composite) {
		final Label label = new Label(composite, SWT.NONE);
		label.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		label.setText("Utilisateur view debug label ");

	}

}
