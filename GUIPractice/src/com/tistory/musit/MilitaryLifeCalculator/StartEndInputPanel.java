package com.tistory.musit.MilitaryLifeCalculator;


import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.JPanel;

public class StartEndInputPanel extends JPanel {
	
	
	public StartEndInputPanel(LayoutManager g) {
		setLayout(g);
	}

	public Dimension getPreferredSize() {
		return new Dimension(280, 60);
	}
	
	

}
