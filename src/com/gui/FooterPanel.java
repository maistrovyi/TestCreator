package com.gui;

import com.core.UIControlable;
import com.gui.PanelButtonPressListener.NavButtonType;

public class FooterPanel extends BasePanelLayout {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1715034285236060413L;
	UIControlable uiListener;

	public FooterPanel(UIControlable listener) {
		uiListener = listener;
		PanelButtonPressListener prev = new PanelButtonPressListener(NavButtonType.PREVIOUS, listener);
		PanelButtonPressListener next = new PanelButtonPressListener(NavButtonType.NEXT, listener);
		PanelButtonPressListener finish = new PanelButtonPressListener(NavButtonType.FINISH, listener);
		add(next.getButton());
		add(finish.getButton());
	}

}
