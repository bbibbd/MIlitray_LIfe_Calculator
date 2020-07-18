package com.tistory.musit.MilitaryLifeCalculator;

public class MilitaryLifeCalculator {

	public static void main(String[] args) {
		FrameSetting frame = new FrameSetting("군생활 계산기", 800, 200, 330,555);
		frame.setButton();
		frame.setDate();
		frame.showResult();
		frame.setVisible(true);
	}

}
