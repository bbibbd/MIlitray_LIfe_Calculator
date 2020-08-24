package com.tistory.musit.MilitaryLifeCalculator;

import java.time.LocalDate;
import java.util.Calendar;

public class DayCalculator{		

	public String addDays(int days){
		Calendar now = Calendar.getInstance();
		now.add(Calendar.DATE, days);

		return now.get(Calendar.YEAR)+"³â "+(now.get(Calendar.MONTH)+1)+"¿ù "+now.get(Calendar.DATE)+"ÀÏ";
	}
	
	public Calendar subDays(int sty, int stm, int std, int mid) {
		Calendar cl = Calendar.getInstance();
		cl.set(sty,stm,std);
		cl.add(Calendar.DATE, 640-mid);
		return cl;
	}
}