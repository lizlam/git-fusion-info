package com.perforce.gitfusion.info.dialogs;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class GFUrlDialog extends Dialog {
	private Text urlField;
	private String urlString;
	
	public GFUrlDialog(Shell parentShell) {
		super(parentShell);
	}
	
	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("Git Fusion");
		newShell.setSize(400, 150);
		Image image = new Image(newShell.getDisplay(), GFUrlDialog.class.getResourceAsStream(
				"P4-Fusion_32x32.png"));
		newShell.setImage(image);
	}
	
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite comp = (Composite) super.createDialogArea(parent);
		GridLayout layout = (GridLayout) comp.getLayout();
		layout.numColumns = 2;
		Label urlLabel = new Label(comp, SWT.RIGHT);
		urlLabel.setText("Enter Git Fusion URL: ");
		urlField = new Text(comp, SWT.SINGLE | SWT.BORDER);
		GridData data = new GridData(GridData.FILL_HORIZONTAL);
		urlField.setLayoutData(data);
		return comp;
	}
	
	@Override
	protected void okPressed() {
		if (urlField != null) {
			urlString = urlField.getText();
		}
		super.okPressed();
	}
	
	@Override
	protected void cancelPressed() {
		super.cancelPressed();
	}
	
	public String getUrl() {
		return urlString;
	}
}
