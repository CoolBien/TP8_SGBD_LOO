package bdd;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ShellListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import bdd.controller.Controller;
import bdd.ui.BourseView;
import bdd.ui.EnseignantView;
import bdd.ui.EnseignementView;
import bdd.ui.EtudiantView;
import bdd.util.HibernateUtil;

public class Main {
	public static void main(final String[] args) throws Exception {

		try (final SessionFactory sessFact = HibernateUtil.getSessionFactory();
				final Session session = sessFact.getCurrentSession();) {
			System.out.println("Connecté");

			final Display display = new Display();
			final Shell shell = new Shell(display);
			shell.setLayout(new GridLayout(1, false));

			final TabFolder tabFolder = new TabFolder(shell, SWT.TOP);
			tabFolder.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

			new EtudiantView(tabFolder);
			new EnseignantView(tabFolder);
			new EnseignementView(tabFolder);
			new BourseView(tabFolder);

			Controller.getInstance().setSession(session);

			shell.addShellListener(ShellListener.shellClosedAdapter(s -> Controller.getInstance().endSession()));
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
