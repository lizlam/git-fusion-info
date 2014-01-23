package com.perforce.gitfusion.info;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.FormPage;

public class AddGFServerForm extends FormPage {
	
	public AddGFServerForm(String id, String title) {
		super(id, title);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createPartControl(Composite parent) {
		// TODO Auto-generated method stub
		super.createPartControl(parent);
		
	}
	
	public String getURL() {
		return "test";
	}

}
