package com.tistory.musit.MilitaryLifeCalculator;

import java.util.Scanner;

public class MilitaryLifeCalculator {

	public static void main(String[] args) {

		
		FrameSetting frame = new FrameSetting("군생활 계산기", 800, 200, 400,555);
		frame.setButton();
		frame.setDate();
	
		int sty = frame.getSty();
		int stm=frame.getStm();
		int std=frame.getStd();
		Run gibeom = new Run("김기범",2019, 4,1, 2020, 11, 2);
		gibeom.calculating();
		frame.showResult(gibeom.getA());
		frame.setVisible(true);
		

		


	}

}
