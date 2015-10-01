package com.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JLabel;

import com.core.Validatable;

public abstract class HeaderPanel extends BasePanelLayout implements Validatable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2760349123379119442L;
	
	protected JLabel displayLabel;

	public HeaderPanel(String title) {
		super();
		displayLabel = new JLabel(title);
		displayLabel.setHorizontalAlignment(JLabel.RIGHT);
		setPreferredSize(new Dimension(1500, 100));
		add(displayLabel, BorderLayout.NORTH);
	}

}
