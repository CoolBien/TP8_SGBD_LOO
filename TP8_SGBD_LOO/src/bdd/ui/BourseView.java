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
import bdd.data.Bourse;
import bdd.util.SWTUTils;

public class BourseView implements IControllerListener {

	private Table tableBourse;

	public BourseView(final TabFolder tabFolder) {
		Controller.getInstance().addListener(this);

		final TabItem tabItem = new TabItem(tabFolder, SWT.NONE);
		tabItem.setText("Bourse");


		final Composite composite = new Composite(tabFolder, SWT.NONE);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		composite.setLayout(new BorderLayout());
		tabItem.setControl(composite);

		tableBourse = new Table(composite, SWT.MULTI | SWT.FULL_SELECTION | SWT.BORDER);
		tableBourse.setLayoutData(new BorderData());
		tableBourse.setLinesVisible(true);
		tableBourse.setHeaderVisible(true);
		new TableColumn(tableBourse, SWT.LEAD).setText("ID");
		new TableColumn(tableBourse, SWT.LEAD).setText("Destination");
		new TableColumn(tableBourse, SWT.LEAD).setText("Nb Poste");
		new TableColumn(tableBourse, SWT.LEAD).setText("Responsable");

		for (final Bourse b: Controller.getInstance().getBourses()) {
			addBourse(b);
		}

		for (int i = 0; i < tableBourse.getColumnCount(); i++) {
			tableBourse.getColumn(i).pack();
		}

		final Composite dataBourse = new Composite(composite, SWT.NONE);
		dataBourse.setLayoutData(new BorderData(SWT.TOP));
		dataBourse.setLayout(new GridLayout(2, false));

		final Label label = new Label(dataBourse, SWT.NONE);
		label.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		label.setText("Destination");

		final Text text = new Text(dataBourse, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		final Label label1 = new Label(dataBourse, SWT.NONE);
		label1.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		label1.setText("Nombre de poste");

		final Text text1 = new Text(dataBourse, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		text1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		final Label label2 = new Label(dataBourse, SWT.NONE);
		label2.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		label2.setText("Responsable");

		final Text text2 = new Text(dataBourse, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		text2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		final Button button = new Button(dataBourse, SWT.PUSH);
		button.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
		button.setText("Ajouter");
		button.addSelectionListener(SelectionListener.widgetSelectedAdapter(e -> {
			final String destination = text.getText();
			int nbPoste = 0;
			final String responsable = text2.getText();
			try {
				nbPoste = Integer.parseInt(text1.getText());
			} catch (final NumberFormatException exc) {
				SWTUTils.showError(button.getShell(), "Pas un nombre",
						"Veuillez mettre un nombre valide pour le nombre de crédit.");
				System.err.println("pas un nombre");
				return;
			}
			final Bourse bourse = new Bourse(destination, nbPoste, responsable);
			Controller.getInstance().addBourse(bourse);
		}));
	}

	@Override
	public void addBourse(final Bourse bourse) {
		final TableItem tableItem = new TableItem(tableBourse, SWT.NONE);
		tableItem.setText(0, ""+bourse.getId());
		tableItem.setText(1, bourse.getDestination());
		tableItem.setText(2, ""+bourse.getNbPoste());
		tableItem.setText(3, bourse.getResponsable());
	}
}
