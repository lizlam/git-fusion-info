package com.perforce.gitfusion.info.views;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;

import com.perforce.gitfusion.info.AddGFServerForm;
import com.perforce.gitfusion.info.GitFusionInfo;
import com.perforce.gitfusion.info.IGFInfoConstants;
import com.perforce.gitfusion.info.dialogs.GFUrlDialog;

/**
 * View to see Git Fusion Information
 */
public class GitFusionView extends ViewPart {
	Label label;
	Action action1;
	Action action2;
	Action action3;
	Action action4;
	Action action5;
	GitFusionInfo gfi = new GitFusionInfo();

	/**
	 * The ID of the view as specified by the extension.
	 */
	public static final String ID = "com.perforce.gitfusion.info.views.GitFusionView";

	@Override
	public void createPartControl(Composite parent) {
		Link link = new Link(parent, SWT.NONE);
		link.setText(IGFInfoConstants.PERFORCE_LINK);
		label = new Label(parent, SWT.LEFT);
		label.setText("");
		makeActions();
		contributeToActionBars();
	}

	private void contributeToActionBars() {
		IActionBars bars = getViewSite().getActionBars();
		fillLocalToolBar(bars.getToolBarManager());
	}

	private void fillLocalToolBar(IToolBarManager manager) {
		manager.add(action1);
		manager.add(action2);
		manager.add(action3);
		manager.add(action4);
		manager.add(action5);
	}

	private void makeActions() {
		action1 = new Action() {
			public void run() {
				showInfo();
			}
		};
		action1.setText("@info");
		action1.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));

		action2 = new Action() {
			public void run() {
				showList();
			}
		};
		action2.setText("@list");
		action2.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_OBJ_FILE));

		action3 = new Action() {
			public void run() {
				showHelp();
			}
		};
		action3.setText("@help");
		action3.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_LCL_LINKTO_HELP));

		action4 = new Action() {
			public void run() {
				action3.setText("@help");
				action3.setImageDescriptor(PlatformUI.getWorkbench()
						.getSharedImages()
						.getImageDescriptor(ISharedImages.IMG_LCL_LINKTO_HELP));

				clear();
			}
		};
		action4.setText("Clear");
		action4.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_ETOOL_CLEAR));

		action5 = new Action() {
			public void run() {
				setGFServer();
			}
		};
		action5.setText("Enter Git Fusion Server");
		action5.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_OBJ_ADD));

	}

	private void showInfo() {
		label.setText(gfi.getUrl() + format(IGFInfoConstants.INFO)
				+ gfi.getInfo());
	}

	private void showList() {
		label.setText(gfi.getUrl() + format(IGFInfoConstants.LIST)
				+ gfi.getList());
	}

	private void showHelp() {
		label.setText(gfi.getUrl() + format(IGFInfoConstants.HELP)
				+ gfi.getHelp());
	}

	private void clear() {
		label.setText(" ");
	}

	private void setGFServer() {
		
	}
//	private void setGFServer() {
//		GFUrlDialog dialog = new GFUrlDialog(new Shell());
//		dialog.open();
//		if (dialog.getUrl() != null) {
//			gfi.setUrl(dialog.getUrl());
//			label.setText(dialog.getUrl());
//		}
//	}

	private String format(String atCommand) {
		String substring = ":" + atCommand + "\n\n";
		return substring;
	}

	@Override
	public void setFocus() {
	}

}