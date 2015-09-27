package com.gui;

import java.awt.Color;

import javax.swing.JComboBox;

public class CorrectAnswerPanel extends HeaderPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6788993981947690981L;

	JComboBox<Integer> selector;

	int num;

	public CorrectAnswerPanel(String title, int num) {
		super(title);
		this.num = num;
		selector = new JComboBox<Integer>();
		for (int i = 1; i <= num; i++) {
			selector.addItem(i);
		}

		add(selector);
	}

	public int getCorrectAnswer() {
		return (int) selector.getSelectedItem();
	}

	@Override
	public boolean validateValue() {
		if ((int) selector.getSelectedItem() > 0) {
			return true;
		}
		selector.setBackground(Color.red);
		return false;
	}
}
