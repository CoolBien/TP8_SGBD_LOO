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

public class InscriptionView {

	public InscriptionView(final Composite composite) {
		final Composite data = new Composite(composite, SWT.NONE);
		data.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		data.setLayout(new GridLayout(2, false));

		final Label namelabel = new Label(data, SWT.NONE);
		namelabel.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		namelabel.setText("Nom");

		final Text nameText = new Text(data, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		nameText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		final Label firstNamelabel = new Label(data, SWT.NONE);
		firstNamelabel.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		firstNamelabel.setText("Prénom");

		final Text firstNametext = new Text(data, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		firstNametext.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		final Label numeroLabel = new Label(data, SWT.NONE);
		firstNamelabel.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		firstNamelabel.setText("N° Sécu");

		final Text numeroText = new Text(data, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		numeroText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		final Button button = new Button(data, SWT.PUSH);
		button.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
		button.setText("Inscription");
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				System.out.println("TODO connexion");
			}
		});
	}
}
