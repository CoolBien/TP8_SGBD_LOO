package bdd.view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;

import bdd.controller.Controller;
import bdd.data.TypeAnalyse;
import bdd.data.Utilisateur;

public class ReservationView {

	public ReservationView(final TabFolder tabFolder, final Utilisateur user) {

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
			combo.setData(""+type.getId(), type);
		}

		// Zone de la date de la réservation
		final Composite dateComposite = new Composite(composite, SWT.NONE);
		dateComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false));
		dateComposite.setLayout(new GridLayout(2, false));

		final DateTime startDateWidget = new DateTime(dateComposite, SWT.CALENDAR | SWT.SHORT);
		startDateWidget.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		final DateTime startTimeWidget = new DateTime(dateComposite, SWT.TIME | SWT.SHORT);
		startTimeWidget.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));


		// À laisser tout en bas en dernier :
		final Button reservationButton = new Button(composite, SWT.PUSH);
		reservationButton.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		reservationButton.setText("Réserver");
		reservationButton.addSelectionListener(SelectionListener.widgetSelectedAdapter(e -> {
			//
//			Controller.getInstance().addReservation(new Reservation(startDate, endDate, priceToPay, 0, null, null, user));
		}));

	}
}
