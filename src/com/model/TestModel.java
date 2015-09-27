package com.model;

import java.util.ArrayList;

public class TestModel {
	
	private int id;
	
	private String testName;
	
	private ArrayList<QuestionModel> questionsContainer;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		id = testName.hashCode();
		this.testName = testName;
	}

	public ArrayList<QuestionModel> getQuestionsContainer() {
		return questionsContainer;
	}

	public void setQuestionsContainer(ArrayList<QuestionModel> questionsContainer) {
		this.questionsContainer = questionsContainer;
	}

	public TestModel(int id, String testName, ArrayList<QuestionModel> questionsContainer) {
		super();
		this.id = testName.hashCode();
		this.testName = testName;
		this.questionsContainer = questionsContainer;
	}
	
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return testName.length()*(testName.length() > 2 ? testName.indexOf(3): testName.charAt(0));
	}
	

}
