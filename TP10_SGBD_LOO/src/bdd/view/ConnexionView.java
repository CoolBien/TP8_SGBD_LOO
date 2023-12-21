package bdd.view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import bdd.util.SWTUTils;

public class ConnexionView {

	public ConnexionView(final Composite composite) {
		Composite data = new Composite(composite, SWT.NONE);
		data.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		data.setLayout(new GridLayout(2, false));

		Label numerolabel = new Label(data, SWT.NONE);
		numerolabel.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		numerolabel.setText("Entrez votre Numéro de Sécurité Social :");

		Text entrernumlabel = new Text(data, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		entrernumlabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		entrernumlabel.setText("");

		Button buttonvaliderlabel = new Button(data, SWT.PUSH);
		buttonvaliderlabel.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		buttonvaliderlabel.setText("Connexion");
		buttonvaliderlabel.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					int numconnexion = Integer.parseInt(entrernumlabel.getText());
				} catch (final NumberFormatException exc) {
					SWTUTils.showError(buttonvaliderlabel.getShell(), "Pas un nombre",
							"Veuillez mettre un nombre valide pour le Numéro de Sécurité Sociale.");
					System.err.println("pas un nombre");
					return;
				}
				try {
					//A faire après
				} catch (final NumberFormatException exc) {
					SWTUTils.showError(buttonvaliderlabel.getShell(), "Inexistant",
							"L'utilisateur n'existe pas.");
					System.err.println("pas de numéro correspondant");
					return;
				}
				
			}
		});

	}

}
