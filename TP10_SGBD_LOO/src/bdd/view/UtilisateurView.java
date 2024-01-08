package bdd.view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TabFolder;

import bdd.data.Utilisateur;

public class UtilisateurView {

	public UtilisateurView(final Composite composite, final Utilisateur user) {

		final TabFolder tabFolder = new TabFolder(composite, SWT.TOP);
		tabFolder.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		new ReservationView(tabFolder, user);
		new PayerView(tabFolder);
	}
}
