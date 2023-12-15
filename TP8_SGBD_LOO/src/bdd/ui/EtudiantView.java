package bdd.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.BorderData;
import org.eclipse.swt.layout.BorderLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
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
import bdd.data.Enseignant;
import bdd.data.Enseignement;
import bdd.data.Etudiant;
import bdd.data.Evaluation;
import bdd.util.SWTUTils;

public class EtudiantView implements IControllerListener {

	private Table tableEtudiant;
	private Combo comboEnseignement;
	private Combo comboEnseignant1;
	private Combo comboEnseignant2;
	private Combo comboBourse1;
	private Combo comboBourse2;
	private Table tableEnseignement;


	public EtudiantView(final TabFolder tabFolder) {
		Controller.getInstance().addListener(this);

		final TabItem tabItem = new TabItem(tabFolder, SWT.NONE);
		tabItem.setText("Étudiant");

		final Composite composite = new Composite(tabFolder, SWT.NONE);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		composite.setLayout(new GridLayout(2, false));
		tabItem.setControl(composite);

		final Composite leftComposite = new Composite(composite, SWT.NONE);
		leftComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		leftComposite.setLayout(new BorderLayout());

		tableEtudiant = new Table(leftComposite, SWT.SINGLE | SWT.FULL_SELECTION | SWT.BORDER);
		tableEtudiant.setLayoutData(new BorderData(SWT.CENTER));
		tableEtudiant.setLinesVisible(true);
		tableEtudiant.setHeaderVisible(true);
		new TableColumn(tableEtudiant, SWT.LEAD).setText("N° Etu");
		new TableColumn(tableEtudiant, SWT.LEAD).setText("NOM");
		new TableColumn(tableEtudiant, SWT.LEAD).setText("Prénom");
		new TableColumn(tableEtudiant, SWT.LEAD).setText("Note moyenne du dernier semestre");
		new TableColumn(tableEtudiant, SWT.LEAD).setText("Enseignant 1");
		new TableColumn(tableEtudiant, SWT.LEAD).setText("Note 1");
		new TableColumn(tableEtudiant, SWT.LEAD).setText("Enseignant 2");
		new TableColumn(tableEtudiant, SWT.LEAD).setText("Note 2");
		new TableColumn(tableEtudiant, SWT.LEAD).setText("Bourse 1");
		new TableColumn(tableEtudiant, SWT.LEAD).setText("Bourse 2");

		for (final Etudiant e : Controller.getInstance().getEtudiants()) {
			addEtudiant(e);
		}

		for (int i = 0; i < tableEtudiant.getColumnCount(); i++) {
			tableEtudiant.getColumn(i).pack();
		}

		final Composite dataEtudiant = new Composite(leftComposite, SWT.NONE);
		dataEtudiant.setLayoutData(new BorderData(SWT.TOP));
		dataEtudiant.setLayout(new GridLayout(2, false));

		final Label label = new Label(dataEtudiant, SWT.NONE);
		label.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		label.setText("Nom");

		final Text lastNameEntry = new Text(dataEtudiant, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		lastNameEntry.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		final Label label1 = new Label(dataEtudiant, SWT.NONE);
		label1.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		label1.setText("Prénom");

		final Text firstNameEntry = new Text(dataEtudiant, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		firstNameEntry.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		final Label label2 = new Label(dataEtudiant, SWT.NONE);
		label2.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		label2.setText("Note moyenne du dernier semestre");

		final Text noteEntry = new Text(dataEtudiant, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		noteEntry.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		final Label label4 = new Label(dataEtudiant, SWT.NONE);
		label4.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		label4.setText("Enseignant 1");

		comboEnseignant1 = new Combo(dataEtudiant, SWT.DROP_DOWN | SWT.READ_ONLY);
		comboEnseignant1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		final Label label7 = new Label(dataEtudiant, SWT.NONE);
		label7.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		label7.setText("Enseignant 2");

		comboEnseignant2 = new Combo(dataEtudiant, SWT.DROP_DOWN | SWT.READ_ONLY);
		comboEnseignant2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		for (final Enseignant e : Controller.getInstance().getEnseignants()) {
			addEnseignant(e);
		}

		final Label label5 = new Label(dataEtudiant, SWT.NONE);
		label5.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		label5.setText("Bourse 1");

		comboBourse1 = new Combo(dataEtudiant, SWT.DROP_DOWN | SWT.READ_ONLY);
		comboBourse1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		comboBourse1.add("Pas de bourse");
		comboBourse1.setText("Pas de bourse");
		comboBourse1.setData("0", null);

		final Label label6 = new Label(dataEtudiant, SWT.NONE);
		label6.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		label6.setText("Bourse 2");

		comboBourse2 = new Combo(dataEtudiant, SWT.DROP_DOWN | SWT.READ_ONLY);
		comboBourse2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		comboBourse2.add("Pas de bourse");
		comboBourse2.setText("Pas de bourse");
		comboBourse2.setData("0", null);

		for (final Bourse b : Controller.getInstance().getBourses()) {
			addBourse(b);
		}

		final Label label8 = new Label(dataEtudiant, SWT.NONE);
		label8.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		label8.setText("Note 1");

		final Text noteEntry1 = new Text(dataEtudiant, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		noteEntry1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		final Label label9 = new Label(dataEtudiant, SWT.NONE);
		label9.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		label9.setText("Note 2");

		final Text noteEntry2 = new Text(dataEtudiant, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		noteEntry2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		final Button button = new Button(dataEtudiant, SWT.PUSH);
		button.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
		button.setText("Ajouter");
		button.addSelectionListener(SelectionListener.widgetSelectedAdapter(e -> {
			final String nom = lastNameEntry.getText();
			final String prenom = firstNameEntry.getText();
			float notemoy = 0;
			float note1 = 0;
			float note2 = 0;
			try {
				notemoy = Float.parseFloat(noteEntry.getText());
			} catch (final NumberFormatException exc) {
				SWTUTils.showError(button.getShell(), "Pas un nombre",
						"Veuillez mettre un nombre valide pour la note.");
				System.err.println("pas un nombre");
				return;
			}
			if (notemoy < 0 || notemoy > 20) {
				SWTUTils.showError(button.getShell(), "Nombre invalide",
						"Veuillez mettre un nombre valide entre 0 et 20 pour la note.");
				System.err.println("nombre invalide");
				return;
			}

			try {
				note1 = Float.parseFloat(noteEntry1.getText());
			} catch (final NumberFormatException exc) {
				SWTUTils.showError(button.getShell(), "Pas un nombre",
						"Veuillez mettre un nombre valide pour la note.");
				System.err.println("pas un nombre");
				return;
			}
			try {
				note2 = Float.parseFloat(noteEntry2.getText());
			} catch (final NumberFormatException exc) {
				SWTUTils.showError(button.getShell(), "Pas un nombre",
						"Veuillez mettre un nombre valide pour la note.");
				System.err.println("pas un nombre");
				return;
			}

			final Evaluation eval1 = new Evaluation();
			final Evaluation eval2 = new Evaluation();

			eval1.setEnseignant((Enseignant) comboEnseignant1.getData(""+(comboEnseignant1.getSelectionIndex())));
			eval2.setEnseignant((Enseignant) comboEnseignant2.getData(""+(comboEnseignant2.getSelectionIndex())));

			eval1.setNote(note1);
			eval2.setNote(note2);

			final Etudiant etudiant = new Etudiant(nom, prenom, 0, notemoy);
			etudiant.setEvaluation1(eval1);
			etudiant.setEvaluation2(eval2);
			etudiant.setBourse1((Bourse) comboBourse1.getData(""+comboBourse1.getSelectionIndex()));
			etudiant.setBourse2((Bourse) comboBourse2.getData(""+comboBourse2.getSelectionIndex()));

			Controller.getInstance().addEtudiant(etudiant);
		}));

		final Composite rightComposite = new Composite(composite, SWT.NONE);
		rightComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		rightComposite.setLayout(new BorderLayout());

		tableEnseignement = new Table(rightComposite, SWT.MULTI | SWT.FULL_SELECTION | SWT.BORDER);
		tableEnseignement.setLayoutData(new BorderData(SWT.CENTER));
		tableEnseignement.setLinesVisible(true);
		tableEnseignement.setHeaderVisible(true);
		new TableColumn(tableEnseignement, SWT.NONE).setText("Enseignement");

		for (int i = 0; i < tableEnseignement.getColumnCount(); i++) {
			tableEnseignement.getColumn(i).pack();
		}

		final Composite dataEnseignement = new Composite(rightComposite, SWT.NONE);
		dataEnseignement.setLayoutData(new BorderData(SWT.TOP));
		dataEnseignement.setLayout(new GridLayout(2, false));

		final Label label3 = new Label(dataEnseignement, SWT.NONE);
		label3.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		label3.setText("Enseignement");

		comboEnseignement = new Combo(dataEnseignement, SWT.DROP_DOWN | SWT.READ_ONLY);
		comboEnseignement.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		for (final Enseignement e : Controller.getInstance().getEnseignements()) {
			addEnseignement(e);
		}

		final Button buttonAddEnseignement = new Button(dataEnseignement, SWT.PUSH);
		buttonAddEnseignement.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
		buttonAddEnseignement.setText("Ajouter un enseignement");
		buttonAddEnseignement.addSelectionListener(SelectionListener.widgetSelectedAdapter(e -> {
			//
		}));

	}

	@Override
	public void addEtudiant(final Etudiant etudiant) {
		// get evaluations
		final Evaluation evaluation1 = etudiant.getEvaluation1();
		final Evaluation evaluation2 = etudiant.getEvaluation2();

		final TableItem tableItem = new TableItem(tableEtudiant, SWT.NONE);
		tableItem.setText(0, "" + etudiant.getNumeroEtu());
		tableItem.setText(1, etudiant.getNom());
		tableItem.setText(2, etudiant.getPrenom());
		tableItem.setText(3, String.format("%2.1f", etudiant.getNoteMoyLastSemester()));

		if (evaluation1 != null) {
			final Enseignant enseignant1 = evaluation1.getEnseignant();
			tableItem.setText(4,    enseignant1.getNom()+" "+enseignant1.getPrenom());
			tableItem.setText(5, ""+evaluation1.getNote());
		}

		if (evaluation2 != null) {
			final Enseignant enseignant2 = evaluation2.getEnseignant();
			tableItem.setText(6,    enseignant2.getNom()+" "+enseignant2.getPrenom());
			tableItem.setText(7, ""+evaluation2.getNote());
		}

		final Bourse bourse1 = etudiant.getBourse1();
		if (bourse1 != null) {
			tableItem.setText(8, bourse1.getDestination());
		}

		final Bourse bourse2 = etudiant.getBourse2();
		if (bourse2 != null) {
			tableItem.setText(9, bourse2.getDestination());
		}
	}

	@Override
	public void addEnseignement(final Enseignement enseignement) {
		comboEnseignement.add(enseignement.getNom());
		comboEnseignement.setData(""+comboEnseignement.getItemCount(), enseignement);
	}

	@Override
	public void addEnseignant(final Enseignant enseignant) {
		comboEnseignant1.setData(""+comboEnseignant1.getItemCount(), enseignant);
		comboEnseignant2.setData(""+comboEnseignant2.getItemCount(), enseignant);
		comboEnseignant1.add(enseignant.getNom()+" "+enseignant.getPrenom());
		comboEnseignant2.add(enseignant.getNom()+" "+enseignant.getPrenom());
	}

	@Override
	public void addBourse(final Bourse bourse) {
		comboBourse1.setData(""+comboBourse1.getItemCount(), bourse);
		comboBourse2.setData(""+comboBourse2.getItemCount(), bourse);
		comboBourse1.add(bourse.getDestination());
		comboBourse2.add(bourse.getDestination());
	}
}
