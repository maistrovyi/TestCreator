package com.gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class BasePanelLayout extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3559317291580762101L;

	public static final Border PADDING_BORDER = BorderFactory.createEmptyBorder(15, 15, 15, 15);

	protected static final String DEFAULT_DISPLAY_LAYOUT_VALUE = "No Question";
	
	protected static final String QUESTION_TITLE = "Question ";
	
	protected static final String QUESTION_UNSW_NUM_TITLE = "Answers number is : ";

	protected static final Border LINE_BORDER = BorderFactory.createLineBorder(Color.DARK_GRAY);
	
	protected static final Border OTHER_BORDER = BorderFactory.createCompoundBorder();
	
	protected static final Font FONT = new Font("Comic Sanc", Font.BOLD, 18);

	public BasePanelLayout() {
		super();
	}
}
