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
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

import bdd.controller.Controller;
import bdd.controller.IControllerListener;
import bdd.data.Enseignant;

public class EnseignantView implements IControllerListener {

	private final Table tableEnseignant;

	public EnseignantView(final TabFolder tabFolder) {
		Controller.getInstance().addListener(this);

		final TabItem tabItem = new TabItem(tabFolder, SWT.NONE);
		tabItem.setText("Enseignant");

		final Composite composite = new Composite(tabFolder, SWT.NONE);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		composite.setLayout(new BorderLayout());
		tabItem.setControl(composite);

		final Composite dataEnseignant = new Composite(composite, SWT.NONE);
		dataEnseignant.setLayoutData(new BorderData(SWT.TOP));
		dataEnseignant.setLayout(new GridLayout(2, false));

		tableEnseignant = new Table(composite, SWT.SINGLE | SWT.FULL_SELECTION | SWT.BORDER);
		tableEnseignant.setLayoutData(new BorderData(SWT.CENTER));
		tableEnseignant.setLinesVisible(true);
		tableEnseignant.setHeaderVisible(true);
		new TableColumn(tableEnseignant, SWT.LEAD).setText("Id");
		new TableColumn(tableEnseignant, SWT.LEAD).setText("NOM");
		new TableColumn(tableEnseignant, SWT.LEAD).setText("Prénom");

		for (final Enseignant e : Controller.getInstance().getEnseignants()) {
			addEnseignant(e);
		}

		for (int i = 0; i < tableEnseignant.getColumnCount(); i++) {
			tableEnseignant.getColumn(i).pack();
		}

		final Label label = new Label(dataEnseignant, SWT.NONE);
		label.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		label.setText("Nom");

		final Text text = new Text(dataEnseignant, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		final Label label1 = new Label(dataEnseignant, SWT.NONE);
		label1.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		label1.setText("Prénom");

		final Text text1 = new Text(dataEnseignant, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		text1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		final Button button = new Button(dataEnseignant, SWT.PUSH);
		button.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
		button.setText("Ajouter");
		button.addSelectionListener(SelectionListener.widgetSelectedAdapter(e -> {
			final String nom = text.getText();
			final String prenom = text1.getText();

			final Enseignant enseignant = new Enseignant(nom, prenom);
			Controller.getInstance().addEnseignant(enseignant);
		}));
	}

	@Override
	public void addEnseignant(final Enseignant enseignant) {
		final TableItem tableItem = new TableItem(tableEnseignant, SWT.NONE);
		tableItem.setText(0, "" + enseignant.getId());
		tableItem.setText(1, enseignant.getNom());
		tableItem.setText(2, enseignant.getPrenom());
	}
}
