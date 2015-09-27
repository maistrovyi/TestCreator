package com.model;

import java.util.ArrayList;

public class UnswerContainerModel {
	
	private int id;
	
	private int unswerNum;
	
	private ArrayList<UnswerModel> container = new ArrayList<>();

	public UnswerContainerModel(ArrayList<UnswerModel> container) {
		super();
		this.container = container;
	}

	public ArrayList<UnswerModel> getContainer() {
		return container;
	}

	public void setContainer(ArrayList<UnswerModel> container) {
		this.container = container;
	}

}
