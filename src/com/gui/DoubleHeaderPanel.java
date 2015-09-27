package com.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import com.core.QuastionChackable;
import com.core.UIControlable;

public class DoubleHeaderPanel extends BasePanelLayout implements QuastionChackable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8483515211093229781L;

	HeaderPanel question;

	HeaderPanel qNum;

	public DoubleHeaderPanel(UIControlable uiListener) {
		super();
		setLayout(new GridLayout(2, 2, 5, 5));
		question = new HeaderTextArea(QUESTION_TITLE, 100);
		((HeaderTextArea) question).setOnQuestionLenghtMore10(this);
		qNum = new HeaderTestField(QUESTION_UNSW_NUM_TITLE, 100, uiListener);
		add(question, BorderLayout.NORTH);
		add(qNum, BorderLayout.CENTER);

	}
	
	public void prepareToNext() {
		((HeaderTextArea) question).prepareNextQuestion();
		((HeaderTestField) qNum).prepareNext();
	}

	@Override
	public void onQuestionLenghtMore10() {
		((HeaderTestField) qNum).setTextEnabled(true);
	}

	@Override
	public void onQuestionLenghtLess10() {
		((HeaderTestField) qNum).setTextEnabled(false);
	}

	public String getQuestion() {
		return ((HeaderTextArea) question).getQuestion();
	}

	public int getAnswerNumber() {
		return ((HeaderTestField) qNum).getAnswerNumber();
	}
}
