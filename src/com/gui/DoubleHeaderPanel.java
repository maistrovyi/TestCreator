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
	
	UIControlable uiListener;

	public DoubleHeaderPanel(UIControlable uiListener) {
		super();
		this.uiListener = uiListener;
		setLayout(new GridLayout(2, 2, 5, 5));
		question = new HeaderTextArea(QUESTION_TITLE + 1, 100);
		question.setSize(getMaximumSize());
		((HeaderTextArea) question).setOnQuestionLenghtMore10(this);
		qNum = new HeaderTestField(QUESTION_UNSW_NUM_TITLE, 4000, uiListener);
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
		uiListener.onQuestionLenghtMore10();
	}

	@Override
	public void onQuestionLenghtLess10() {
		((HeaderTestField) qNum).setTextEnabled(false);
		uiListener.onQuestionLenghtLess10();
	}

	public String getQuestion() {
		return ((HeaderTextArea) question).getQuestion();
	}

	public int getAnswerNumber() {
		return ((HeaderTestField) qNum).getAnswerNumber();
	}
}
