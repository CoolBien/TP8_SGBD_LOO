package bdd;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import bdd.util.HibernateUtil;

public class Main {
	public static void main(final String[] args) throws Exception {

		try (
			final SessionFactory sessFact = HibernateUtil.getSessionFactory();
			final Session session = sessFact.getCurrentSession();
		) {
			System.out.println("Connecté");

			final Display display = new Display();
			final Shell shell = new Shell(display);
			shell.setLayout(new GridLayout(1, false));

			final TabFolder tabFolder = new TabFolder(shell, SWT.TOP);
			tabFolder.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

			final TabItem tabItem = new TabItem(tabFolder, SWT.NONE);
			tabItem.setText("Etudiant");



			tabItem.setControl(composite);

			shell.pack();
			shell.open();
			while (!shell.isDisposed()) {
				if (!display.readAndDispatch())
					display.sleep();
			}
			display.dispose();

		}
	}
}
