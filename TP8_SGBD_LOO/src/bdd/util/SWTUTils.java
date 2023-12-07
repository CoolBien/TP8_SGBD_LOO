package bdd.util;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

public class SWTUTils {

	public static void showError(final Shell shell, final Throwable e) {
		final StringWriter out = new StringWriter();
		final PrintWriter pout = new PrintWriter(out);
		e.printStackTrace(pout);
		pout.flush();
		final String message = out.toString();
		System.err.println(message);

		final MessageBox errorMessage = new MessageBox(shell, SWT.ERROR);
		errorMessage.setText(e.getClass().getSimpleName());
		errorMessage.setMessage(message);
		errorMessage.open();
	}

	public static void showError(final Shell shell, final String title, final String message) {
		final MessageBox errorMessage = new MessageBox(shell, SWT.ICON_ERROR);
		errorMessage.setText(title);
		errorMessage.setMessage(message);
		errorMessage.open();
	}

	public static void showWarning(final Shell shell, final String title, final String message) {
		final MessageBox errorMessage = new MessageBox(shell, SWT.ICON_WARNING);
		errorMessage.setText(title);
		errorMessage.setMessage(message);
		errorMessage.open();
	}

	public static void showInfo(final Shell shell, final String title, final String message) {
		final MessageBox errorMessage = new MessageBox(shell, SWT.ICON_INFORMATION);
		errorMessage.setText(title);
		errorMessage.setMessage(message);
		errorMessage.open();
	}
}
