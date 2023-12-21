package bdd.view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;

import bdd.controller.Controller;
import bdd.data.TypeAnalyse;

public class ReservationView {

	public ReservationView(final TabFolder tabFolder) {

		final TabItem tabItem = new TabItem(tabFolder, SWT.NONE);
		tabItem.setText("Réserver");
		final Composite composite = new Composite(tabFolder, SWT.NONE);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		composite.setLayout(new GridLayout(1, false));

		tabItem.setControl(composite);

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
