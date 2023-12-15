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
import bdd.util.SWTUTils;

public class EtudiantView implements IControllerListener {

	private Table tableEtudiant;
	private Combo combo;
	private Combo combo2;
	private Combo combo3;
	private Combo combo4;

	public EtudiantView(final TabFolder tabFolder) {
		Controller.getInstance().addListener(this);

		final TabItem tabItem = new TabItem(tabFolder, SWT.NONE);
		tabItem.setText("Étudiant");

		final Composite composite = new Composite(tabFolder, SWT.NONE);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		composite.setLayout(new BorderLayout());
		tabItem.setControl(composite);

		tableEtudiant = new Table(composite, SWT.MULTI | SWT.FULL_SELECTION | SWT.BORDER);
		tableEtudiant.setLayoutData(new BorderData(SWT.CENTER));
		tableEtudiant.setLinesVisible(true);
		tableEtudiant.setHeaderVisible(true);
		new TableColumn(tableEtudiant, SWT.LEAD).setText("N° Etu");
		new TableColumn(tableEtudiant, SWT.LEAD).setText("NOM");
		new TableColumn(tableEtudiant, SWT.LEAD).setText("Prénom");
		new TableColumn(tableEtudiant, SWT.LEAD).setText("Note moyenne du dernier semestre");

		for (final Etudiant e : Controller.getInstance().getEtudiants()) {
			addEtudiant(e);
		}

		for (int i = 0; i < tableEtudiant.getColumnCount(); i++) {
			tableEtudiant.getColumn(i).pack();
		}

		final Composite dataEtudiant = new Composite(composite, SWT.NONE);
		dataEtudiant.setLayoutData(new BorderData(SWT.TOP));
		dataEtudiant.setLayout(new GridLayout(2, false));

		final Label label = new Label(dataEtudiant, SWT.NONE);
		label.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		label.setText("Nom");

		final Text text = new Text(dataEtudiant, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		final Label label1 = new Label(dataEtudiant, SWT.NONE);
		label1.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		label1.setText("Prenom");

		final Text text1 = new Text(dataEtudiant, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		text1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		final Label label2 = new Label(dataEtudiant, SWT.NONE);
		label2.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		label2.setText("Note moyenne du dernier semestre");

		final Text text2 = new Text(dataEtudiant, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		text2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		final Label label3 = new Label(dataEtudiant, SWT.NONE);
		label3.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		label3.setText("Enseignement");

		combo = new Combo(dataEtudiant, SWT.DROP_DOWN | SWT.READ_ONLY);
		combo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		for (final Enseignement e : Controller.getInstance().getEnseignements()) {
			addEnseignement(e);
		}

		final Label label4 = new Label(dataEtudiant, SWT.NONE);
		label4.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		label4.setText("Enseignant");

		combo2 = new Combo(dataEtudiant, SWT.DROP_DOWN | SWT.READ_ONLY);
		combo2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		for (final Enseignant e : Controller.getInstance().getEnseignants()) {
			addEnseignant(e);
		}

		final Label label5 = new Label(dataEtudiant, SWT.NONE);
		label5.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		label5.setText("Bourse 1");

		combo3 = new Combo(dataEtudiant, SWT.DROP_DOWN | SWT.READ_ONLY);
		combo3.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		final Label label6 = new Label(dataEtudiant, SWT.NONE);
		label6.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		label6.setText("Bourse 2");

		combo4 = new Combo(dataEtudiant, SWT.DROP_DOWN | SWT.READ_ONLY);
		combo4.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		for (final Bourse b : Controller.getInstance().getBourses()) {
			addBourse(b);
		}

		final Button button = new Button(dataEtudiant, SWT.PUSH);
		button.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
		button.setText("Ajouter");
		button.addSelectionListener(SelectionListener.widgetSelectedAdapter(e -> {
			final String nom = text.getText();
			final String prenom = text1.getText();
			float notemoy = 0;
			try {
				notemoy = Float.parseFloat(text2.getText());
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
			final Etudiant etudiant = new Etudiant(nom, prenom, 0, notemoy);
			Controller.getInstance().addEtudiant(etudiant);
		}));
	}

	@Override
	public void addEtudiant(final Etudiant etudiant) {
		final TableItem tableItem = new TableItem(tableEtudiant, SWT.NONE);
		tableItem.setText(0, "" + etudiant.getNumeroEtu());
		tableItem.setText(1, etudiant.getNom());
		tableItem.setText(2, etudiant.getPrenom());
		tableItem.setText(3, String.format("%2.1f", etudiant.getNoteMoyLastSemester()));
	}

	@Override
	public void addEnseignement(final Enseignement enseignement) {
		combo.add(enseignement.getNom());
	}

	@Override
	public void addEnseignant(final Enseignant enseignant) {
		combo2.add(enseignant.getNom()+" "+enseignant.getPrenom());
	}

	@Override
	public void addBourse(final Bourse bourse) {
		combo3.add(bourse.getDestination());
		combo4.add(bourse.getDestination());
	}
}
