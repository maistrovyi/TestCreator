package com.core;

public interface UIControlable extends Inputable, QuastionChackable {
	
	void onNewTestPressed();
	
	void onNextTestPressed();
	
	void onPrevTestPressed();
	
	void onFinishTestPressed();
	
}
