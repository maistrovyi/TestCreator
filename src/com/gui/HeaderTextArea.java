package com.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.BorderFactory;
import javax.swing.JTextArea;

import com.core.QuastionChackable;

public class HeaderTextArea extends HeaderPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6656395526405676422L;

	private JTextArea questionArea;
	
	private static final int MIN_QUESTION_LENGTH = 10;
	
	private QuastionChackable callback;
	
    public HeaderTextArea(String title, int size) {
		super(title);
        questionArea = new JTextArea();
        questionArea.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				if (questionArea.getText().length() >= MIN_QUESTION_LENGTH) {
					callback.onQuestionLenghtMore10();
				} else {
					callback.onQuestionLenghtLess10();
				}
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
			}
		});
        questionArea.setBorder(BorderFactory.createCompoundBorder(LINE_BORDER, TestPanel.PADDING_BORDER));
        questionArea.setOpaque(true);
        questionArea.setBackground(Color.WHITE);
        questionArea.setFont(FONT);
        add(questionArea, BorderLayout.NORTH);
	}

    public void setOnQuestionLenghtMore10(QuastionChackable callback) {
		this.callback = callback;
	}

	@Override
	public boolean validateValue() {
		return false;
	}
	
    
    public String getQuestion() {
		return questionArea.getText();
	}

    public void prepareNextQuestion() {
	    questionArea.setText("");
	}
    
}
