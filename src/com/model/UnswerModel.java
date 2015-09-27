package com.model;

public class UnswerModel {
	
	private int id;
	
	private String unswer;
	
	private boolean isCorrect;
	
	
	public UnswerModel(int id, String unswer, boolean isCorrect) {
		super();
		this.id = id;
		this.unswer = unswer;
		this.isCorrect = isCorrect;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUnswer() {
		return unswer;
	}

	public void setUnswer(String unswer) {
		this.unswer = unswer;
	}

	public boolean isCorrect() {
		return isCorrect;
	}

	public void setCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}

}
