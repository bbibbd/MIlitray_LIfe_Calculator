package com.tistory.musit.MilitaryLifeCalculator;

import java.util.Calendar;

public class DayCalculator{		

	public String addDays(int days){
		Calendar now = Calendar.getInstance();
		now.add(Calendar.DATE, days);

		return now.get(Calendar.YEAR)+"³â "+(now.get(Calendar.MONTH)+1)+"¿ù "+now.get(Calendar.DATE)+"ÀÏ";
	}

}