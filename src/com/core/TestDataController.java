package com.core;

import java.util.ArrayList;

import com.model.QuestionModel;
import com.model.TestModel;

public class TestDataController {
	
	private static final int DEFAULT_TEST_ID = 1;
	
	private static final String DEFAULT_TEST_NAME = "Default";
	
	private static TestDataController instance;
	
	private TestModel test;
	
	public TestDataController(){
		
		ArrayList<QuestionModel> defaultEmpty = new ArrayList<>();
		test = new TestModel(DEFAULT_TEST_ID, DEFAULT_TEST_NAME, defaultEmpty);
	}
	
	public static TestDataController getInstance(){
		if (instance == null){
			instance = new TestDataController();
		}
		return instance;
	}
	
	public void setTestName(String newTestName){
		test.setTestName(newTestName);
	}
	
	public String getTestName(){
		return test.getTestName();
	}
	
	public void addNewQuestion(QuestionModel newQuestion){
		test.getQuestionsContainer().add(newQuestion);
	}
	
	public void removeQuestion(QuestionModel newQuestion){
		test.getQuestionsContainer().remove(newQuestion);
	}
	
	public TestModel getTest(){
		return test;
	}
	
}
