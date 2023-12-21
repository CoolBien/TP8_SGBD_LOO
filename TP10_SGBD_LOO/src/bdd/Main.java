package bdd;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ShellListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import bdd.controller.Controller;
import bdd.util.HibernateUtil;
import bdd.view.ConnexionView;
import bdd.view.Inscription;

public class Main {

	public static void main(final String[] args) {

		try (final SessionFactory sessFact = HibernateUtil.getSessionFactory();
				final Session session = sessFact.getCurrentSession();) {
			System.out.println("Connecté");

			Controller.getInstance().setSession(session);

			final Display display = new Display();
			final Shell shell = new Shell(display);
			shell.setLayout(new GridLayout(1, false));

			final Composite composite = new Composite(shell, SWT.NONE);
			composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
			composite.setLayout(new GridLayout(2, false));

			new ConnexionView(composite);
			new Inscription(composite);

			shell.addShellListener(ShellListener.shellClosedAdapter(s -> Controller.getInstance().endSession()));
			shell.setText("Medecin ++");
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
