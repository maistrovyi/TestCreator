package com.model;

import java.util.ArrayList;

public class QuestionModel {
	
	private int id;
	
	private String question;
	
	private int numUnswers;
	
	private ArrayList<UnswerModel> container = new ArrayList<>();

	public QuestionModel(int id, String question, int numUnswers) {
		super();
		this.id = id;
		this.question = question;
		this.numUnswers = numUnswers;
	}
	
	public ArrayList<UnswerModel> getContainer() {
		return container;
	}

	public void setContainer(ArrayList<UnswerModel> container) {
		this.container = container;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public int getNumUnswers() {
		return numUnswers;
	}

	public void setNumUnswers(int numUnswers) {
		this.numUnswers = numUnswers;
	}
	
	public void setCorrectAnswer(int index){
		container.get(index-1).setCorrect(true);
	}
	
	public int getCorrectAnswerIndex(){
		for (UnswerModel answer : container){
			if (answer.isCorrect()){
				return container.indexOf(answer)+1;
			}
		}
		return 0;
	}

}
