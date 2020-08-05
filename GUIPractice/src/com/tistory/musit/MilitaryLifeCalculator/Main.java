package com.tistory.musit.MilitaryLifeCalculator;



public class Main {

	public static void main(String[] args) {

		FrameSetting frame = new FrameSetting("군생활 계산기", 800, 200, 400,650);
		frame.setMenuBar();
		frame.setButton();
		frame.setDate();
		frame.setResult();
	}

}
