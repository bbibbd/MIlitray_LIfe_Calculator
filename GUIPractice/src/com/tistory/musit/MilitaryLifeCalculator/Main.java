package com.tistory.musit.MilitaryLifeCalculator;

import java.util.Calendar;

public class Main {

	public static void main(String[] args) {

		MainFrame frame = new MainFrame("���� ����Ȱ��. ", 760, 214, 400,675);
		frame.setMenuBar();
		frame.setButtonPanel();
		frame.setDataPanel();
		frame.setResultPanel();
		
		DayCalculator dc = new DayCalculator();
		int endMonth = dc.subDays(2019, 5, 25, 30).get(Calendar.MONTH); ///wow
		


	}

}
