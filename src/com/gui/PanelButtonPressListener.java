package com.gui;

import java.awt.event.ActionEvent;

import javax.swing.JButton;

import com.core.UIControlable;

public class PanelButtonPressListener extends PressListener {
	
	private NavButtonType navButtonType;
	
	private JButton button;
	
	public JButton getButton() {
		return button;
	}

	public void setButton(JButton button) {
		this.button = button;
	}

	enum NavButtonType {
		
		NEXT ("Next"),
		
		PREVIOUS ("Previous"),
		
		FINISH ("Finish");
		
		private String buttonTypeName;
		
		private NavButtonType(String navType) {
			buttonTypeName = navType;
		}

		public String getButtonTypeName() {
			return buttonTypeName;
		}

		public void setButtonTypeName(String buttonTypeName) {
			this.buttonTypeName = buttonTypeName;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (navButtonType) {
		case NEXT:
			UIChangeListener.onNextTestPressed();
			break;
		case PREVIOUS:
			UIChangeListener.onPrevTestPressed();
			break;
		case FINISH:
			UIChangeListener.onFinishTestPressed();
			break;
		default:
			break;
		}
	}
	
	public PanelButtonPressListener(NavButtonType navButtonType, UIControlable listener) {
		super(listener);
		this.navButtonType = navButtonType;
		button = new JButton(navButtonType.getButtonTypeName());
		button.addActionListener(this);
	}

}
