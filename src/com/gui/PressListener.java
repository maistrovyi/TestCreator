package com.gui;

import java.awt.event.ActionListener;

import com.core.UIControlable;

public abstract class PressListener implements ActionListener {
	
	protected UIControlable getListener() {
		return UIChangeListener;
	}
	
	protected UIControlable UIChangeListener;
	
	public PressListener(UIControlable listener) {
		
		UIChangeListener = listener;
	}

}
