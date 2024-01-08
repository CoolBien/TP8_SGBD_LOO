package bdd.view;

import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;

import bdd.controller.Controller;
import bdd.data.Medecin;
import bdd.data.TypeAnalyse;
import bdd.data.Utilisateur;

public class ReservationView {

	private final Combo comboMedecin;

	public ReservationView(final TabFolder tabFolder, final Utilisateur user) {

		final TabItem tabItem = new TabItem(tabFolder, SWT.NONE);
		tabItem.setText("Réserver");
		final Composite composite = new Composite(tabFolder, SWT.NONE);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		composite.setLayout(new GridLayout(1, false));

		tabItem.setControl(composite);

		final Label labelTypeAnalyse = new Label(composite, SWT.NONE);
		labelTypeAnalyse.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		labelTypeAnalyse.setText("Choisir un type d'analyse");

		final Combo comboTypeAnalyse = new Combo(composite, SWT.DROP_DOWN | SWT.READ_ONLY);
		comboTypeAnalyse.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		final List<TypeAnalyse> allTypeAnalyses = Controller.getInstance().getAllTypeAnalyses();
		for (int i = 0; i < allTypeAnalyses.size(); i++) {
			final TypeAnalyse type = allTypeAnalyses.get(i);
			comboTypeAnalyse.add(type.toString());
			comboTypeAnalyse.setData(""+i, type);
		}
		comboTypeAnalyse.addSelectionListener(SelectionListener.widgetSelectedAdapter(e -> {
			final TypeAnalyse type = (TypeAnalyse) comboTypeAnalyse.getData("" + comboTypeAnalyse.getSelectionIndex());
			selectTypeAnalyse(type);
		}));

		final Label labelMedecin = new Label(composite, SWT.NONE);
		labelMedecin.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		labelMedecin.setText("Choisir un médecin habilité");

		comboMedecin = new Combo(composite, SWT.DROP_DOWN | SWT.READ_ONLY);
		comboMedecin.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		// À laisser tout en bas en dernier :
		final Button reservationButton = new Button(composite, SWT.PUSH);
		reservationButton.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		reservationButton.setText("Réserver");
		reservationButton.addSelectionListener(SelectionListener.widgetSelectedAdapter(e -> {
			//
//			Controller.getInstance().addReservation(new Reservation(startDate, endDate, priceToPay, 0, null, null, user));
		}));

	}

	public void selectTypeAnalyse(final TypeAnalyse analyse) {
		comboMedecin.removeAll();
		for (final Medecin medecin: Controller.getInstance().getMedecinForAnalyse(analyse)) {
			comboMedecin.add(medecin.getFirstName()+" "+medecin.getName().toUpperCase());
			comboMedecin.setData(""+medecin.getId(), medecin);
		}
	}
}
