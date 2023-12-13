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
import bdd.data.Enseignement;
import bdd.util.SWTUTils;

public class EnseignementView {

	public EnseignementView(TabFolder tabFolder) {

		final TabItem tabItem = new TabItem(tabFolder, SWT.NONE);
		tabItem.setText("Enseignement");

		final Composite composite = new Composite(tabFolder, SWT.NONE);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		composite.setLayout(new BorderLayout());
		tabItem.setControl(composite);

		final Composite dataEnseignement = new Composite(composite, SWT.NONE);
		dataEnseignement.setLayoutData(new BorderData(SWT.TOP));
		dataEnseignement.setLayout(new GridLayout(2, false));

		final Label label = new Label(dataEnseignement, SWT.NONE);
		label.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		label.setText("Nom");

		final Text text = new Text(dataEnseignement, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		final Label label1 = new Label(dataEnseignement, SWT.NONE);
		label1.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		label1.setText("Nombre crédit");

		final Text text1 = new Text(dataEnseignement, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		text1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		
		final Label label2 = new Label(dataEnseignement, SWT.NONE);
		label2.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		label2.setText("Volume horaire");

		final Text text2 = new Text(dataEnseignement, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		text2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		final Button button = new Button(dataEnseignement, SWT.PUSH);
		button.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
		button.setText("Ajouter");
		button.addSelectionListener(SelectionListener.widgetSelectedAdapter(e -> {
			final String nom = text.getText();
			int nombreCredit = 0;
			int volumeHoraire = 0;
			try {
				nombreCredit = Integer.parseInt(text1.getText());
			} catch (final NumberFormatException exc) {
				SWTUTils.showError(button.getShell(), "Pas un nombre",
						"Veuillez mettre un nombre valide pour le nombre de crédit.");
				System.err.println("pas un nombre");
				return;
			}
			try {
				volumeHoraire = Integer.parseInt(text2.getText());
			} catch (final NumberFormatException exc) {
				SWTUTils.showError(button.getShell(), "Pas un nombre",
						"Veuillez mettre un nombre valide pour le volume horaire.");
				System.err.println("pas un nombre");
				return;
			}
			final Enseignement enseignement = new Enseignement(nom, nombreCredit, volumeHoraire);
			Controller.getInstance().addEnseignement(enseignement);
		}));
	}

}
