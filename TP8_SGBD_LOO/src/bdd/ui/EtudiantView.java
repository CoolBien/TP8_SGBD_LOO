package bdd.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.BorderData;
import org.eclipse.swt.layout.BorderLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Text;

import bdd.controller.Controller;
import bdd.data.Etudiant;
import bdd.util.SWTUTils;

public class EtudiantView {

	public EtudiantView(final TabFolder tabFolder) {

		final TabItem tabItem = new TabItem(tabFolder, SWT.NONE);
		tabItem.setText("Etudiant");

		final Composite composite = new Composite(tabFolder, SWT.NONE);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		composite.setLayout(new BorderLayout());
		tabItem.setControl(composite);

		final Composite dataEtudiant = new Composite(composite, SWT.NONE);
		dataEtudiant.setLayoutData(new BorderData(SWT.TOP));
		dataEtudiant.setLayout(new GridLayout(2, false));

		final Label label = new Label(dataEtudiant, SWT.NONE);
		label.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		label.setText("Nom");

		final Text text = new Text(dataEtudiant, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		final Label label1 = new Label(dataEtudiant, SWT.NONE);
		label1.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		label1.setText("Prenom");

		final Text text1 = new Text(dataEtudiant, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		text1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		final Label label2 = new Label(dataEtudiant, SWT.NONE);
		label2.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		label2.setText("Note moyenne du dernier semestre");

		final Text text2 = new Text(dataEtudiant, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		text2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		final Button button = new Button(dataEtudiant, SWT.PUSH);
		button.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
		button.setText("Ajouter");
		button.addSelectionListener(SelectionListener.widgetSelectedAdapter(e -> {
			final String nom = text.getText();
			final String prenom = text1.getText();
			float notemoy = 0;
			try {
				notemoy = Float.parseFloat(text2.getText());
			} catch (final NumberFormatException exc) {
				SWTUTils.showError(button.getShell(), "Pas un nombre", "Veuillez mettre un nombre valide pour la note.");
				System.err.println("pas un nombre");
				return;
			}
			if (notemoy < 0 || notemoy > 20) {
				SWTUTils.showError(button.getShell(), "Nombre invalide", "Veuillez mettre un nombre valide entre 0 et 20 pour la note.");
				System.err.println("nombre invalide");
				return;
			}
			final Etudiant etudiant = new Etudiant(nom, prenom, 0, notemoy);
			Controller.getInstance().addEtudiant(etudiant);
		}));
	}
}
