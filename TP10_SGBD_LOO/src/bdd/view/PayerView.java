package bdd.view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

import bdd.controller.Controller;
import bdd.controller.IControllerListener;
import bdd.data.Reservation;
import bdd.data.Utilisateur;

public class PayerView implements IControllerListener {

	private final Table tableReservation;

	public PayerView(final TabFolder tabFolder, final Utilisateur user) {
		Controller.getInstance().addListener(this);

		final TabItem tabItem = new TabItem(tabFolder, SWT.NONE);
		tabItem.setText("Payer");
		final Composite composite = new Composite(tabFolder, SWT.NONE);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		composite.setLayout(new GridLayout(2, false));

		tabItem.setControl(composite);

		tableReservation = new Table(composite, SWT.SINGLE | SWT.FULL_SELECTION | SWT.BORDER);
		tableReservation.setLayoutData(new GridData());
		tableReservation.setLinesVisible(true);
		tableReservation.setHeaderVisible(true);
		new TableColumn(tableReservation, SWT.LEAD).setText("Id");
		new TableColumn(tableReservation, SWT.LEAD).setText("Utilsiateurs");
		new TableColumn(tableReservation, SWT.LEAD).setText("Médecin");
		new TableColumn(tableReservation, SWT.LEAD).setText("Date de début");
		new TableColumn(tableReservation, SWT.LEAD).setText("Date de fin");
		new TableColumn(tableReservation, SWT.LEAD).setText("Prix payé");
		new TableColumn(tableReservation, SWT.LEAD).setText("Prix à payer");

		for (final Reservation e : Controller.getInstance().getReservations(user)) {
			addReservation(e);
		}

		for (int i = 0; i < tableReservation.getColumnCount(); i++) {
			tableReservation.getColumn(i).pack();
		}
		
		Button buttonPay = new Button(composite, SWT.PUSH);
		buttonPay.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		buttonPay.setText("Payer");
		buttonPay.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
			}
		});
		
	}

	@Override
	public void addReservation(final Reservation reservation) {
		final TableItem tableItem = new TableItem(tableReservation, SWT.NONE);
		tableItem.setText(0, "" + reservation.getId());
		tableItem.setText(1, "" + reservation.getUser());
		tableItem.setText(2, "" + reservation.getMedecin());
		tableItem.setText(3, "" + reservation.getStartDate());
		tableItem.setText(4, "" + reservation.getEndDate());
		tableItem.setText(5, "" + reservation.getPricePayed());
		tableItem.setText(6, "" + reservation.getPriceToPay());
	}
}
