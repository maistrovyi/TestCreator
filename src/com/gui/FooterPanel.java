package com.gui;

import com.core.UIControlable;
import com.gui.PanelButtonPressListener.NavButtonType;

public class FooterPanel extends BasePanelLayout {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1715034285236060413L;
	
	PanelButtonPressListener prev;
	
	PanelButtonPressListener next;
	 
	PanelButtonPressListener finish;
	
	UIControlable uiListener;

	public FooterPanel(UIControlable listener) {
		uiListener = listener;
		prev = new PanelButtonPressListener(NavButtonType.PREVIOUS, listener);
		next = new PanelButtonPressListener(NavButtonType.NEXT, listener);
		finish = new PanelButtonPressListener(NavButtonType.FINISH, listener);
		add(next.getButton());
		add(finish.getButton());
	}

	public void enableButtons(boolean isEnabled) {
		prev.getButton().setEnabled(isEnabled ? true : false);
		next.getButton().setEnabled(isEnabled ? true : false);
		finish.getButton().setEnabled(isEnabled ? true : false);
	}
	
}
