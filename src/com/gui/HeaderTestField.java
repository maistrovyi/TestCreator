package com.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.JTextField;

import com.core.UIControlable;

public class HeaderTestField extends HeaderPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2180478937275487913L;

	UIControlable listener;

	private JTextField questionField;

	int numAnswer = 0;

	public void setTextEnabled(boolean isEnabled) {
		questionField.setEnabled(isEnabled ? true : false);
	}

	public void prepareNext() {
		questionField.setText("0");
		setTextEnabled(false);
	}

	public HeaderTestField(String title, int size, UIControlable listener) {
		super(title);
		this.listener = listener;
		questionField = new JTextField("0");
		questionField.setEnabled(false);
		questionField.addKeyListener(new KeyAdapter() {

			boolean isValid = false;
			boolean isDeleted = true;
			boolean isFirstInput = true;

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent ke) {
				if (isFirstInput) {
					questionField.setText("");
				}
				isFirstInput = false;
				int code = ke.getKeyCode();
				if (isValid(code) && !isDeleting(code)) {
					Character c = ke.getKeyChar();
					questionField.setText(Character.toString(c));
					proceedValue(c);
				}
				if (questionField.getText().length() <= 1) {
					if (isValid(code)) {
						if (isDeleting(code)) {
							proceedDeleting();
						} else {
							isValid = true;
						}
					} else {
						isValid = false;
						ke.consume();
						setValue();
					}
				} else {
					isValid = false;
					ke.consume();
					setValue();
				}
			}

			public void keyPressed(KeyEvent ke) {
			}

			private void setValue() {
				if (isValid) {
					questionField.setText(questionField.getText());
				} else {
					if (questionField.getText().length() == 1) {
						questionField.setText("");
					} else {
						if (!questionField.getText().equals("")) {
							questionField.setText(questionField.getText().substring(0, 1));
						}
					}
				}

			}

			private void theSame() {
				questionField.setText(questionField.getText());
			}

			private void proceedDeleting() {
				listener.onNumUnswersInput(0);
			}

			private boolean isValid(int code) {
				if (code == KeyEvent.VK_BACK_SPACE || code == KeyEvent.VK_ESCAPE
						|| (code > KeyEvent.VK_0 && code <= KeyEvent.VK_9)) {
					return true;
				}
				return false;
			}

			private boolean isDeleting(int code) {
				return (code == KeyEvent.VK_BACK_SPACE || code == KeyEvent.VK_ESCAPE) ? true : false;
			}

			private void proceedValue(Character ch) {
				numAnswer = Character.getNumericValue(ch);
				listener.onNumUnswersInput(numAnswer);
				HeaderTestField.this.revalidate();
			}
		});
		questionField.setBorder(BorderFactory.createCompoundBorder(LINE_BORDER, TestPanel.PADDING_BORDER));
		questionField.setOpaque(true);
		questionField.setBackground(Color.WHITE);
		questionField.setFont(FONT);
		add(questionField, BorderLayout.NORTH);
	}

	@Override
	public boolean validateValue() {
		return false;
	}

	public int getAnswerNumber() {
		return Integer.parseInt(questionField.getText());
	}

}
