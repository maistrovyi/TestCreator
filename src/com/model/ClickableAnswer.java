package com.model;

public class ClickableAnswer {
	private String str;
	private boolean isSelected;
	
	private int unswerCount;

	public ClickableAnswer(String str, int i) {
		this.str = str;
		isSelected = false;
		unswerCount = i;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public int getUnswerCount() {
		return unswerCount;
	}

	public void setUnswerCount(int unswerCount) {
		this.unswerCount = unswerCount;
	}

	public void setSelected(boolean b) {
		isSelected = b;
	}

	public boolean isSelected() {
		return isSelected;
	}

	@Override
	public String toString() {
		return str;
	}
}
