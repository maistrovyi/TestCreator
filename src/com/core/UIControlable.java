package com.core;

public interface UIControlable extends Inputable, QuestionChackable {
	
	void onNewTestPressed();
	
	void onNextTestPressed();
	
	void onPrevTestPressed();
	
	void onFinishTestPressed();
	
}
