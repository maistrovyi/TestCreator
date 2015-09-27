package com.gui;

import java.awt.event.ActionEvent;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import com.core.TestDataController;
import com.core.UIControlable;

public class MenuPressActionListener extends PressListener {

	private MenuButtonType menuButtonType;

	private JMenuItem menuItem;
	
	private String testName;

	public JMenuItem getMenuItem() {
		return menuItem;
	}

	public void setMenuItem(JMenuItem menuItem) {
		this.menuItem = menuItem;
	}

	public MenuPressActionListener(MenuButtonType menuButtonType, UIControlable listener) {
		super(listener);
		this.menuButtonType = menuButtonType;
		menuItem = new JMenuItem(menuButtonType.getMenuTypeName());
		menuItem.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		switch (menuButtonType) {
//		try catch
				
		case NEW:
			JOptionPane optionPane = new JOptionPane();
			try {
				while (!testName.equals("")) {
					testName = optionPane.showInputDialog("Please, input the name of the test!");
					optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
				}
				if (testName == null || testName.equals("")) {
	                JOptionPane.showMessageDialog(null, "No input.", "Error", JOptionPane.ERROR_MESSAGE);
	            }
			} catch (Exception e2) {
				optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
			}
			TestDataController.getInstance().setTestName(testName);
			MainWindow.getFrames()[0].setTitle(testName);
			UIChangeListener.onNewTestPressed();
			break;

		case OPEN:
			break;

		case EXIT:
			System.exit(0);

			break;

		default:
			break;
		}

	}

}
