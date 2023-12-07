package bdd.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;

public class BourseView {

	public BourseView(TabFolder tabFolder) {

		final TabItem tabItem = new TabItem(tabFolder, SWT.NONE);
		tabItem.setText("Bourse");


		final Composite composite = new Composite(tabFolder, SWT.NONE);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		composite.setLayout(new GridLayout(1, false));
		tabItem.setControl(composite);
	}

}
