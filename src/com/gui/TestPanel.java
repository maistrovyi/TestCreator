package com.gui;

import java.awt.BorderLayout;

import com.core.UIControlable;

public class TestPanel extends BasePanelLayout {

	DoubleHeaderPanel doubleHeaderPanel;

	FooterPanel footerPanel;

	UIControlable listener;

	BodyPanel body;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TestPanel(UIControlable listener) {
		setBorder(PADDING_BORDER);
		BorderLayout border = new BorderLayout(15, 15);
		border.setHgap(300);
		setLayout(border);
		this.listener = listener;

		createTestHeaderPart();

		createTestFooterPart();
	}

	private void createTestFooterPart() {
		footerPanel = new FooterPanel(listener);
		add(footerPanel, BorderLayout.SOUTH);
	}

	public void createTestBodyPart(int tableRows) {
		if (body != null) {
			remove(body);
			body = null;
		}
		body = new BodyPanel("Answers: ", tableRows);
		add(body, BorderLayout.CENTER);
	}

	private void createTestHeaderPart() {
		doubleHeaderPanel = new DoubleHeaderPanel(listener);
		add(doubleHeaderPanel, BorderLayout.NORTH);
	}

}
