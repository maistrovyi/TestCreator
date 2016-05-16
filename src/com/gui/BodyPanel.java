package com.gui;

import javax.swing.BoxLayout;

public class BodyPanel extends HeaderPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5336367131345735649L;

	AnswerPanel answerPanel;

	CorrectAnswerPanel shooserPanel;

	public BodyPanel(String title, int num) {
		super(title);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		answerPanel = new AnswerPanel("", num);
		add(answerPanel);
		shooserPanel = new CorrectAnswerPanel("Choose number of correct answer", num);
		add(shooserPanel);
	}

	@Override
	public boolean validateValue() {
		return false;
	}

}
