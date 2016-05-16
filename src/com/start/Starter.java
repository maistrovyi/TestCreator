package com.start;

import javax.swing.JFrame;
import com.gui.MainWindow;

public class Starter {

	public static void main(String[] args) {

		JFrame mainWindow = new MainWindow();
		
		mainWindow.setVisible(true);
		
		mainWindow.setResizable(false);
	}
}
