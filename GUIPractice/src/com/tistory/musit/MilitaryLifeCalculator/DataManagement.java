package com.tistory.musit.MilitaryLifeCalculator;

class DataManagement{
	
	protected String name;

	protected int startYear=2019; //입대한 년도
	protected int startMonth=1;   //입대한 월
	protected int startDate=21;   //입대한 일

	protected int endYear=2020;   //전역하는 년도
	protected int endMonth=11;    //전역하는 월
	protected int endDate=20;     //전역하는 일

	protected int betweenYear;  //전체 군생활 O년
	protected int betweenMonth; //전체 군생활 O월
	protected int betweenDays;  //전체 군생활 O일

	protected int totalDays;    //전체 군생활하는 일수
	protected int remainDays;   //남은 일수
	protected int remainWeeks;  //남은 주
	protected int pastDays;     //이미 한 일수
	protected double percentage;//군생활 몇퍼센트 했는지

	public void setStartYear(int startYear){
		this.startYear = startYear;
	}

	public void setStartMonth(int startMonth){
		this.startMonth = startMonth;
	}

	public void setStartDate(int startDate){
		this.startDate = startDate;
	}  

	public void setEndYear(int endYear){
		this.endYear = endYear;
	}

	public void setEndMonth(int endMonth){
		this.endMonth = endMonth;
	}

	public void setEndDate(int endDate){
		this.endDate = endDate;
	}  

	public void setRemainWeeks(int remainWeeks){
		this.remainWeeks = remainWeeks;
	}

	public int getBetweenYear(){
		return betweenYear;
	}

	public int getBetweenMonth(){
		return betweenMonth;
	}

	public int getBetweenDay(){
		return betweenDays;
	}

	public int getTotalDays(){
		return totalDays;
	}

	public int getRemainDays(){
		return remainDays;
	}

	public int getPastDays(){
		return pastDays;
	}

	public int getRemainWeeks(){
		return remainWeeks;
	}

	public double getPercentage(){
		return percentage;
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}