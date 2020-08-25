package com.tistory.musit.MilitaryLifeCalculator;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;

public class EndCalculator {

	int endYear, endMonth, endDate;
	
	public int getEndYear() {
		return endYear;
	}

	public void setEndYear(int endYear) {
		this.endYear = endYear;
	}

	public int getEndMonth() {
		return endMonth;
	}

	public void setEndMonth(int endMonth) {
		this.endMonth = endMonth;
	}

	public int getEndDate() {
		return endDate;
	}

	public void setEndDate(int endDate) {
		this.endDate = endDate;
	}

	public EndCalculator(int startYear, int startMonth, int startDate) {
		LocalDate start = LocalDate.of(startYear, startMonth, startDate);
		LocalDate decreaseStart = LocalDate.of(2017, 1, 3);
		
		int dayDifference = (int) ChronoUnit.DAYS.between(decreaseStart, start);
		int minusDays = (dayDifference/14)+1;
		if(dayDifference%14==0)	minusDays -=1;
		
		
		DayCalculator dc = new DayCalculator();
		endYear = dc.subDays(startYear, startMonth, startDate, minusDays).get(Calendar.YEAR);
		endMonth = dc.subDays(startYear, startMonth, startDate, minusDays).get(Calendar.MONTH);
		endDate = dc.subDays(startYear, startMonth, startDate, minusDays).get(Calendar.DATE);

	}
}
