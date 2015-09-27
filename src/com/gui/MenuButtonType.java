package com.gui;

public enum MenuButtonType {
	
	NEW("New"),
	
	OPEN("Open"),
	
	EXIT("Exit");
	
	private String menuTypeName;
	
	private MenuButtonType(String strType) {
		menuTypeName = strType;
	}

	public String getMenuTypeName() {
		return menuTypeName;
	}

	public void setMenuTypeName(String menuTypeName) {
		this.menuTypeName = menuTypeName;
	}
	
	
}
