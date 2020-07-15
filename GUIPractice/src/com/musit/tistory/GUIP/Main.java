package com.musit.tistory.GUIP;

public class Main {
		
	public static void main(String[] args) {
		
		FrameSetting testFrame = new FrameSetting("my first frame", 800, 200, 400, 400);
		
		//testFrame.setButton();	
		//testFrame.setMenuBar();
		//testFrame.setJLabel();
		//testFrame.setJCheckBox();
		//testFrame.setJRadioButton();
		//testFrame.setJComboBox();
		testFrame. setContainer();
		testFrame.setVisible(true);

		
	}
}
